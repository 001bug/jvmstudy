package classLoad_;

public class ClassInitTest {
    private static int num = 1;//clint 0-->1-->2

    static{
        num = 2;
        number = 20;//prepare0-->20-->10
        System.out.println(num);
        //System.out.println(number);//报错：非法的前向引用。
    }

    /**
     * 1、linking之prepare: number = 0 --> initial: 20 --> 10
     * 2、这里因为静态代码块出现在声明变量语句前面，所以之前被准备阶段为0的number变量会
     * 首先被初始化为20，再接着被初始化成10（这也是面试时常考的问题哦）
     *
     */
    private static int number = 10;

    public static void main(String[] args) {
        System.out.println(ClassInitTest.num);//2
        System.out.println(ClassInitTest.number);//10
    }
}
