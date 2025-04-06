package java.lang;

public class String {
    static{
        System.out.println("我是自定义的String类的静态代码块");
    }
    //根据双亲委派机制, 它到引导类加载器,原本jdk的Stirng是没有main方法的,所以直接报错,说找不到main方法
//    public static void main(String[] args){
//        System.out.println("hello world");
//    }
}
