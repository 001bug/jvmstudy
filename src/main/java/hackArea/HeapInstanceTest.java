package hackArea;

import java.util.ArrayList;
import java.util.Random;

public class HeapInstanceTest {
    byte[] buffer=new byte[new Random().nextInt(1024*200)];

    public static void main(String[] args){
        ArrayList<HeapInstanceTest> list=new ArrayList<>();
        while(true){
            list.add(new HeapInstanceTest());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
