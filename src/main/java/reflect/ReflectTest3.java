package reflect;

import java.lang.reflect.Field;

/**
 * 怎么通过反射机制访问一个java对象属性?
 * 给属性赋值set
 * 获取属性的值get
 */
public class ReflectTest3 {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //使用反射机制给属性赋值
        Class c = Class.forName("reflect.User");
        Object o = c.newInstance();

        //获取name属性  根据属性的名称来获取field
        Field nameField = c.getDeclaredField("name");

        // 给o对象(User对象)的name属性赋值
        /**
         * 要素1 obj对象
         * 要素2 name属性
         * 要素3 123值
         */
        nameField.set(o,"123");

        System.out.println(nameField.get(o));
        User user = (User)o;
        System.out.println(user.getName());

        //访问私有属性
        Field ageField = c.getDeclaredField("age");
        //打破封装（反射机制的缺点：打破封装，可能会给不法分子留下机会）
        //这样设置完之后，在外部也是可以访问private的
        ageField.setAccessible(true);
        ageField.set(o,2);
        System.out.println(((User)o).getAge());

    }
}
