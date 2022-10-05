package Exceptional;

public class MultipleThrows {
    public static void main(String[] args) throws InterruptedException {
        sleep();
    }

    public static void sleep() throws InterruptedException {
        moreSleep();
    }
    public static void moreSleep() throws InterruptedException {
        Thread.sleep(1000);
    }

}
