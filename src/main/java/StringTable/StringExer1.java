package StringTable;

public class StringExer1 {
    public static void main(String[] args) {

        String s = new String("1");//这行为会在常量池中创建一个1
        s.intern();//调用此方法之前，字符串常量池中已经存在了"1"
        String s2 = "1";
        System.out.println(s == s2);//jdk6：false   jdk7/8：false
        //"11"不存在常量池中
        String s3 = new String("1") + new String("1");//
        //s3.intern(),如果常量池中,那就不改变. 如果没有那就在常量池复制s3在堆区的引用
        s3.intern();

        String s4 = "11";//s4变量记录的地址：使用的是上一行代码代码执行时，在常量池中生成的"11"的地址
        System.out.println(s3 == s4);//jdk6：false  jdk7/8：true
    }
}
