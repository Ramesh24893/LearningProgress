//----METHOD OVERLOADING----
package Polymorphism;
public class Calculator {
    public static float add(int a,float b){
        System.out.println("this");
        return a+b;
    }
    public static int add(int a,int b,int c){
        return a+b+c;
    }
    public static int add(int ... a){
        int x=0;
        for(int i:a){
            x+=i;
        }
        return x;
    }
    public static void main(String[] args) {
        //System.out.println(add(1,2,3));
        System.out.println(add(1,2));
        //System.out.println(add(1,2,3,4,5,6,7));
    }
}
