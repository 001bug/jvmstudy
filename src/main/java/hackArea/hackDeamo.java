package hackArea;

import java.util.concurrent.TimeUnit;

public class hackDeamo {
    public static void main(String[] args){
        //返回虚拟机中堆的内存总量
        long initialMemory=Runtime.getRuntime().totalMemory();
        //返回Java虚拟机试图使用的最大堆内存
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;
        System.out.println("-Xms : " + initialMemory + "M");
        System.out.println("-Xmx : " + maxMemory + "M");
        System.out.println("系统内存大小为：" + initialMemory * 64.0 / 1024 + "G");
        System.out.println("系统内存大小为：" + maxMemory * 4.0 / 1024 + "G");
    }
}
