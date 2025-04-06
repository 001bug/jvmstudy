package classLoad_;

public class FindClassLoaderWay {
    public static void main(String[] args){
        try {
            ClassLoader classLoader=Class.forName("java.lang.String").getClassLoader();
            System.out.println(classLoader);

            //2.
            ClassLoader classLoader1 = Thread.currentThread().getContextClassLoader();
            System.out.println(classLoader1);

            //3.
            ClassLoader classLoader2 = ClassLoader.getSystemClassLoader().getParent();
            System.out.println(classLoader2);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
