import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L002 {
    static class Customer
    {
        String firstName;
        String lastName;
        String customerID;
        int age;
        String mobileNO;
        int accountBalance;
        String accountType;
        String accountNo;
    }
    static class Manager
    {
        String firstName;
        String lastName;
        String managerID;
        String mobileNO;
        int age;

    }
    static class Branch
    {
        String BranchNo;
        Manager branchManager;
        List<Customer> customerList;
        int branchFund;
    }
    static class Bank
    {
        List<Branch> branches;
        String bankName;
        List<Customer>customerList;
        int totalcustomers;
        int totalFund;

        
    }
     // Find the bank in which cutormer age is between 20 to 30 having account
    // balance more than 1 lakh ruppes
    public static ArrayList<Bank> findBanks(ArrayList<Bank> list)
    {
        ArrayList<Bank> ans = new ArrayList<>();

        for(Bank bank: list)
        {
            for(Branch branch : bank.branches)
            {
                for(Customer customer : branch.customerList)
                {
                    if(customer.age>=20 && customer.age<=30 && customer.accountBalance >1000000)
                    {
                        ans.add(bank);
                        break;
                    }
                }
            }
        }
        return ans; 
    }

    // Find the branches where the fund is more than 20 lakh ruppes in all banks

    public static ArrayList<Bank> FindBranches(ArrayList<Bank> mArrayList)
    {
        ArrayList<Bank> result = new ArrayList<Bank>();
        for(Bank b: mArrayList)
        {
            for(Branch bch : b.branches)
            {
                if(bch.branchFund>2000000)
                {
                    result.add(b);
                }
            }
        }
        return result;
    }

    // find the list of customers in all banks where the balance is less than 1 lakh

    public static ArrayList<Bank> balance11(ArrayList<Bank> list)
    {
        ArrayList<Bank> ans = new ArrayList<>();
        for(Bank b: list )
        {
            for(Branch br : b.branches)
            {
                for( Customer ct :br.customerList )
                {
                    if(ct.accountBalance<100000)
                    {
                        ans.add(b);
                    }
                }
            }
        }
        return ans;
    }

    // find the average age of customer in all branches of the given bank
    public static int  ageCust(ArrayList<Bank> list)
    {
        ArrayList<Bank> ans = new ArrayList<>();
        int tage =0;
        int avg =0;
        int totalCustomers=0;
        for(Bank b: list)
        {
            for(Branch br : b.branches)
            {
                for(Customer ct: br.customerList)
                {
                     tage += ct.age;
                     totalCustomers = customerList.length()
                }
            }

        }


        return ans;
    }

    // find the branch where the fund to customer ratio is very high
    // fund/cusomercount
    public static ArrayList<Bank> custR(ArrayList<Bank> list)
    {
        ArrayList<Bank> ans = new ArrayList<>();
        for(Bank b: list)
        {
            for(Branch br : b.branches)
            {
                for(Customer ct: br.customerList)
                {
                    
                }
            }
        }
        return ans;

    }

    // print the branch manager details of given bank based on branch no;
    public static ArrayList<Bank> custR(ArrayList<Bank> list)
    {

    }

    // print the customer details based on customerId branchNo and bankName;

    /// total number of saving account and checking account in all branches //
    /// List<Account> Account{type,noofaccounts}

    // total no. of checking account in given bank based on bank name
   


    public static void main (String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        List<Bank>banks = new ArrayList<>();
        /////////////No of banks
        int noOfBanks = sc.nextInt();
        sc.nextLine();

        ////===============Bank Name===========
        for(int i=0;i<noOfBanks;i++)
        {
            Bank myBank = new Bank();

            String bankName = sc.nextLine();
            int totalcustomers =0;
            int totalFund=0;

            //////////////Branches////////
            List<Branch> branches =new ArrayList<>();
            int noOfBranches = sc.nextInt();
            sc.nextLine();
            for(int j =0;j<noOfBranches;j++)
            {
                Branch br = new Branch();
                String branchNo =sc.nextLine();
                Manager mgr = new Manager();
                mgr.firstName = sc.nextLine();
                mgr.lastName = sc.nextLine();
                mgr.managerID = sc.nextLine();
                mgr.mobileNO = sc.nextLine();
                mgr.age = sc.nextInt();

                int branchFund=0;

                ///////////Customers////////
                int customers = sc.nextInt();

                List<Customer> customerList =new ArrayList<>() ;

                for(int p=0;p<customers;p++)
                {
                    sc.nextLine();
                    Customer cust = new Customer();
                    
                    cust.firstName=sc.nextLine();
                    cust.lastName=sc.nextLine();
                    cust.customerID=sc.nextLine();
                    cust.accountType=sc.nextLine();
                    cust.mobileNO=sc.nextLine();
                    cust.accountNo=sc.nextLine();
                    cust.accountBalance=sc.nextInt();
                    
                    ///Branch fund added from customers balance
                    branchFund+=cust.accountBalance;

                    //////customer added to list

                    customerList.add(cust);
                }
                br.BranchNo = branchNo;
                br.branchManager = mgr;
                br.branchFund = branchFund;
                br.customerList= customerList;


                totalFund +=br.branchFund;
                //total customers =
                totalcustomers +=br.customerList.size();
                branches.add(br) ;

            }

            myBank.bankName=bankName;
            myBank.totalcustomers=totalcustomers;
            myBank.totalFund = totalFund;
            myBank.branches = branches;

            banks.add(myBank);

            for (Bank bank : banks) {
                System.out.println(
                        "=======================================================");
                System.out.println("Bank Name : " + bank.bankName);
                System.out.println("Total Customers : " + bank.totalcustomers);
                System.out.println("Total fund : " + bank.totalFund);
                System.out.println(
                        "=======================================================");
    
                for (Branch branch : bank.branches) {
                    System.out.println("Branch No : " + branch.BranchNo);
                    System.out.println("Branch Manager Name : " + branch.branchManager.firstName + " "
                            + branch.branchManager.lastName);
                    System.out.println("Total Branch Fund : " + branch.branchFund);
                    System.out.println("total customer in Branch : " + branch.customerList.size());
    
                    System.out.println("=======================================================");


                }

                
        }

            


        


    }
}
}
