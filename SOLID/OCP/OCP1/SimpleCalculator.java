package OCP1;

import java.security.InvalidParameterException;

public class SimpleCalculator implements ICalculator
{


    public void calculate(IOperation operation)
    {
        if(operation == null) {
            throw new InvalidParameterException("Some message");
        }
        operation.performOperation();
    }
}
