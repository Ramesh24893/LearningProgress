package OCP1;

public class Multiplication implements IOperation
{
    private double firstOperand;
    private double secondOperand;
    private double result;

    public Multiplication(double firstOperand, double secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    public void performOperation() {
        result = firstOperand * secondOperand;
        System.out.println(result);
    }
}
