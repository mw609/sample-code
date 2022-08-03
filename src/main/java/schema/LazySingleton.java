package schema;

/**
 * 单例   懒汉
 * 所谓懒加载，就是知道第一次被调用时才被加载。
 * 其实现需要考虑并发问题和指令重排
 */
public class LazySingleton {

    private volatile static LazySingleton instance;

    private LazySingleton() {

    }


    public static LazySingleton getInstance(){
        if(instance==null){
            synchronized (LazySingleton.class){
                if(instance==null){
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
