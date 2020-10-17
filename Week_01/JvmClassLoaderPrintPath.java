import sun.misc.Launcher;

import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author lixiaobing
 * @date 2020-10-17 14:20
 * @Description:
 */
public class JvmClassLoaderPrintPath {
    public static void main(String[] args) {
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        System.out.println("启动类加载器");
        for (URL urL : urLs) {
            System.out.println(" ==> " + urL.toExternalForm());
        }

        printClassLoader("扩展类加载器", JvmClassLoaderPrintPath.class.getClassLoader().getParent());
        printClassLoader("应用类加载器", JvmClassLoaderPrintPath.class.getClassLoader());
    }

    private static void printClassLoader(String name, ClassLoader classLoader) {
        if (Objects.nonNull(classLoader)) {
            System.out.println(name + " ClassLoader => " + classLoader.toString());
            printURLForClassLoader(classLoader);
        } else {
            System.out.println(name + " ClassLoader => null");
        }
    }

    private static void printURLForClassLoader(ClassLoader classLoader) {
        Object    ucp  = insightField(classLoader, "ucp");
        Object    path = insightField(ucp, "path");
        ArrayList ps   = (ArrayList) path;
        for (Object p : ps) {
            System.out.println(" ===> " + p.toString());
        }
    }

    private static Object insightField(Object obj, String fName) {
        try {
            Field f;
            if (obj instanceof URLClassLoader) {
                f = URLClassLoader.class.getDeclaredField(fName);
            } else {
                f = obj.getClass().getDeclaredField(fName);
            }
            f.setAccessible(true);
            return f.get(obj);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

}
