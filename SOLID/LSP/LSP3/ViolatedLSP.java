package LSP3;

public class ViolatedLSP {
    public static void main(String[] args) {
        Bird bird=new Parrot();
        bird.eat();
    }
}
class Bird{
    public void eat(){}
    public void fly(){}
}
class Penguin extends Bird{
    @Override
    public void eat() {
        System.out.println("Penguin eats");
    }
    @Override
    public void fly()  {
        throw new RuntimeException("Penguin cant fly");
    }
}
class Parrot extends Bird{
    @Override
    public void eat() {
        System.out.println("Parrot eats");
    }
    @Override
    public void fly() {
        System.out.println("Parrot flies");
    }
}
