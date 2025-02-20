import java.util.*;

class BankingSystem {
    private Map<Integer, Double> accountBalanceMap;
    private TreeMap<Double, Integer> sortedAccounts;
    private Queue<Integer> withdrawalQueue;

    public BankingSystem() {
        accountBalanceMap = new HashMap<>();
        sortedAccounts = new TreeMap<>();
        withdrawalQueue = new LinkedList<>();
    }

    public void addAccount(int accountNumber, double balance) {
        accountBalanceMap.put(accountNumber, balance);
        sortedAccounts.put(balance, accountNumber);
    }

    public void deposit(int accountNumber, double amount) {
        if (accountBalanceMap.containsKey(accountNumber)) {
            double newBalance = accountBalanceMap.get(accountNumber) + amount;
            sortedAccounts.remove(accountBalanceMap.get(accountNumber));
            accountBalanceMap.put(accountNumber, newBalance);
            sortedAccounts.put(newBalance, accountNumber);
        } else {
            System.out.println("Account not found!");
        }
    }

    public void requestWithdrawal(int accountNumber) {
        if (accountBalanceMap.containsKey(accountNumber)) {
            withdrawalQueue.offer(accountNumber);
            System.out.println("Withdrawal request added for Account: " + accountNumber);
        } else {
            System.out.println("Account not found!");
        }
    }

    public void processWithdrawals() {
        System.out.println("\nProcessing Withdrawals:");
        while (!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll();
            System.out.println("Processed withdrawal for Account: " + accountNumber);
        }
    }

    public void displayAccountsUnordered() {
        System.out.println("\nAccount Balances (Unordered - HashMap):");
        for (Map.Entry<Integer, Double> entry : accountBalanceMap.entrySet()) {
            System.out.println("Account: " + entry.getKey() + " -> $" + entry.getValue());
        }
    }

    public void displayAccountsSortedByBalance() {
        System.out.println("\nAccounts Sorted by Balance (TreeMap):");
        for (Map.Entry<Double, Integer> entry : sortedAccounts.entrySet()) {
            System.out.println("Account: " + entry.getValue() + " -> $" + entry.getKey());
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.addAccount(1001, 5000.00);
        bank.addAccount(1002, 1200.50);
        bank.addAccount(1003, 8000.75);
        bank.addAccount(1004, 3000.20);

        bank.displayAccountsUnordered();
        bank.displayAccountsSortedByBalance();

        bank.deposit(1002, 1000);
        bank.displayAccountsSortedByBalance();

        bank.requestWithdrawal(1001);
        bank.requestWithdrawal(1003);
        bank.processWithdrawals();
    }
}
