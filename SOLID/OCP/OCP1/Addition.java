//In this code I can add new MATHEMATICAL OPERATION feature without changing the existing code

package OCP1;

public class Addition implements IOperation
{
    private double firstOperand;
    private double secondOperand;
    private double result;

    public Addition(double firstOperand, double secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }
    public void performOperation() {
        result = firstOperand + secondOperand;
        System.out.println(result);
    }
}
