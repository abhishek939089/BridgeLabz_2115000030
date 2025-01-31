class BankAccount {
    public int accountNumber;
    protected String accountHolder;
    private double balance;

    BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }

    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount(1001, "Alice", 5000.00);
        savingsAccount.displayAccountDetails();
        savingsAccount.displayInterestRate();
    }
}

class SavingsAccount extends BankAccount {
    double interestRate = 5.0;

    SavingsAccount(int accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    void displayInterestRate() {
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}
