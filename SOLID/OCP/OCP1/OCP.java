package OCP1;

public class OCP {
    public static void main(String[] args) {
        IOperation operation=new Addition(10,20);
        operation.performOperation();
    }
}
