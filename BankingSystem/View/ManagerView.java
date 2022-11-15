package View;

import Model.Branch;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ManagerView {
    Scanner scannerObject=new Scanner(System.in);

    public static void displayAllBranchStats(HashMap<String, Branch> branches) {
    for(Map.Entry<String, Branch> branchMap: branches.entrySet()) {
        Branch branch=branchMap.getValue();
        System.out.println("**********************************************");
        System.out.println("Branch Code :"+ branch.getBranchCode());
        System.out.println("Branch Name:"+ branch.getBranchName());
        System.out.println("Branch Profit:"+ branch.getBranchProfit());
        System.out.println("Reserve Amount:"+ branch.getReserveAmount());
        System.out.println("Accounts present:"+ branch.getAccounts().size());
        System.out.println("**********************************************");
    }
    }

    public String getManagerUserNameForValidation(){
        System.out.println("Enter the Manager username");
        return scannerObject.nextLine();
    }
    public String getManagerPasswordForValidation(){
        System.out.println("Enter the Manager password");
        return scannerObject.nextLine();
    }
    public void invalidManagerLoginNotification(){
        System.out.println("Invalid manager login data");
    }

    public void invalidDataNotification(){
        System.out.println("Enter valid data");
    }


//    public void displayBranches(HashMap<String, Branch> branches){
//        for(Map.Entry<String,Branch> branch: branches.entrySet()){
//            System.out.println(branch.getKey());
//            displayBranchAccount(branch.getValue());
//        }
//    }
//    public void displayBranchAccount(Branch branch){
//        for(Long accNum: branch.getAccounts()){
//            System.out.println(accNum);
//        }
//    }
}
