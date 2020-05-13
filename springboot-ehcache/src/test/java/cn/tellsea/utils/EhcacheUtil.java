package cn.tellsea.utils;


import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.Configuration;
import org.ehcache.core.EhcacheManager;
import org.ehcache.xml.XmlConfiguration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class EhcacheUtil {
    public static final String CONFIG_XML_PATH = "ehcache.xml";

    private static EhcacheManager cacheManager= null;

    static {
        System.setProperty("net.sf.ehcache.enableShutdownHook","true");
        try {
            ClassPathResource classPathResource = new ClassPathResource(CONFIG_XML_PATH);
            Configuration xmlConfig = new XmlConfiguration(classPathResource.getURL());
            cacheManager = new EhcacheManager(xmlConfig);
            cacheManager.init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static EhcacheManager getCacheManager() {
        return cacheManager;
    }
}
