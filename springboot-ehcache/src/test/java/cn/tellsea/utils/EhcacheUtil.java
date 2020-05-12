package cn.tellsea.utils;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

public class EhcacheUtil {
    public static final String CONFIG_XML_PATH = "ehcache.xml";

    private static CacheManager cacheManager= null;

    static {
        System.setProperty("net.sf.ehcache.enableShutdownHook","true");
        ClassPathResource classPathResource = new ClassPathResource(CONFIG_XML_PATH);
        try {
            InputStream inputStream = classPathResource.getInputStream();
            cacheManager = new CacheManager(inputStream).create();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取缓存
     * @param cacheName
     * @param key
     * @return
     */
    public static Object get(String cacheName, String key) {
        Element element = getCache(cacheName).get(key);
        return element == null ? null : element.getObjectValue();
    }

    /**
     * 写入缓存
     * @param cacheName
     * @param key
     * @param value
     */
    public static void put(String cacheName, String key, Object value) {
        Element element = new Element(key, value);
        getCache(cacheName).put(element);
    }

    /**
     * 从缓存中移除
     s         * @param cacheName
     * @param key
     */
    public static void remove(String cacheName, String key) {
        getCache(cacheName).remove(key);
    }

    public static void removeAll(String cacheName) {
        getCache(cacheName).removeAll();
    }

    /**
     * @param cacheName
     * @return
     */
    public static Cache getCache(String cacheName) {
        Cache cache = cacheManager.getCache(cacheName);
        if (cache == null) {
            cacheManager.addCache(cacheName);
            cache = cacheManager.getCache(cacheName);
            //sava all the day
            cache.getCacheConfiguration().setEternal(true);
        }
        return cache;
    }

    public static CacheManager getCacheManager() {
        return cacheManager;
    }
}
