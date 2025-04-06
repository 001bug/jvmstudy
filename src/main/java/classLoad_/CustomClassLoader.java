package classLoad_;

import java.io.FileNotFoundException;
/**
 * 自定义类加载器的主要作用是隔离环境. 比如spring包中有和rokemq一样的包名,
 * 为避免冲突,一般都会自定义类加载器
 * */
public class CustomClassLoader extends ClassLoader{
    @Override
    protected Class<?> findClass(String name) throws  ClassNotFoundException{
        try {
            byte[] result = getClassFromCustomPath(name);
            if (result == null) {
                throw new FileNotFoundException();
            } else {
                //defineClass和findClass搭配使用
                return defineClass(name, result, 0, result.length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        throw new ClassNotFoundException(name);
    }
    //自定义流的获取方式,这里要获取的是字节码
    private byte[] getClassFromCustomPath(String name) {
        //从自定义路径中加载指定类:细节略
        //如果指定路径的字节码文件进行了加密，则需要在此方法中进行解密操作。
        return null;
    }

    public static void main(String[] args){
        CustomClassLoader customClassLoader = new CustomClassLoader();
        try {
            Class<?> clazz = Class.forName("One", true, customClassLoader);
            Object obj = clazz.newInstance();
            System.out.println(obj.getClass().getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
