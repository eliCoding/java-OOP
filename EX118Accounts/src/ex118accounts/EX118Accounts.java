package ex118accounts;

import java.util.ArrayList;
import java.util.Date;

class Acount {

    String name;
    private int Id;
    private double balance;
    private double annualInterestDate;

    ArrayList<Transaction> transaction = new ArrayList<>();
    double monthlyInterestRate;
    double annualInterestRate;

    public Acount() {
    }

    public Acount(String name, int Id, double balance, double annualInterestRate) {
        this.name = name;
        setId(Id);
        setBalance(balance);
        setAnnualInterestRate(annualInterestRate);
       

    }

    Acount(String name, int Id, double balance) {
        this.name = name;
        this.Id = Id;
        this.balance = balance;

    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestDate() {
        return annualInterestDate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public double getMonthlyInterestRate() {
        return (balance * monthlyInterestRate) / 100;
    }

    public double getMonthlyInterest() {
        return annualInterestRate / 12;

    }

    public void withdraw(double amount) {
        setBalance(getBalance() - amount);
        transaction.add(new Transaction('W', amount, this.balance, "  Withdraw  "));
    }

    public void deposit(double amount) {
        setBalance(getBalance() + amount);
        transaction.add(new Transaction('D', amount, this.balance, " Deposit"));
    }

    public void print() {
        for (Transaction t : transaction) {
            System.out.println(t.getDateCreated() + " |  " + t.getAmount() +" | "+ t.getBalance() +" | "+ t.getDescription());

        }
    }
}

final class Transaction {

    private Date dateCreated;
    private double amount;
    private double balance;
    private String description;

    public Transaction(char type, double amount, double balance, String description) {
        setDateCreated(new Date());
        setAmount(amount);
        setBalance(balance);
        setDescription(description);
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

public class EX118Accounts {

    public static void main(String[] args) {
        Acount a = new Acount("George", 1122, 1000);
        
        a.deposit(30);
        a.deposit(40);
        a.deposit(50);
        a.withdraw(5);
        a.withdraw(4);
        a.withdraw(2);
        System.out.println("Date                         | amount     |Deposit/Withdraw");
        System.out.println("===========================================================");
        a.print();

    }

}
