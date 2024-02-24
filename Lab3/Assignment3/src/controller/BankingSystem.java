package controller;

import model.Account;
import model.AccountType;
import model.TransType;
import model.Transaction;
import model.User;

public class BankingSystem {
    private InmemoryCollection inmemoryCollection;

    public BankingSystem() {
        inmemoryCollection = InmemoryCollection.getInstance();
    }

    public void createUser(String username, String password) {
        User newUser = new User(username, password);
        inmemoryCollection.getUsers().add(newUser);
    }

    public void createAccount(String username, String accountNumber, double balance, AccountType accountType) {
        User user = inmemoryCollection.findUserByName(username);
        if (user == null) {
            System.out.println("User not found. Please create a user first.");
            return;
        }

        Account newAccount = new Account(accountNumber, user, accountType);
        inmemoryCollection.listAccount.add(newAccount);
        System.out.println("Account created successfully!");
    }

    public boolean authenticateUser(String username, String password) {
        for (User user : inmemoryCollection.getUsers()) {
            if (user.checkUser(username, password)) {
                return true;
            }
        }
        return false;
    }

    public void printTransaction() {
        for (Transaction transaction : inmemoryCollection.getTransactions()) {
            System.out.println(transaction.toString());
        }
    }

    public void printAccountDetails(Account account) {
        System.out.println(account.toString());
    }

    public boolean deposit(String accountNumber, double amount) {
        Account account = inmemoryCollection.findAccountByAccountNumber(accountNumber);
        if (account == null) {
            System.out.println("Account not found");
            return false;
        }
        if (account.getAccountType() == AccountType.LOAN) {
            System.out.println("You can not deposit because this is a LOAN account!");
            return false;
        } else {
            String desc = new String("Deposit " + amount + " for account " + accountNumber);
            Transaction transaction = new Transaction(TransType.DEPOSIT, desc, amount, account);
            account.deposit(transaction);
            inmemoryCollection.getTransactions().add(transaction);
            System.out.println("Deposited " + amount + " Successfully! for account " + accountNumber);
            return true;
        }
    }

    public boolean withdraw(String accountNumber, double moneyWithdraw) {
        Account account = inmemoryCollection.findAccountByAccountNumber(accountNumber);
        if (account == null) {
            System.out.println("Account not found");
            return false;
        }
        if (account.getAccountType() == AccountType.CHECKING) {
            String desc = new String("Withdraw " + moneyWithdraw + " from account " + accountNumber);
            Transaction transaction = new Transaction(TransType.WITHDRAWAL, desc, moneyWithdraw, account);
            if (account.withdraw(transaction)) {
                inmemoryCollection.getTransactions().add(transaction);
                System.out.println("Withdraw " + moneyWithdraw + " Successfully! from account " + accountNumber);
                return true;
            } else
                return false;
        }
        return false;
    }

    public void transactionLog(Account account) {
        System.out.println(Account.getTransaction());
    }

}
