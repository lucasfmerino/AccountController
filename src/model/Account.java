package model;

public class Account {

    private int accountNumber;
    private int agencyNumber;
    private double balance;
    private Client client;
    private String password;


    public void setAccountNumber(int number) {
        this.accountNumber = number;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAgencyNumber(int number) {
        this.agencyNumber = number;
    }

    public int getAgencyNumber() {
        return agencyNumber;
    }

    public void setBalance(double value) {
        this.balance = value;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double value) {
        this.balance += value;
    }

    public void transfer(double value) {
        this.balance -= value;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    
}

