package reflect;

import java.io.FileReader;
import java.util.Properties;

/**
 * 验证反射机制的灵活性
 * java代码写一遍，在不改变java源代码的基础之上，可以做到不同对象的实例化
 * 非常灵活，  符合ocp开闭原则：对扩展开放，对修改关闭
 */
public class ReflectTest3 {

    public static void main(String[] args) throws Exception {
      //以下代码是灵活的，代码不需要改动，可以修改配置文件，配置文件修改之后，可以创建出不同的实例对象
        //通过IO流读取reflectuser.properties文件
        FileReader reader = new FileReader("src/main/resources/reflectuser.properties");

        Properties pro = new Properties();

        //加载
        pro.load(reader);
        reader.close();

        String className = pro.getProperty("className");
        // 通过反射机制实例化对象
        Class c = Class.forName(className);
        Object obj = c.newInstance();
        System.out.println(obj);
    }
}
