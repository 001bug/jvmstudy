package VirtualStack;

public class MethodBindingWay {
    public void showAnimal(Animal animal) {
        animal.eat();//表现为：晚期绑定
    }

    public void showHunt(Huntable h) {
        h.hunt();//表现为：晚期绑定
    }
}
class Animal{
    public void eat(){
        System.out.println("Animal eat");
    }

}

interface Huntable{
    void hunt();
}

class Dog extends Animal implements Huntable {
    @Override
    public void hunt() {
        System.out.println("Dog hunt");
    }
}

class Cat extends Animal implements Huntable {
    public Cat() {
        super();//表现为：早期绑定
    }
    public Cat(String name) {
        this();//表现为：早期绑定
    }
    @Override
    public void eat() {
        super.eat();//表现为：早期绑定
        System.out.println("猫吃鱼");
    }
    @Override
    public void hunt() {
        System.out.println("Cat hunt");
    }
    /*
    * public VirtualStack.Cat();
    Code:
       0: aload_0
       1: invokespecial #1  早起绑定,编译的时候已经确认    // Method VirtualStack/Animal."<init>":()V
       4: return

  public VirtualStack.Cat(java.lang.String);
    Code:
       0: aload_0
       1: invokespecial #2                  // Method "<init>":()V
       4: return

  public void eat();
    Code:
       0: aload_0
       1: invokespecial #3                  // Method VirtualStack/Animal.eat:()V
       4: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
       7: ldc           #5                  // String 猫吃鱼
       9: invokevirtual #6                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      12: return

  public void hunt();
    Code:
       0: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #7                  // String Cat hunt
       5: invokevirtual #6                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       8: return
}
*/
}
/*
* public class VirtualStack.MethodBindingWay {
  public VirtualStack.MethodBindingWay();
    Code:
       0: aload_0

  public void showAnimal(VirtualStack.Animal);
    Code:
       0: aload_1
       1: invokevirtual #2  代表是晚期绑定             // Method VirtualStack/Animal.eat:()V
       4: return

  public void showHunt(VirtualStack.Huntable);
    Code:
       0: aload_1
       1: invokeinterface #3,  1    也体现出晚期绑定 // InterfaceMethod VirtualStack/Huntable.hunt:()V
       6: return
}
*/