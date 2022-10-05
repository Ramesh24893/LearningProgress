package Exceptional;

public class Shut {
    public static void main(String[] args) {
        try{
            System.out.println(1);
            System.exit(0);
        }
        catch(Exception e){
            System.out.println(2);
        }
        finally {
            System.out.println(3);
    }
}}
