package reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 *作为了解内容（不需要掌握）：
 *     反射Method
 */
public class ReflectTest8 {

    public static void main(String[] args) throws ClassNotFoundException {
        Class userServiceClass = Class.forName("reflect.User");
        // 获取所有的Method（包括私有的！）
        Method[] methods = userServiceClass.getDeclaredMethods();
        for (Method m : methods){
            // 获取修饰符列表
            System.out.println(Modifier.toString(m.getModifiers()));
            // 获取方法的返回值类型
            System.out.println(m.getReturnType().getSimpleName());
            // 获取方法名
            System.out.println(m.getName());
            // 方法的修饰符列表（一个方法的参数可能会有多个。）
            Class[] parameterTypes = m.getParameterTypes();
            for (Class pts : parameterTypes){
                System.out.println(pts.getSimpleName());
            }
            System.out.println("------------------------");
        }
    }
}
