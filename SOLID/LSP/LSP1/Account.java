//---------------------------------------LISKOV SUBSTITUTION PRINCIPLE--------------------------------------------------

//Our application should not alter desirable results when we replace parent type with any of its subtype
//how parent class behave the same way the subclass should behave
//Behavior is not just having all the methods of super class
//This principle helps us to inherit properly
//If LSP is violated then the inheritance of our program is wrong
//Subclass can enhance the functionality of base class
//----------------------------------------------------------------------------------------------------

//In the below code LSP is violated
//Below Account interface has two behaviours withdraw and deposit
//However FixedDepositAccount is an account we cant inherit because it cant have withdraw functionality
//We should create separate interface for FixedDepositAccount class
package LSP1;

interface Account {
    public void withdraw() ;
    public void deposit();

}
