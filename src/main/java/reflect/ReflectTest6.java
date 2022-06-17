package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * 反编译一个类的构造方法Constructor
 */
public class ReflectTest6 {

    public static void main(String[] args) throws  Exception {
        StringBuilder s = new StringBuilder();

        Class userClass = Class.forName("reflect.User");

        s.append(Modifier.toString(userClass.getModifiers()));
        s.append(" class ");
        s.append(userClass.getSimpleName());
        s.append("{\n");

        Constructor[] constructors = userClass.getDeclaredConstructors();

        for (Constructor c : constructors){
            //public Vip(int no, String name, String birth, boolean sex) {
            s.append("\t");
            s.append(Modifier.toString(c.getModifiers()));
            s.append(" ");
//            s.append(c.getName());//包名+类名
            s.append(userClass.getSimpleName());//类名
            s.append("(");
            Class[] parameterTypes = c.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++){
                s.append(parameterTypes[i].getSimpleName());
                if (i != parameterTypes.length - 1 ) s.append(", ");
            }
            s.append("){}\n");
        }

        s.append("}");
        System.out.println(s);

    }
}
