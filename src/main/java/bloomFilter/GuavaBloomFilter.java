package bloomFilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class GuavaBloomFilter {
    public static void main(String[] args) {
        //长度1500  整数  容错率为 0.01%
        BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(),1500,0.01);

        //
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));

        filter.put(1);
        filter.put(2);

        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));
    }
}
