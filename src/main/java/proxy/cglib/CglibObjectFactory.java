package proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import proxy.jdk.TestDao;
import proxy.jdk.TestDaoImpl;

public class CglibObjectFactory {
    public static <T> T getProxiedObject(Class clazz){

        Enhancer enhancer = new Enhancer();
        //设置父类，因为cglib是针对指定的类生成一个子类，所以需要指定父类
        enhancer.setSuperclass(clazz);
        //方法回调
        enhancer.setCallback(new CglibProxy());
        T proxied = (T)enhancer.create();
        return proxied;
    }


    public static void main(String[] args) {
        TestDao cglibDao = CglibObjectFactory.getProxiedObject(TestDaoImpl.class);
        cglibDao.test();
    }
}
