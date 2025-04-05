package classLoad_;

/**
 * 引导加载器, 扩展加载器, 系统加载器和用户自定义的加载器,他们之间是包含关系,引导加载器是用c++写的
 */
public class classLoadTest {
    public static void main(String args[]){
        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);//jdk.internal.loader.ClassLoaders$AppClassLoader@36baf30c

        //通过系统类加载器获取上层扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);//jdk.internal.loader.ClassLoaders$PlatformClassLoader@b4c966a

        //通过扩展类加载器获取上层引导类加载器
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);//null

        //获取用户自定义加载器,发现用户自定义加载器是使用系统加载器
        ClassLoader classLoader = classLoadTest.class.getClassLoader();
        System.out.println(classLoader);//jdk.internal.loader.ClassLoaders$AppClassLoader@36baf30c

        //获取核心类包的加载器发现也是Null,说明是使用引导类加载器
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);//null
    }
}
