package StringTable;

public class StringExer1 {
    public static void main(String[] args){
        String x="ab";
        String s=new String("a")+new String("b");//new String("ab)
        String s2=s.intern();
        //在上一行代码执行完以后，字符串常量池中并没有"ab"
		/*
		1、jdk6中：在字符串常量池（此时在永久代）中创建一个字符串"ab"
        2、jdk8中：字符串常量池（此时在堆中）中没有创建字符串"ab",而是创建一个引用，指向new String("ab")，		  将此引用返回
        3、详解看上面
		*/
        System.out.println(s2=="ab");
        System.out.println(s=="ab");
    }
}
