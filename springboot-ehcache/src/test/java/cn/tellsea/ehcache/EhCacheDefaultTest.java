package cn.tellsea.ehcache;

import org.junit.Test;

/**
 * @author James
 */
public class EhCacheDefaultTest {

    /**
     * If the path is a Java System Property it is replaced by its value in the
     *     running VM.
     * The following properties are translated:
     * user.home - User's home directory
     * user.dir - User's current working directory
     * java.io.tmpdir - Default temp file path
     * ehcache.disk.store.dir - A system property you would normally specify on the command line
     * e.g. java -Dehcache.disk.store.dir=/u01/myapp/diskdir ...
     */
     @Test
     public void testJvmDefaultConfig() {
         String userHome = System.getProperty("user.home");
         String userDir = System.getProperty("user.dir");
         String ioTmpDir = System.getProperty("java.io.tmpdir");
         System.out.println(userHome);
         System.out.println(userDir);
         System.out.println(ioTmpDir);
     }
}
