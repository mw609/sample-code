package schema;

/**
 * 静态内部类
 * SingleonHolder是静态内部类，当外部类Singleton被加载的时候并不会创建
 * 任何实例，只有当Singleton.getInstance()被调用的时候，才会创建Singleton实例，
 * 这一切由JVM天然完成，所以既保证了线程安全，又实现了延迟加载
 */
public class Singleton {

    private static class SingletonHolder{
        private static Singleton instance = new Singleton();
    }
    private Singleton(){

    }

    public static Singleton getInstance(){
        return SingletonHolder.instance;
    }
}
