package Exceptional;

import java.io.IOError;
import java.io.IOException;

public class FullyChecked {
    public static void main(String[] args) {
        try{
            System.out.println("Helo");
        }
//        catch (IOException e){
//
//        }
        catch(ArithmeticException e){
    }
}}
