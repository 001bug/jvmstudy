package VirtualStack;

public class InvokedynamicTest {
    public void Lambda(Func func){
        return ;
    }
    public static void main(String[] args){
        InvokedynamicTest invokedynamicTest=new InvokedynamicTest();
        Func func= s ->{
            return true;
        };

        invokedynamicTest.Lambda(func);
        invokedynamicTest.Lambda(s->{
            return true;
        });
    }
}
/*
* public class VirtualStack.InvokedynamicTest {
  public VirtualStack.InvokedynamicTest();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public void Lambda(VirtualStack.Func);
    Code:
       0: return

  public static void main(java.lang.String[]);
    Code:
       0: new           #2                  // class VirtualStack/InvokedynamicTest
       3: dup
       4: invokespecial #3                  // Method "<init>":()V
       7: astore_1
       8: invokedynamic #4,  0 invokedynamic指令是java为了实现动态语言特性做的支持,运行的时候才会去检查类型   // InvokeDynamic #0:func:()LVirtualStack/Func;
      13: astore_2
      14: aload_1
      15: aload_2
      16: invokevirtual #5                  // Method Lambda:(LVirtualStack/Func;)V
      19: aload_1
      20: invokedynamic #6,  0              // InvokeDynamic #1:func:()LVirtualStack/Func;
      25: invokevirtual #5                  // Method Lambda:(LVirtualStack/Func;)V
      28: return
}
*/
interface Func{
    public boolean func(String str);
}