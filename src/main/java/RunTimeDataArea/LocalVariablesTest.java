package RunTimeDataArea;

import java.util.Date;

public class LocalVariablesTest {
    private int count=0;
    public static void main(String[] args){
        LocalVariablesTest test= new LocalVariablesTest();
        int num=10;

    }

    public static void testStatic(){
        LocalVariablesTest test = new LocalVariablesTest();
        Date data=new Date();
        int count=10;
        System.out.println(count);
    }
    public LocalVariablesTest(){
        this.count=1;
    }

    //关于slot的理解,通过jclasslib中的code/LocalVariableTable(局部变量表)验证this放在第一位.
    public void test1(){
        Date date = new Date();
        String name1 = "atguigu.com";
        test2(date, name1);
        System.out.println(date + name1);
    }
    public String test2(Date dateP, String name2) {
        dateP = null;
        name2 = "songhongkang";
        double weight = 130.5;//占据两个slot
        char gender = '男';
        return dateP + name2;
    }
    public void test3() {
        this.count++;
    }

    public void test4() {
        int a = 0;
        {
            int b = 0;
            b = a + 1;
        }
        //变量c使用之前已经销毁的变量b占据的slot的位置
        int c = a + 1;
    }
}
/*
* public class RunTimeDataArea.LocalVariablesTest {
  public static void main(java.lang.String[]);
    Code:
       0: new           #1                  // class RunTimeDataArea/LocalVariablesTest
       3: dup
       4: invokespecial #2                  // Method "<init>":()V
       7: astore_1
       8: bipush        10
      10: istore_2
      11: return

  public static void testStatic();
    Code:
       0: new           #1                  // class RunTimeDataArea/LocalVariablesTest
       3: dup
       4: invokespecial #2                  // Method "<init>":()V
       7: astore_0
       8: new           #3                  // class java/util/Date
      11: dup
      12: invokespecial #4                  // Method java/util/Date."<init>":()V
      15: astore_1
      16: bipush        10
      18: istore_2
      19: getstatic     #5                  // Field java/lang/System.out:Ljava/io/PrintStream;
      22: iload_2
      23: invokevirtual #6                  // Method java/io/PrintStream.println:(I)V
      26: return

  public RunTimeDataArea.LocalVariablesTest();
    Code:
       0: aload_0
       1: invokespecial #7                  // Method java/lang/Object."<init>":()V
       4: aload_0
       5: iconst_0
       6: putfield      #8                  // Field count:I
       9: aload_0
      10: iconst_1
      11: putfield      #8                  // Field count:I
      14: return

  public void test1();
    Code:
       0: new           #3                  // class java/util/Date
       3: dup
       4: invokespecial #4                  // Method java/util/Date."<init>":()V
       7: astore_1
       8: ldc           #9                  // String atguigu.com
      10: astore_2
      11: aload_0
      12: aload_1
      13: aload_2
      14: invokevirtual #10                 // Method test2:(Ljava/util/Date;Ljava/lang/String;)Ljava/lang/String;
      17: pop
      18: getstatic     #5                  // Field java/lang/System.out:Ljava/io/PrintStream;
      21: new           #11                 // class java/lang/StringBuilder
      24: dup
      25: invokespecial #12                 // Method java/lang/StringBuilder."<init>":()V
      28: aload_1
      29: invokevirtual #13                 // Method java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      32: aload_2
      33: invokevirtual #14                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      36: invokevirtual #15                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      39: invokevirtual #16                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      42: return

  public java.lang.String test2(java.util.Date, java.lang.String);
    Code:
       0: aconst_null
       1: astore_1
       2: ldc           #17                 // String songhongkang
       4: astore_2
       5: ldc2_w        #18                 // double 130.5d
       8: dstore_3
       9: sipush        30007
      12: istore        5
      14: new           #11                 // class java/lang/StringBuilder
      17: dup
      18: invokespecial #12                 // Method java/lang/StringBuilder."<init>":()V
      21: aload_1
      22: invokevirtual #13                 // Method java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      25: aload_2
      26: invokevirtual #14                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      29: invokevirtual #15                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      32: areturn

  public void test3();
    Code:
       0: aload_0
       1: dup
       2: getfield      #8                  // Field count:I
       5: iconst_1
       6: iadd
       7: putfield      #8                  // Field count:I
      10: return

  public void test4();
    Code:
       0: iconst_0
       1: istore_1
       2: iconst_0
       3: istore_2
       4: iload_1
       5: iconst_1
       6: iadd
       7: istore_2
       8: iload_1
       9: iconst_1
      10: iadd
      11: istore_2
      12: return
}

* */