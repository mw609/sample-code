package reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 *反编译一个类的方法
 */
public class ReflectTest9 {
    public static void main(String[] args) throws  Exception{

        StringBuilder s = new StringBuilder();

        Class userServiceClass = Class.forName("java.lang.String");

        s.append(Modifier.toString(userServiceClass.getModifiers()));
        s.append(" class ");
        s.append(userServiceClass.getSimpleName());
        s.append(" {\n");

        // 获取所有的Method（包括私有的！）
        Method[] methods = userServiceClass.getDeclaredMethods();
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
