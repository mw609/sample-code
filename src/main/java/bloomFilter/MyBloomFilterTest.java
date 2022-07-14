package bloomFilter;

public class MyBloomFilterTest {

    public static void main(String[] args) {
        MyBloomFilter filter = new MyBloomFilter();
        System.out.println("测试".hashCode()+":");
        filter.hashValue("测试");
        System.out.println(2<<24);
        System.out.println(10<<1);
    }
}
