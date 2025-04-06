package java.lang;
/*
* 运行这段代码会爆安全问题.由系统类加载器加载.然后委派给引导类加载器,
* 发现是java.lang包,但又没有此类白名单. 从而报错
* */
public class SafeClass {
    public static void main(String[] args){
        System.out.println("yes");
    }
}
