package Exceptional;

public class NestedTry {
    public static void main(String[] args) {
        try {
            System.out.println("Outer try");
            //System.out.println(10/0);
            try {
                System.out.println("Inner try");
                System.out.println(10/0);
            } catch (NullPointerException e) {
                System.out.println("Inner catch");
            }
            finally{
                System.out.println("Inner finally");
            }

        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
//        try{
//            System.out.println("helloooo");
//        }
//        System.out.println("where catch");
//        catch(Exception e){
//
//        }
    }
}