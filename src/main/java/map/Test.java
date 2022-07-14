package map;

import java.util.HashMap;

public class Test {

    public static void main(String[] args) {

        FourthlyHashMap map = new FourthlyHashMap();
        for(int i=0;i<100;i++){
            map.put("测试"+i,"测试map"+i);
        }
        System.out.println(map.size());
        for(int i= 0;i<100;i++){
            System.out.println(map.get("测试"+i));
        }

        FourthlyHashMap map1 = new FourthlyHashMap();
        map1.put("测试2","我是测试2");
        map1.put("测试2","我又被添加了");
        System.out.println(map1.get("测试2"));
    }



}
