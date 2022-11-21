package Data;

import Model.Account;
import Model.Branch;
import Model.User;

import java.time.LocalDate;

public class InitialData {
    public static void initialData(){
        BankDataBase bankDataBaseObj=BankDataBase.getInstance();
        Branch chennaiBranch=new Branch("Chennai",100000000,"ZOHO1000");
        bankDataBaseObj.getBranches().put(chennaiBranch.getBranchCode(), chennaiBranch);
        Branch maduraiBranch=new Branch("Madurai",100000000,"ZOHO1001");
        bankDataBaseObj.getBranches().put(maduraiBranch.getBranchCode(), maduraiBranch);
        Branch coimbatoreBranch=new Branch("Coimbatore",1002355450,"ZOHO1002");
        bankDataBaseObj.getBranches().put(coimbatoreBranch.getBranchCode(), coimbatoreBranch);
        Branch tirunelveliBranch=new Branch("Tirunelveli",100054646,"ZOHO1003");
        bankDataBaseObj.getBranches().put(tirunelveliBranch.getBranchCode(), tirunelveliBranch);
        Branch thoothukudiBranch=new Branch("Thoothukudi",100064664,"ZOHO1004");
        bankDataBaseObj.getBranches().put(thoothukudiBranch.getBranchCode(), thoothukudiBranch);
        Branch velloreBranch=new Branch("Vellore",100644640,"ZOHO1005");
        bankDataBaseObj.getBranches().put(velloreBranch.getBranchCode(), velloreBranch);
        Branch salemBranch=new Branch("Salem",100466460,"ZOHO1006");
        bankDataBaseObj.getBranches().put(salemBranch.getBranchCode(), salemBranch);
        Branch tenkasiBranch=new Branch("Tenkasi",1000464664,"ZOHO1007");
        bankDataBaseObj.getBranches().put(tenkasiBranch.getBranchCode(), tenkasiBranch);
        User user1=new User("ram","1234");


        Account acc=new Account("Ramesh",12345,8610036775L,"ZOHO1001",20000);
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





        User user2=new User("sita","1234");
        Account acc2=new Account("Ram",56789,8675473099L,"ZOHO1003",10000);
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



        Account unlinkedAccount=new Account("Partner",123456789,8610136775L,"ZOHO1002",10000);
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
