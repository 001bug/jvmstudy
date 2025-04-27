package hackArea;

import java.util.ArrayList;
import java.util.List;
/**
 * 测试MinorGC 、 MajorGC、FullGC
 * -Xms9m -Xmx9m -XX:+PrintGCDetails
 * @author shkstart  shkstart@126.com
 * @create 2020  14:19
 */
public class GCTest {
    public static void main(String[] args){
        int i=0;
        try{
            List<String> list=new ArrayList<>();
            String a="atguigu.com";
            while(true){
                list.add(a);
                a=a+a;
                i++;
            }
        }catch (Throwable t){
            t.printStackTrace();
            System.out.println("遍历次数: "+i);
        }
    }
}
/*
* [GC (Allocation Failure) [PSYoungGen: 2015K->488K(2560K)] 2015K->827K(9728K), 0.0033135 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[GC (Allocation Failure) [PSYoungGen: 2396K->512K(2560K)] 2735K->2253K(9728K), 0.0019164 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[GC (Allocation Failure) [PSYoungGen: 1973K->480K(2560K)] 3714K->2973K(9728K), 0.0022036 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]这段话表示年轻代总空间为2560K, 已使用空间为1973,经过垃圾回收后480k
[Full GC (Ergonomics) [PSYoungGen: 1242K->0K(2560K)] [ParOldGen: 6717K->4845K(7168K)] 7959K->4845K(9728K), [Metaspace: 3252K->3252K(1056768K)], 0.0125853 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
[GC (Allocation Failure) [PSYoungGen: 0K->0K(2560K)] 4845K->4845K(9728K), 0.0016033 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[Full GC (Allocation Failure) [PSYoungGen: 0K->0K(2560K)] [ParOldGen: 4845K->4827K(7168K)] 4845K->4827K(9728K), [Metaspace: 3252K->3252K(1056768K)], 0.0140359 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
遍历次数: 16*/