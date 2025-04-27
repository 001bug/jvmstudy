package hackArea;
/*
* 给对象的属性赋值的操作：
* ① 属性的默认初始化 - ② 显式初始化 / ③ 代码块中初始化 - ④ 构造器中初始化
* */
public class InitTest {
    int id=1001;
    String name;

    Account account;

    {
        name="客户";
    }
    public InitTest(){
        account=new Account();
    }
}

class Account{}
/*
*  0 aload_0
 1 invokespecial #1 <java/lang/Object.<init> : ()V>
 4 aload_0
 5 sipush 1001 属性的默认初始化
 8 putfield #2 <hackArea/InitTest.id : I>
11 aload_0
12 ldc #3 <客户> 显示初始化
14 putfield #4 <hackArea/InitTest.name : Ljava/lang/String;>
17 aload_0
18 new #5 <hackArea/Account>
21 dup
22 invokespecial #6 <hackArea/Account.<init> : ()V>
25 putfield #7 <hackArea/InitTest.account : LhackArea/Account;>
28 return
*/