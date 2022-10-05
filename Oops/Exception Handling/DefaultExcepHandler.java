package Exceptional;

public class DefaultExcepHandler {
    public static void main(String[] args) {
        add();
    }

    public static void add() {
        callAdd();
    }

    public static void callAdd () {
        System.out.println(10/0);
    }
}
