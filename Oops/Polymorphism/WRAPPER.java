package Polymorphism;

public class WRAPPER {
    public static void main(String[] args) {
        int a=10;
        Integer x=a;//Autoboxing Conversion of primitive type to wrapper class
//        Integer x1=new Integer(10);
//        Integer x2=new Integer(10);//For x1 and x2 seperate objects are created
//        System.out.println(x1==x2);
        Integer x3=10;
        Integer x4=10;
        System.out.println(x3==x4);// At the time of wrapper class loading a buffer of wrapper objects will be created for a certain range
        //Integer -128 to 127
        Integer x5=1000;
        Integer x6=1000;
        System.out.println("Buffer objects will be created for Integer -128 to 127  "+(x5==x6));
        Character x7=1000;
        Character x8=1000;
        System.out.println(x7==x8);
        Character x9=128;
        Character x10=128;
        System.out.println(x9==x10);//range 0 to 127
        Boolean x11=true;
        Boolean x12=true;
        System.out.println(x11==x12);
        boolean bol=true;
        Boolean bool=true;
        if(bool){//AotoBoxing
            System.out.println(false);
        }
    }
}
