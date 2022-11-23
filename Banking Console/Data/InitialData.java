package Data;

import Model.Account;
import Model.Branch;
import Model.User;

import java.time.LocalDate;

public class InitialData {
    public static void initialData(){
        BankDataBase bankDataBaseObj=BankDataBase.getInstance();
        Branch chennaiBranch=new Branch("Chennai",1000000,"ZOHO1000");
        bankDataBaseObj.getBranches().put(chennaiBranch.getBranchCode(), chennaiBranch);
        Branch maduraiBranch=new Branch("Madurai",1000000,"ZOHO1001");
        bankDataBaseObj.getBranches().put(maduraiBranch.getBranchCode(), maduraiBranch);
        Branch coimbatoreBranch=new Branch("Coimbatore",1000000,"ZOHO1002");
        bankDataBaseObj.getBranches().put(coimbatoreBranch.getBranchCode(), coimbatoreBranch);
        Branch tirunelveliBranch=new Branch("Tirunelveli",1000000,"ZOHO1003");
        bankDataBaseObj.getBranches().put(tirunelveliBranch.getBranchCode(), tirunelveliBranch);


        User user1=new User("ram@24893","Ram@1234");
        Account acc=new Account("Ram",90876123456789L,8610036775L,"ZOHO1001","Mahesh",24,"Male",823260024788L,"BGLR1232j","Nellai");

        user1.setAccount(acc);
        acc.setTransferLimit(100000);
        acc.setWithdrawLimit(10000);
        acc.setDepositLimit(1000000);
        acc.setMinBalance(20000);
        acc.setOverDraftLimit(50000);
        acc.setAccountType("CurrentAccount");
        acc.setDateOfCreation(LocalDate.now());
        bankDataBaseObj.getUsers().put(user1.getUserId(), user1);
        bankDataBaseObj.getAccounts().put(acc.getAccountNumber(),acc);
        bankDataBaseObj.getBranches().get("ZOHO1002").getAccounts().add(acc.getAccountNumber());
        acc.setLinkedUserId(user1.getUserId());





        User user2=new User("ramesh@24893","Ramesh@1234");
        Account acc2=new Account("Ramesh",98765432156789L,8675473099L,"ZOHO1003","Ganesh",31,"Male",824560024788L,"AGHR1232j","Covai");
        user2.setAccount(acc2);
        acc2.setTransferLimit(100000);
        acc2.setWithdrawLimit(50000);
        acc2.setDepositLimit(100000);
        acc2.setMinBalance(1000);
        acc2.setAccountType("SavingsAccount");
        acc2.setDateOfCreation(LocalDate.now());
        bankDataBaseObj.getUsers().put(user2.getUserId(),user2);
        bankDataBaseObj.getAccounts().put(acc2.getAccountNumber(),acc2);
        bankDataBaseObj.getBranches().get("ZOHO1002").getAccounts().add(acc2.getAccountNumber());
        acc2.setLinkedUserId(user2.getUserId());


        Account unlinkedAccount=new Account("Rajesh",98765432101234L,8613136775L,"ZOHO1002","Suresh",24,"Male",993260024788L,"KGHR1232j","Chennai");
        bankDataBaseObj.getAccounts().put(unlinkedAccount.getAccountNumber(),unlinkedAccount);
        bankDataBaseObj.getBranches().get("ZOHO1001").getAccounts().add(acc.getAccountNumber());
        unlinkedAccount.setTransferLimit(100000);
        unlinkedAccount.setWithdrawLimit(50000);
        unlinkedAccount.setDepositLimit(100000);
        unlinkedAccount.setMinBalance(1000);
        unlinkedAccount.setAccountType("SavingsAccount");
        unlinkedAccount.setDateOfCreation(LocalDate.now());
    }
}
