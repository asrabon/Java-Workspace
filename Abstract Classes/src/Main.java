/**
 * Created by Sloan on 4/20/2017.
 */
public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog("Yorkie");
        dog.breathe();
        dog.eat();

        Bird parrot = new Parrot("Parrot");
        parrot.breathe();
        parrot.eat();
        parrot.fly();

        Bird penguin = new Penguin("Emperor");
        penguin.fly();
    }

}
