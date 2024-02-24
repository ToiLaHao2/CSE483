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

    @Override
    public String toString() {
        return "Account Number: " + _accountNumber + " " +
                "Account Type: " + _accountType + " " +
                "Balance: $" + String.format("%.2f", _balance) + "\n" +
                "Owner: " + _owner.toString();
    }
}
