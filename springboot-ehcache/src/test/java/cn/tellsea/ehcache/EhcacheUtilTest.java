package cn.tellsea.ehcache;

import cn.tellsea.bean.User;
import cn.tellsea.utils.EhcacheUtil;
import org.ehcache.Cache;
import org.ehcache.Status;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.Configuration;
import org.ehcache.core.EhcacheManager;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.Map;

/**
 * @author James
 */
public class EhcacheUtilTest {

    @Test
    public void testCacheManage() {
        EhcacheManager cacheManager = EhcacheUtil.getCacheManager();
        Configuration configuration = cacheManager.getRuntimeConfiguration();
        Status status = cacheManager.getStatus();
        Assert.assertEquals("AVAILABLE", status.name());
//        Assert.assertTrue(names.length > 0);
        Map<String, CacheConfiguration<?, ?>> cacheConfigurationMap = configuration.getCacheConfigurations();
        Assert.assertTrue(cacheConfigurationMap.size() > 0);
    }

    @Test
    public void testCachePut() {
        EhcacheManager cacheManager = EhcacheUtil.getCacheManager();
        Cache<Long, User> cache = cacheManager.getCache("users", Long.class, User.class);
        for (long i = 0; i < 100; i++) {
            User user = new User();
            user.setId(i);
            user.setName("cd");
            cache.put(i, user);
        }
        // 持久化到磁盘需要 close
        cacheManager.close();
    }

    @Test
    public void testCacheGet() {
        EhcacheManager cacheManager = EhcacheUtil.getCacheManager();
        Cache<Long, User> cache = cacheManager.getCache("users", Long.class, User.class);
        Iterator<Cache.Entry<Long, User>> cacheIterator = cache.iterator();
        while (cacheIterator.hasNext()) {
            Cache.Entry<Long, User> cacheEntry = cacheIterator.next();
            Long key = cacheEntry.getKey();
            User user = cacheEntry.getValue();
            System.out.println("key :" + key + ", user :" + user);
        }
    }
}
