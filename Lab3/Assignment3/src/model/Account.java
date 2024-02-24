package model;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String _accountNumber;
    private double _balance;
    private User _owner;
    private AccountType _accountType;
    private List<String> _transactionHistory;

    public Account(String accountNumber, User owner, AccountType accountType) {
        this._accountNumber = accountNumber;
        this._balance = 0;
        this._owner = owner;
        this._accountType = accountType;
        this._transactionHistory = new ArrayList<>();
    }

    public Account(String accountNumber, User user) {
        this._accountNumber = accountNumber;
        this._owner = user;
        this._balance = 0;
        this._transactionHistory = new ArrayList<>();
    }

    public String getAccountNumber() {
        return _accountNumber;
    }

    public double getBalance() {
        return _balance;
    }

    public AccountType getAccountType() {
        return this._accountType;
    }

    public boolean compareOwner(User user) {
        if (this._owner.getName() == user.getName()) {
            return true;
        } else {
            return false;
        }
    }

    public void setAccountType(int accountType) {
        if (accountType == 1) {
            this._accountType = AccountType.CHECKING;
        }
        if (accountType == 2) {
            this._accountType = AccountType.LOAN;
        }
        if (accountType == 3) {
            this._accountType = AccountType.SAVINGS;
        }
    }

    public void deposit(Transaction transaction) {
        _transactionHistory.add(transaction.toString());
        this._balance += transaction.getAmount();
    }

    public boolean withdraw(Transaction transaction) {
        if (this._balance >= transaction.getAmount()) {
            this._balance -= transaction.getAmount();
            _transactionHistory.add(transaction.toString());
            return true;
        } else {
            return false;
        }
    }

    public String getTransaction() {
        StringBuilder sb = new StringBuilder();
        for (String tr : this._transactionHistory) {
            sb.append(tr + "/n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Account Number: " + _accountNumber + " " +
                "Account Type: " + _accountType + " " +
                "Balance: $" + String.format("%.2f", _balance) + "\n" +
                "Owner: " + _owner.toString();
    }
}
