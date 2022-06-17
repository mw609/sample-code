package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JdkProxy implements InvocationHandler {
   //代理对象
    Object target;



    public JdkProxy(Object target) {
        this.target = target;
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk dynamic before");
        //调用目标类中的方法
        Object object = method.invoke(target,args);
        System.out.println("jdk dynamic after");
        return object;
    }
}
