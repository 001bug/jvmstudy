package classLoad_;

public class ClassLoadMechanism {
    public static void main(String[] args){
        String str=new String();
        //即使我写了java.lang.String.但Jdk还是加载了jdk的String
        //原因:当使用自定义的java.lang.String的时候,它使用的是系统加载器,会委派给引导类加载器,然后加载成功
        System.out.println("hello");
    }
}
