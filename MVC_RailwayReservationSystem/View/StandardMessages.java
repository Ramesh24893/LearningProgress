package View;

public class StandardMessages implements StandardMessagesUI {

    public  void loginPageDisplay() {
        System.out.println("Enter 1 to continue as User\n" +
                "Enter 2 to continue as Admin\n" +
                "Enter 3 to create User account\n" +
                "Enter 4 to exit  application");
    }

    public void displayAdminFeatures() {
        System.out.println("Enter 1 to create stations\n" +
                "Enter 2 to create Trains\n" +
                "Enter 3 to display all tickets\n" +
                "Enter 4 to display all Trains\n" +
                "Enter 5 to go back login page");
    }

    public  void displayUserFeatures() {
        System.out.println("Enter 1 to book ticket\n" +
                "Enter 2 to cancel ticket\n" +
                "Enter 3 to display booked Tickets\n" +
                "Enter 4 to go back login page");
    }
    public void logoPage(){
        System.out.println("******************************************************");
        System.out.println("******************************************************");
        System.out.println("\n***          RAILWAY RESERVATION SYSTEM            ***");
        System.out.println("\n******************************************************");
        System.out.println("******************************************************");
    }

    public void invalidMessage(){
        System.out.println("Enter valid data");
    }

}
