package cn.tellsea.ehcache;

import cn.tellsea.bean.User;
import cn.tellsea.utils.EhcacheUtil;
import net.sf.ehcache.CacheManager;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author James
 */
public class EhcacheUtilTest {

    @Test
    public void testCacheManage() {
        CacheManager cacheManager = EhcacheUtil.getCacheManager();
        String[] names = cacheManager.getCacheNames();
        Assert.assertTrue(names.length > 0);
        String path = cacheManager.getConfiguration().getDiskStoreConfiguration().getPath();
        Assert.assertEquals("E:/Data/ehcache", path);
    }

    @Test
    public void testCachePut() {
        User user = new User();
        user.setId(1L);
        user.setName("cd");
        user.setPassword("James");
        EhcacheUtil.put("users", user.getId().toString(), user);
        EhcacheUtil.getCacheManager().shutdown();
    }
}
