package OCP1;

public class Substraction implements IOperation
{
    private double firstOperand;
    private double secondOperand;
    private double result;

    public Substraction(double firstOperand, double secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    public void performOperation() {
        result = firstOperand - secondOperand;
        System.out.println(result);
    }
}
