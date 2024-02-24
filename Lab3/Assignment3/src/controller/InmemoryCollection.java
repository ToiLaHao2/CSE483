package controller;

import java.util.ArrayList;
import java.util.Random;

import model.Account;
import model.Transaction;
import model.User;

public class InmemoryCollection {
    private static InmemoryCollection instance;
    ArrayList<Account> listAccount;
    ArrayList<User> listUser;
    ArrayList<Transaction> listTransaction;

    public static InmemoryCollection getInstance() {
        if (instance == null) {
            instance = new InmemoryCollection();
        }
        return instance;
    }

    private InmemoryCollection() {
        listAccount = new ArrayList<>();
        listUser = new ArrayList<>();
        Random rd = new Random();

        String[] userName1 = { "Nguyen Van A", "Nguyen Van B", "Nguyen Van C", "Nguyen Van D", "Nguyen Van E" };

        for (int i = 0; i < userName1.length; i++) {
            User user = new User(userName1[i], "123");
            listUser.add(user);
            listAccount.add(new Account("Account" + i, user));
        }

        for (Account acc : listAccount) {
            int accountType = rd.nextInt(1, 3);
            acc.setAccountType(accountType);
        }
    }

    public ArrayList<Account> getAccounts() {
        return this.listAccount;
    }

    public ArrayList<User> getUsers() {
        return this.listUser;
    }

    public User findUserByName(String name) {
        for (User u : this.getUsers()) {
            if (u.getName().equalsIgnoreCase(name))
                return u;
        }
        return null;
    }

    public Account findAccountByAccountNumber(String number) {
        for (Account a : this.getAccounts()) {
            if (a.getAccountNumber().equalsIgnoreCase(number))
                return a;
        }
        return null;
    }

    public ArrayList<Transaction> getTransactions() {
        return this.listTransaction;
    }
}
