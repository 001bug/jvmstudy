package classLoad_;

import sun.misc.Launcher;

import java.net.URL;

//验证bootstrapClassLoader能够加载哪些路径
public class BootStrapClassLoader_ {
    public static void main(String[] args){
        System.out.println("**********启动类加载器**************");
        //通过方法获取能够加载的路劲
        URL[] urLs = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL element : urLs) {
            System.out.println(element.toExternalForm());
        }
    }
}
