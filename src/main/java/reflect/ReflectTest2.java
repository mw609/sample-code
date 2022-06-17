package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取到Class，能干什么？
 *     通过Class的newInstance()方法来实例化对象。
 *     注意：newInstance()方法内部实际上调用了无参数构造方法，必须保证无参构造存在才可以。
 */
public class ReflectTest2 {
    public static void main(String[] args) throws Exception {
        // 下面这段代码是以反射机制的方式创建对象。

        // 通过反射机制，获取Class，通过Class来实例化对象
        Class c = Class.forName("reflect.User");
        // newInstance() 这个方法会调用User这个类的无参数构造方法，完成对象的创建。
        // 重点是：newInstance()调用的是无参构造，必须保证无参构造是存在的！
        Object obj = c.newInstance();
        System.out.println(obj);
    }
}
