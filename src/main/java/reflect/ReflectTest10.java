package reflect;

import java.lang.reflect.Method;

/**
 * 重点：必须掌握，通过反射机制怎么调用一个对象的方法？
 */
public class ReflectTest10 {

    public static void main(String[] args)  throws Exception{
        //使用反射机制调用方法
        Class userServiceClass = Class.forName("reflect.User");
        // 创建对象
        Object obj = userServiceClass.newInstance();
        // 获取Method
        Method loginMethod = userServiceClass.getDeclaredMethod("test1", String.class, int.class);
//        Method loginMethod = userServiceClass.getDeclaredMethod("login");//注：没有形参就不传
        // 调用方法
        // 调用方法有几个要素？ 也需要4要素。
        // 反射机制中最最最最最重要的一个方法，必须记住。
        /*
            四要素：
            test1方法
            obj对象
            "admin",123 实参
            retValue 返回值
         */
        Object resValues = loginMethod.invoke(obj, "admin", 123);//注：方法返回值是void 结果是null
        System.out.println(resValues);


    }

}
