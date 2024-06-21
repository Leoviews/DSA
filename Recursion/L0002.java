import java.util.List;
import java.util.Scanner;
import java.util.*;

public class L0002 {

    static class Customer {
        String firstname;
        String lastName;
        String customerID;
        String accountType;
        String mobileNo;
        String accountNo;
        int accountBalance;
        int age;
    }

    static class Manager {
        String firstName;
        String LastName;
        String managerId;
        String mobileNo;
        int age;
    }

    static class Branch {
        String branchNo;
        Manager branchmanager;
        List<Customer> customerList;
        int branchfund; // No input
    }

    static class Bank {
        List<Branch> branches;// count
        String bankName;
        int totalCustomers; // No input
        int totalFund; // No input
    }

    // Find the bank in which cutormer age is between 20 to 30 having account
    // balance more than 1 lakh ruppes

    // Find the branches where the fund is more than 20 lakh ruppes in all banks

    // find the list of customers in all banks where the balance is less than 1 lakh

    // find the average age of customer in all branches of the given bank

    // find the branch where the fund to customer ratio is very high
    // fund/cusomercount

    // print the branch manager details of given bank based on branch no;

    // print the customer details based on customerId branchNo and bankName;

    /// total number of saving account and checking account in all branches //
    /// List<Account> Account{type,noofaccounts}

    // total no. of checking account in given bank based on bank name

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        List<Bank> banks = new ArrayList<>();

        // ============== No of Banks ================

        int noOfbanks = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < noOfbanks; i++) {

            Bank mybank = new Bank();

            String bankName = sc.nextLine();
            int totalCutomers = 0;
            int totalfund = 0;

            // ===================== Branches ===========================
            List<Branch> branches = new ArrayList();
            int noOfBranches = sc.nextInt();
            sc.nextLine();

            for (int j = 0; j < noOfBranches; j++) {

                Branch br = new Branch();

                String branchNo = sc.nextLine();

                Manager mgr = new Manager();
                mgr.firstName = sc.nextLine();
                mgr.LastName = sc.nextLine();
                mgr.managerId = sc.nextLine();
                mgr.mobileNo = sc.nextLine();
                mgr.age = sc.nextInt();

                int branchFund = 0;
                // ============= Customers ================
                int customers = sc.nextInt();

                List<Customer> customerList = new ArrayList();
                for (int p = 0; p < customers; p++) {
                    sc.nextLine();
                    Customer cust = new Customer();
                    cust.firstname = sc.nextLine();
                    cust.lastName = sc.nextLine();
                    cust.customerID = sc.nextLine();
                    cust.accountType = sc.nextLine();
                    cust.mobileNo = sc.nextLine();
                    cust.accountNo = sc.nextLine();
                    cust.accountBalance = sc.nextInt();
                    cust.age = sc.nextInt();

                    // Banch fund added from customers balance
                    branchFund += cust.accountBalance;
                    // ========= customer added to list =============
                    customerList.add(cust);
                }

                br.branchNo = branchNo;
                br.branchmanager = mgr;
                br.branchfund = branchFund;
                br.customerList = customerList;

                // total fund is calculated from branch fund

                totalfund += br.branchfund;
                // total customers =
                totalCutomers += br.customerList.size();
                branches.add(br);

            }

            mybank.bankName = bankName;
            mybank.totalCustomers = totalCutomers;
            mybank.totalFund = totalfund;
            mybank.branches = branches;

            banks.add(mybank);

        }
        for (Bank bank : banks) {
            System.out.println(
                    "=======================================================");
            System.out.println("Bank Name : " + bank.bankName);
            System.out.println("Total Customers : " + bank.totalCustomers);
            System.out.println("Total fund : " + bank.totalFund);
            System.out.println(
                    "=======================================================");

            for (Branch branch : bank.branches) {
                System.out.println("Branch No : " + branch.branchNo);
                System.out.println("Branch Manager Name : " + branch.branchmanager.firstName + " "
                        + branch.branchmanager.LastName);
                System.out.println("Total Branch Fund : " + branch.branchfund);
                System.out.println("total customer in Branch : " + branch.customerList.size());

                System.out.println("=======================================================");

            }

        }
    }

}