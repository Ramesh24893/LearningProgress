package Controller;

import Model.Account;

public class InterestRateCalculator {
    private float accountToAccountTaxRate =0.003f;
    private float depositTaxRate=0.002f;
    private float withdrawTaxRate=0.005f;

    public int calcWithDrawTax(int amount){
        return (int)(amount*withdrawTaxRate);
    }
    public int calcDepositTax(int amount){
        return (int)(amount*depositTaxRate);
    }
    public int calcAccountToAccountTransferTax(int amount){
        return (int)(amount*accountToAccountTaxRate);
    }
}
