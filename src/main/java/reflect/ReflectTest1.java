package reflect;

public class ReflectTest1 {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class c = Class.forName("reflect.User");
        Class c1 = new User().getClass();
        Class c2 = User.class;
        // 重点是：newInstance()调用的是无参构造，必须保证无参构造是存在的！   类中无构造方法时，使用默认的无参构造方法，有构造方法，则默认的构造方法失效
        Object obj = c.newInstance();
        System.out.println(obj);
    }
}
