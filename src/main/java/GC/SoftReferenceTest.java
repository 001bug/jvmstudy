package GC;
/*
* 软引用这个概念的应用*/
import java.lang.ref.SoftReference;

public class SoftReferenceTest {
    public static class User{
        public User(int id, String name){
            this.id=id;
            this.name=name;
        }
        public int id;
        public String name;
        @Override
        public String toString(){
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
    public static void main(String[] args){
        SoftReference<User> userSoftRef = new SoftReference<User>(new User(1, "songhk"));
        //从软引用中重新获得强引用对象
        System.out.println(userSoftRef.get());

        System.out.println("---目前内存还不紧张---");
        System.gc();
        System.out.println("After GC:");
        System.out.println(userSoftRef.get());

        System.out.println("---目前内存紧张---");
        try {
            //让系统认为内存资源紧张、不够
//            byte[] b = new byte[1024 * 1024 * 7];
            byte[] b = new byte[1024 * 7168 - 635 * 1024];
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            //再次从软引用中获取数据
            System.out.println(userSoftRef.get());//在报OOM之前，垃圾回收器会回收软引用的可达对象。
        }
    }
}
