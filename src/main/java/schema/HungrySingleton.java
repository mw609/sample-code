package schema;

/**
 * 饿汉
 * 与懒加载相对应，预加载是在类加载时就已经初始化好了，所以是天然线程安全的。
 */
public class HungrySingleton {
    private static final HungrySingleton instance = new HungrySingleton();
    private HungrySingleton(){

    }
    public static HungrySingleton getInstance(){
        return instance;
    }
}
