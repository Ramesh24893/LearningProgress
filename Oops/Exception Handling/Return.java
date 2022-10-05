package Exceptional;

public class Return {
    public static void main(String[] args) {
        System.out.println(m1());
    }
    public static int m1(){
        try{
            return 1;
        }
        catch(Exception e){
            return 2 ;
        }
        finally {
            return 3;
        }
    }
}
