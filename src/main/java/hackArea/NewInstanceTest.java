package hackArea;

public class NewInstanceTest {
    public static void main(String[] args){
        Object o = new Object();
    }
}
/*
*  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=2, args_size=1
         0: new           #2    去查找方法区中的Object是否被加载    // class java/lang/Object
         3: dup
         4: invokespecial #1       调用构造器     // Method java/lang/Object."<init>":()V
         7: astore_1
         8: return
      LineNumberTable:
        line 9: 0
        line 10: 8
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       9     0  args   [Ljava/lang/String;
            8       1     1   obj   Ljava/lang/Object;
}*/