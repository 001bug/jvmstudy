package GC;

public class LocalVarGC {
    public void localVarGC1(){
        byte[] bigSize=new byte[10*1024*1024];//可达对象不能gc
        System.gc();
    }
    public void localVarGC2(){
        byte[] bigSize=new byte[10*1024*1024];
        bigSize=null;
        System.gc();
    }
    public void localVarGC3(){
        {
            byte[] bigSize=new byte[10*1024*1024];
        }
        System.gc();
    }
    //这个buffer对象在方法执行完以后就会被回收,首先他是一个局部变量.它出了局部变量的作用域,它的引用就会失效.再执行value,引用就会被占用
    public void localVarGC4(){
        {
            byte[] buffer=new byte[10*1024*1024];
        }
        int value=10;
        System.gc();
    }
    public static void main(String[] args){
        LocalVarGC obj=new LocalVarGC();
    }
}
