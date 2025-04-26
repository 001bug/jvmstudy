package GC;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
/*
* 虚引用的demao*/
public class PhantomReferenceTest {
    public static PhantomReferenceTest obj;//当前类对象的声明
    static ReferenceQueue<PhantomReferenceTest> phantomQueue = null;//引用队列
    public static class CheckRefQueue extends Thread{
        @Override
        public void run(){
            while(true){
                if(phantomQueue.poll()!=null){
                    PhantomReference<PhantomReferenceTest> objt=null;
                    try{
                        objt=(PhantomReference<PhantomReferenceTest>)phantomQueue.remove();
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    if(objt!=null){
                        System.out.println("追踪垃圾回收过程: PhantomReferenceTest实例被GC了");
                    }
                }
            }
        }
    }
    @Override
    protected void finalize() throws Throwable{//finalize()方法只能被调用一次！
        super.finalize();
        System.out.println("调用当前类的finalize()方法");
        obj = this;
    }
    public static void main(String[] args){
        Thread t=new CheckRefQueue();
        t.setDaemon(true);//设置为守护线程：当程序中没有非守护线程时，守护线程也就执行结束。
        t.start();
        phantomQueue=new ReferenceQueue<PhantomReferenceTest>();
        obj=new PhantomReferenceTest();
        //构造了PhantomReferenceTest对象的虚引用,然后指定引用队列
        PhantomReference<PhantomReferenceTest> phantomRef=
                new PhantomReference<PhantomReferenceTest>(obj,phantomQueue);
        try{
            //不可获取虚引用中的对象
            System.out.println(phantomRef.get());
            System.out.println("第一次gc");
            //将强引用去掉
            obj=null;
            //第一次gc, 由于对象处于可复活, GC无法回收该对象
            System.gc();
            Thread.sleep(1000);
            if(obj==null){
                System.out.println("obj is null");
            }else{
                System.out.println("obj可用");
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
