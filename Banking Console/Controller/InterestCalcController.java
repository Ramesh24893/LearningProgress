package Controller;

public class InterestCalcController {
    private float accountToAccountTaxRate =0.003f;
    private float depositTaxRate=0.002f;
    private float withdrawTaxRate=0.005f;


    int calcWithDrawTax(int amount){
        return (int)(amount*withdrawTaxRate);
    }
    int calcDepositTax(int amount) {
        return (int)(amount*depositTaxRate);
    }
    int calcAccountToAccountTransferTax(int amount){
        return (int)(amount*accountToAccountTaxRate);
    }
}
