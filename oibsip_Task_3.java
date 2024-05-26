import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    Scanner sc = new Scanner(System.in);
    private final String[] validAccounts = {"221154569451", "2211545698551", "221754569451", "254854569451"};
    int[] verifiedPin = {8567, 2433, 4534, 1221};
    String[] verifiedUsers = {"Steven", "Mark", "Jack", "Weirdo"};

    static boolean flag=true;

    ArrayList<Double> initialAmount = new ArrayList<>(4);
    ArrayList<String> transactions = new ArrayList<>(4);
    int userIndex;
    BankAccount(){
        System.out.println("Enter User ID: ");
        String userID = sc.nextLine();

        System.out.println("Enter User Pin: ");
        int userPin = sc.nextInt();

        for (int i = 0; i< verifiedUsers.length; i++){
            if (verifiedUsers[i].equalsIgnoreCase(userID)){
                if (verifiedPin[i] == userPin){
                    userIndex = i;
                    System.out.println("Successfully Logged In");
                    flag=false;
                }
            }
        }
        if (flag) {
            System.out.println("Incorrect User ID OR User Pin");
            return;
        }

        System.out.println("Enter initial Balance of your Account: ");
        double amount = sc.nextDouble();
        initialAmount.add(amount);
    }

    void transactionHistory(){
        if (transactions.isEmpty()){
            System.out.println("No Transaction History Found");
            return;
        }
        System.out.println("Your current Balance is: "+ initialAmount.get(userIndex));
        for (int i=0; i<transactions.size();i++){
                System.out.println((i+1) + ". " + transactions.get(i));
        }
    }

    void withdraw(double amount){
        if (amount > initialAmount.get(userIndex)){
            System.out.println("You have insufficient Balance");
        }
        else {
            initialAmount.set(userIndex, initialAmount.get(userIndex) - amount);
            System.out.println("You have withdrawn Rs."+amount+" successfully");
            transactions.add("Withdrawn amount: "+amount);
        }
    }

    void deposit(double amount){
        initialAmount.set(userIndex, initialAmount.get(userIndex) + amount);
        System.out.println("You have deposited Rs."+amount+" successfully");
        transactions.add("Deposited amount: "+amount);

    }
    void transfer(double amount,String accountNO){
        boolean flag2=true;
        for (int i=0; i< validAccounts.length; i++){
            if (validAccounts[i].equalsIgnoreCase(accountNO)){
                flag2 = false;
                initialAmount.set(userIndex, initialAmount.get(userIndex) - amount);
                System.out.println("Successfully Transferred RS."+amount+" to account number "+accountNO);
                transactions.add("Transferred RS."+amount+" to account number "+accountNO);
                break;
            }
        }
        if (flag2){
            System.out.println("Enter valid Account Number");
        }
    }


}

public class oibsip_Task_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount b1 = new BankAccount();
        int choice;

        do {
            if (BankAccount.flag){
                break;
            }
            System.out.println("\nATM Menu:");
            System.out.println("1. Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    b1.transactionHistory();
                    break;
                    
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    b1.withdraw(withdrawAmount);
                    break;
                    
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    b1.deposit(depositAmount);
                    break;
                    
                case 4:
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter recipient user ID: ");
                    String recipientId = sc.nextLine();
                    b1.transfer(transferAmount,recipientId);
                    break;
                    
                case 5:
                    System.out.println("Thank you for using the ATM.");
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5);
    }
}
