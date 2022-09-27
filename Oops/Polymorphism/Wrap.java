package Polymorphism;
class Animal{
    public void rest() {
    }
}
class Tiger extends Animal{}
public class Wrap {
//    static void  add(Long l){
//        System.out.println("Wrapper Long");
//    }static void  add(long l){
//        System.out.println("primitive Long");
//    }

    static Integer add(Integer a,Integer b){
        System.out.println("Integer method ");// Low prefence to boxing and unboxing
        return a+b;
    }
    static long add(long a,long b){
        System.out.println("method1 ");
        return a+b;
    }

    static float add(float a,float b){
        System.out.println("method float");
        return a+b;
    }

//    static Integer add(int a, Integer b){
//        System.out.println("method 2");
//        return a+b;
//    }
//     static Integer add(Integer a, Integer b){
//        System.out.println("method 3");
//        return a+b;
//    }
    static void eat(Animal animal ){
        System.out.println("Animal eating");
    }
    static void eat(Tiger tiger){
        System.out.println("Tiger eating");
    }
    public static void main(String[] args) {
       // add(new Integer(1),new Long(2));
        add(1,2);
       //add(new Integer(1),new Integer(1));//Unboxing








//
//        Wrap wrap=new Wrap();
//        Animal animal1 = new Tiger();
//        Animal animal2 = new Animal();
//        Tiger animal3 = new Tiger();
//        wrap.eat(animal1);
//        wrap.eat(animal2);
//        wrap.eat(animal3);
//        add(new Long(53421));
    }
}
//Both widening and boxing cant be performed at same