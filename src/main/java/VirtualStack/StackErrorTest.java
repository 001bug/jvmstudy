package VirtualStack;
/*
* 测试java虚拟机栈的大小,设置java虚拟机栈的大小
* 结果count是11409
* */
public class StackErrorTest {
    public static int count=1;
    public static void main(String[] args){
        System.out.println(count);
        count++;
        main(args);
    }
}
