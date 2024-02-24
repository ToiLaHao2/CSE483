package model;

import java.time.LocalDateTime;

public class Transaction {
    private TransType _transType;
    private String _description;
    private double _amount;
    private Account _account;
    private LocalDateTime _timestamp;

    public Transaction(TransType transType, String description, double amount, Account account) {
        this._transType = transType;
        this._description = description;
        this._amount = amount;
        this._account = account;
        this._timestamp = LocalDateTime.now();
    }

    public String getDescription() {
        return this._description.toString();
    }

    public double getAmount() {
        return this._amount;
    }

    public String accountNumber() {
        return _account.getAccountNumber();
    }

    public String transactTime() {
        return this._timestamp.toString();
    }

    @Override
    public String toString() {
        return "Transaction: \n" +
                "   Type: " + this._transType + " " +
                "   Description: " + this._description + " " +
                "   Amount: $" + this._amount + " " +
                "   Account Number: " + this.accountNumber() + " " +
                "   Time Stamp: " + this.transactTime() + " ";
    }
}
