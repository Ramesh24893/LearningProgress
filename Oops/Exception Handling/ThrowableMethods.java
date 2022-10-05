package Exceptional;

public class ThrowableMethods {
    public static void main(String[] args) {
        try{
            int arr[]=new int[5];
            System.out.println(arr[6]);
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println(e);

        }
    }
}
