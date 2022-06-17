package reflect;

import java.lang.reflect.Method;

/**
 * 通过反射机制调用一个对象的方法 重点
 *
 * 反射机制，让代码具有通用性，可变化的内容都是写在配置文件中
 * 将来修改配置文件后，创建的对象不一样了，调用的方法也不同了
 * 但是java代码不需要做任何改动，这就是反射机制的魅力
 *
 */
public class ReflectTest5 {
    public static void main(String[] args) throws  Exception{

        //使用反射机制调用方法
        Class c =  Class.forName("reflect.User");
        Object o = c.newInstance();

        Method test1Mechod =  c.getDeclaredMethod("test1",String.class,int.class);
        Object value = test1Mechod.invoke(o,"名字",2);
        System.out.println(value);
    }
}
