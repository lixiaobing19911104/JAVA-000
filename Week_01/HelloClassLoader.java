import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author lixiaobing
 * @date 2020-10-17 13:06
 * @Description:
 */
public class HelloClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if ("Hello".equals(name)) {
            try (InputStream inputStream = this.getClass().getResourceAsStream("Hello.xlass");
                 ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                byte[] buffer = new byte[1024 * 4];
                int    n;
                while ((n = inputStream.read(buffer)) != -1) {
                    out.write(buffer, 0, n);
                }
                byte[] bytes = out.toByteArray();
                for (int i = 0; i < bytes.length; i++) {
                    bytes[i] = (byte) (255 - bytes[i]);
                }
                return defineClass(name, bytes, 0, bytes.length);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return super.findClass(name);
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        HelloClassLoader helloClassLoader = new HelloClassLoader();
        Class<?>         hello            = helloClassLoader.loadClass("Hello");
        Object           instance         = hello.newInstance();
        Method           helloMethod      = hello.getMethod("hello");
        helloMethod.invoke(instance);
    }
}
