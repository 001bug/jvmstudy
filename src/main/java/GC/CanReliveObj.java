package GC;
/*
* 测试finalization的机制
* */
public class CanReliveObj {
    public static CanReliveObj obj;//类变量,属于GC Roots

    protected void finalize() throws Throwable{
        super.finalize();
        System.out.println("调用当前重写的finalize()方法");
        obj=this; //让死去的对象复活
    }

    public static void main(String[] args){
        try{
            obj=new CanReliveObj();
            obj=null;
            System.gc();
            System.out.println("第一次gc");
            //因为Finalizer线程优先级很低,暂定2秒, 以等待它
            Thread.sleep(2000);
            if(obj==null){
                System.out.println("obj is null");
            }else{
                System.out.println("obj is still alive");
            }
            System.out.println("第二次gc");
            obj=null;
            System.gc();
            Thread.sleep(2000);
            if(obj==null){
                System.out.println("obj is null");
            }else{
                System.out.println("obj is still alive");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
