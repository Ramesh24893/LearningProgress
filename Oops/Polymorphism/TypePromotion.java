//Type promotion in overloading
//Smaller datatype is promoted to bigger one if no matching data type is found
package Polymorphism;
public class TypePromotion {
    public static int add(int a,int b){
        System.out.print("Method 1  ");
        return a+b;
    }
    public static float add(float a,int  c){
        System.out.print("Method 2  ");
        return a+c;
    }
    public static double add(int a,long b){
        System.out.print("Method 3  ");
        return a+b;
    }
    public static double add(int a,double b){
        System.out.print("Method 4  ");
        return a+b;
    }
    public static void check(Object o){
        System.out.println("Object version");
    }
    public static void check(String o){
        System.out.println("String version");
    }
    public static void check(StringBuffer o){
        System.out.println("StringBuffer version");
    }

    public static void main(String[] args) {
        System.out.println(add(1,2));
        System.out.println(add(1,2.0));
        System.out.println(add(1,2.0f));
        System.out.println(add(1,2L));
        //System.out.println(add(1.0,2.0)); Here argument 1 is float, In above three methods 1st argument is integer(Datatype cant be depromoted)
        check(new Object());
        check(new String());
        check(new StringBuffer());
        //check(null);
    }
}
