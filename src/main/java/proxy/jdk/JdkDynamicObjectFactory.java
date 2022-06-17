package proxy.jdk;

import java.lang.reflect.Proxy;

public class JdkDynamicObjectFactory {
    public static <T> T getProxiedObject(Class clazz){
        try {
            JdkProxy proxy = new JdkProxy(clazz.newInstance());
            T proxied = (T)Proxy.newProxyInstance(JdkDynamicObjectFactory.class.getClassLoader(),clazz.getInterfaces(),proxy);
            return proxied;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static void main(String[] args) {
        TestDao jdkDao = JdkDynamicObjectFactory.getProxiedObject(TestDaoImpl.class);
        jdkDao.test();
    }
}
