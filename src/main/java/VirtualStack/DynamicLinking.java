package VirtualStack;

public class DynamicLinking {
    int num=10;
    public void methodA(){
        System.out.println("methodA()....");
    }
    public static void main(String[] args){
        DynamicLinking dynamicLinking=new DynamicLinking();
        dynamicLinking.methodA();
    }
}
/* 在Constant pool中#5就是符号引用
* public class VirtualStack.DynamicLinking
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #9.#27         // java/lang/Object."<init>":()V
   #2 = Fieldref           #6.#28         // VirtualStack/DynamicLinking.num:I
   #3 = Fieldref           #29.#30        // java/lang/System.out:Ljava/io/PrintStream;
   #4 = String             #31            // methodA()....
   #5 = Methodref          #32.#33继续映射        // java/io/PrintStream.println:(Ljava/lang/String;)V
   #6 = Class              #34            // VirtualStack/DynamicLinking
   #7 = Methodref          #6.#27         // VirtualStack/DynamicLinking."<init>":()V
   #8 = Methodref          #6.#35         // VirtualStack/DynamicLinking.methodA:()V
   #9 = Class              #36            // java/lang/Object
  #10 = Utf8               num
  #11 = Utf8               I
  #12 = Utf8               <init>
  #13 = Utf8               ()V
  #14 = Utf8               Code
  #15 = Utf8               LineNumberTable
  #16 = Utf8               LocalVariableTable
  #17 = Utf8               this
  #18 = Utf8               LVirtualStack/DynamicLinking;
  #19 = Utf8               methodA
  #20 = Utf8               main
  #21 = Utf8               ([Ljava/lang/String;)V
  #22 = Utf8               args
  #23 = Utf8               [Ljava/lang/String;
  #24 = Utf8               dynamicLinking
  #25 = Utf8               SourceFile
  #26 = Utf8               DynamicLinking.java
  #27 = NameAndType        #12:#13        // "<init>":()V
  #28 = NameAndType        #10:#11        // num:I
  #29 = Class              #37            // java/lang/System
  #30 = NameAndType        #38:#39        // out:Ljava/io/PrintStream;
  #31 = Utf8               methodA()....
  #32 = Class              #40            // java/io/PrintStream
  #33 = NameAndType        #41:#42        // println:(Ljava/lang/String;)V
  #34 = Utf8               VirtualStack/DynamicLinking
  #35 = NameAndType        #19:#13        // methodA:()V
  #36 = Utf8               java/lang/Object
  #37 = Utf8               java/lang/System
  #38 = Utf8               out
  #39 = Utf8               Ljava/io/PrintStream;
  #40 = Utf8               java/io/PrintStream
  #41 = Utf8               println
  #42 = Utf8               (Ljava/lang/String;)V
{
  int num;
    descriptor: I
    flags:

  public VirtualStack.DynamicLinking();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=2, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: aload_0
         5: bipush        10
         7: putfield      #2                  // Field num:I
        10: return
      LineNumberTable:
        line 3: 0
        line 4: 4
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      11     0  this   LVirtualStack/DynamicLinking;

  public void methodA();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=2, locals=1, args_size=1
         0: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
         3: ldc           #4                  // String methodA()....
         5: invokevirtual #5 从动态连接池映射到常量池的符号引用                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
         8: return
      LineNumberTable:
        line 6: 0
        line 7: 8
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       9     0  this   LVirtualStack/DynamicLinking;

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=2, args_size=1
         0: new           #6                  // class VirtualStack/DynamicLinking
         3: dup
         4: invokespecial #7                  // Method "<init>":()V
         7: astore_1
         8: aload_1
         9: invokevirtual #8                  // Method methodA:()V
        12: return
      LineNumberTable:
        line 9: 0
        line 10: 8
        line 11: 12
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      13     0  args   [Ljava/lang/String;
            8       5     1 dynamicLinking   LVirtualStack/DynamicLinking;
}
*/