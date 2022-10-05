package Exceptional;

public class ControlFlow {
    public static void main(String[] args) {
        try{
            System.out.println("hello");
            System.out.println(10/0);
            System.out.println("hi");//WIll not return here
        }
        catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }

    }
}
