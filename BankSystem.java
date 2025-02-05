import java.util.ArrayList;
import java.util.List;

class Bank {
    String name;
    List<Customer> customers;

    Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    void openAccount(Customer customer) {
        customers.add(customer);
    }

    void displayCustomers() {
        System.out.println("Bank: " + name);
        for (Customer customer : customers) {
            System.out.println("Customer: " + customer.name);
        }
    }
}

class Customer {
    String name;
    double balance;

    Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    void viewBalance() {
        System.out.println(name + "'s Balance: $" + balance);
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Bank bank = new Bank("Global Bank");
        Customer cust1 = new Customer("Abhishek", 5000);
        Customer cust2 = new Customer("Arun", 3000);

        bank.openAccount(cust1);
        bank.openAccount(cust2);

        bank.displayCustomers();
        cust1.viewBalance();
        cust2.viewBalance();
    }
}
