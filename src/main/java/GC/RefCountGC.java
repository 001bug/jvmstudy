package GC;

public class RefCountGC {
    //这个成员属性唯一的作用就是占用一点内存
    private byte[] bigSize=new byte[5*1024*1024];

    Object reference = null;

    public static void main(String[] args) {
        RefCountGC obj1 = new RefCountGC();
        RefCountGC obj2 = new RefCountGC();

        obj1.reference = obj2;
        obj2.reference = obj1;

        obj1 = null;
        obj2 = null;
        //显式的执行垃圾回收行为
        //这里发生GC，obj1和obj2能否被回收？
        System.gc();

    }
}
/*
* 在没有使用GC的情况下, GC的详细参数
* Heap
 PSYoungGen      total 113664K, used 18063K [0x0000000741a00000, 0x0000000749880000, 0x00000007c0000000)
  eden space 97792K, 18% used [0x0000000741a00000,0x0000000742ba3f38,0x0000000747980000)
  from space 15872K, 0% used [0x0000000748900000,0x0000000748900000,0x0000000749880000)
  to   space 15872K, 0% used [0x0000000747980000,0x0000000747980000,0x0000000748900000)
 ParOldGen       total 259584K, used 0K [0x0000000644e00000, 0x0000000654b80000, 0x0000000741a00000)
  object space 259584K, 0% used [0x0000000644e00000,0x0000000644e00000,0x0000000654b80000)
 Metaspace       used 3263K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 358K, capacity 388K, committed 512K, reserved 1048576K
* 然后调用gc后发现, 这两个对象被回收了. 说明引用计数法的垃圾回收算法是有问题的.Jvm没有采用
* */