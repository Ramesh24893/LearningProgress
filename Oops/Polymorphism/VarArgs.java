// can combine var-args either with widening or boxing not both
package Polymorphism;

public class VarArgs {
//    static void add(Integer ... a){
//        System.out.println("method1");
//  }
    static void add(Long ... a){
        System.out.println("long method1");
    }
//    static void add(float ... a){
//        System.out.println("method2");
//    }


    static void add(Long s){
        System.out.println("boxing and then widening");
    }
    public static void main(String[] args) {
       // int a=9;
//        add(2,3,4);
        //add(2);
    }
}
