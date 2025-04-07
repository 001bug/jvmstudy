package RunTimeDataArea;

public class OperationStack {
    public int getSum(){
        int m=10;
        int n=20;
        int k= n+m;
        int test=800;
        return k;
    }
    public void testGetSum(){
        //获取上一个栈顶返回的结果, 并保存在操作数栈中
        int i=getSum();

    }
    public static void main(String[] args){
        OperationStack operationStack = new OperationStack();
        operationStack.testGetSum();
    }
}
/*
* public class RunTimeDataArea.OperationStack {
  public RunTimeDataArea.OperationStack();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public int getSum();
    Code:
       0: bipush        10 开头的b表示是byte类型,说明操作数栈它会尽可能的用小类型存储数据
       2: istore_1         这里又把它装换成int类型存进局部变量表
       3: bipush        20
       5: istore_2
       6: iload_2
       7: iload_1
       8: iadd
       9: istore_3
      10: sipush        800
      13: istore        4
      15: iload_3
      16: ireturn

  public void testGetSum();
    Code:
       0: aload_0       从上一个栈帧获取结果
       1: invokevirtual #2                  // Method getSum:()I
       4: istore_1
       5: return

  public static void main(java.lang.String[]);
    Code:
       0: new           #3                  // class RunTimeDataArea/OperationStack
       3: dup
       4: invokespecial #4                  // Method "<init>":()V
       7: astore_1
       8: aload_1
       9: invokevirtual #5                  // Method testGetSum:()V
      12: return
}
*/
