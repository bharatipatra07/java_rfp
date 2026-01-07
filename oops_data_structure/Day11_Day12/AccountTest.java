import java.util.Scanner;

class Account{
    private double balance;
    public Account(double balance){
        if(balance>0.0){
            this.balance=balance;
        }
    }
    public void credit(double amount){
        if(amount>0.0){
            balance+=amount;
        }
    }
    public void debit(double amount){
        if(amount<=balance){
            balance-=amount;
        }else{
            System.out.println("Debit amount exceeded account balance.");
        }
    }
    public double getBalance(){
        return balance;
    }
}
public class AccountTest{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Account account=new Account(500.00);
        System.out.println("Initial Balance is "+account.getBalance());
        System.out.println("Enter Credit Amount:");
        double creditAmount=sc.nextDouble();
        account.credit(creditAmount);
        System.out.println("After Adding/Credit Balance is "+account.getBalance());

        System.out.println("Enter Debit Amount:");
        double debitAmount=sc.nextDouble();
        account.debit(debitAmount);
        System.out.println("After debit/Remove Balance is "+account.getBalance());
    }
}