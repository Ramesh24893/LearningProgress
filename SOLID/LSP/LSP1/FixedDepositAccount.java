package LSP1;

public class FixedDepositAccount implements Account{
    @Override
    public void withdraw(){    //this behaviour is not applicable for this subtype

        throw new RuntimeException("Cant withdraw in FixedDepositAccount");
    }

    @Override
    public void deposit() {
        System.out.println("Deposited");

    }
}
