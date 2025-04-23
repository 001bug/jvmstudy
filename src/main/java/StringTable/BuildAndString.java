package StringTable;

public class BuildAndString {
    public static void main(String[] args){
        BuildAndString buildAndString=new BuildAndString();
        long start = System.currentTimeMillis();
        buildAndString.method1(100000);//4014ms
        //buildAndString.method2(100000);//7ms
        long end = System.currentTimeMillis();
        System.out.println("time: "+(end-start));
    }
    public void method1(int count){
        String s1="";
        for (int i=0;i<count;i++){
            s1=s1+"a";
        }
    }
    public  void method2(int count){
        StringBuilder s1=new StringBuilder();
        for (int i=0;i<count;i++){
            s1.append("a");
        }
    }
}
