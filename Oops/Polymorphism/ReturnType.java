package Polymorphism;

public class ReturnType {
    static int add(int a,int b){
        return a+b;
    }
//    static Float add(float a,int b){
//        return a+b;
//    }
//    static Integer add(float a,int b){
//        return a+b;
//    }
    public static void main(String[] args) {
        System.out.println(add(1,2));
    }
}
//For every class compiler will create method table