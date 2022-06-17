package reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 了解   反编译一个类的方法
 */
public class ReflectTest4 {
    public static void main(String[] args) throws  Exception {
        StringBuilder s = new StringBuilder();
        Class c = Class.forName("reflect.User");

        s.append(Modifier.toString(c.getModifiers()));
        s.append(" class ");
        s.append(c.getSimpleName());
        s.append(" {\n");

        Method[] methods = c.getDeclaredMethods();
        // 获取所有的Method（包括私有的！）
        for (Method m : methods){
            s.append("\t");
            // 获取修饰符列表
            s.append(Modifier.toString(m.getModifiers()));
            s.append(" ");
            // 获取方法的返回值类型
            s.append(m.getReturnType().getSimpleName());
            s.append(" ");
            // 获取方法名
            s.append(m.getName());
            s.append("(");
            // 方法的修饰符列表（一个方法的参数可能会有多个。）
            Class[] parameterTypes = m.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++){
                s.append(parameterTypes[i].getSimpleName());
                if (i != parameterTypes.length - 1) s.append(", ");
            }
            s.append(") {}\n");
        }
        s.append("}");
        System.out.println(s);
    }

}
