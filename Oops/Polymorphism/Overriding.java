//Overriding
//In overriding method resolution is always take care by JVM based on run time object
//method name and argument type must be matched
//return must  be same and it can be covariant
//cant override static method to non static ,vice versa
package Polymorphism;
class Animals{
    public String eat(){
        return "Animal eating";
    }
    public Object hunt(){
        return "Animal Hunting";
    }
    //void food(){}
    static void rest(){
        System.out.println("Animals class");
    }
}
class Carnivores extends Animals{
    public String eat(){
        return "Lion eating";
    }
    //static void food(){}
//    public String hunt(){
//        return "Lion Hunting";
//    }
    public StringBuffer hunt(){
        return null;
    }
    static void rest(){
        System.out.println("Carnivores class");
    }
}
class Lion extends Carnivores{
     static void rest(){
         System.out.println("Lion class");
     }
}
public class Overriding {
    public static void main(String[] args) {
        Lion lion =new Lion();
        System.out.println(lion.hunt());
        Animals animal=new Lion();
        animal.rest();
    }
}
