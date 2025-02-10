abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    protected double balance;

    BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    abstract double calculateInterest();
}

class SavingsAccount extends BankAccount {
    SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    double calculateInterest() {
        return balance * 0.04;
    }
}

public class Banking {
    public static void main(String[] args) {
        BankAccount account = new SavingsAccount("A12345", "John Doe", 10000);
        System.out.println("Interest: " + account.calculateInterest());
    }
}
