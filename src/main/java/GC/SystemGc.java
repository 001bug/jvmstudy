package GC;
/*
* 实验发现. 调用System.gc()方法, 并不能保证JVM会立即执行GC.
* */
public class SystemGc {
    public static void main(String [] args){
        new SystemGc();
        System.gc();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("GC被调用,垃圾被回收");
    }
}
