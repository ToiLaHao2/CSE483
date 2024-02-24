package view;

import java.util.Scanner;

import controller.BankingSystem;
import model.Account;

public class BankView {
    private BankingSystem controller;
    private Account account;
    static Scanner reader = new Scanner(System.in);

    public BankView(Account acc, BankingSystem bankingSystem) {
        controller = bankingSystem;
        this.account = acc;
    }

    public void printTransaction() {
        controller.transactionLog(account);
    }

    public void printAccountDetails() {
        System.out.println(account.toString());
    }

    public void printMenu() {
        int option = 10;

        while (option > 0) {
            System.out.println(mainMenu());
            mainOption(reader.nextInt());
        }
        System.out.println("Bye!");
    }

    public String mainMenu() {
        return "==================================== \n" +
                "Welcome \n" +
                "1. Print Account Details \n" +
                "2. Deposit \n" +
                "3. Withdraw \n" +
                "4. Print Transactions \n" +
                "0. Exit \n";
    }

    public void mainOption(int option) {
        switch (option) {
            case 1:
                this.printAccountDetails();
                break;
            case 2:
                System.out.println("Enter amount:");
                double amount = reader.nextDouble();
                if (controller.deposit(this.account.getAccountNumber(), amount)) {
                    System.out.println("Deposit Successful");
                } else {
                    System.out.println("Deposit Unsuccessful");
                }

                break;
            case 3:
                System.out.println("Enter amount:");
                double moneyWithdraw = reader.nextDouble();
                if (controller.withdraw(this.account.getAccountNumber(), moneyWithdraw)) {
                    System.out.println("Withdraw Successful");
                } else {
                    System.out.println("Withdraw Unsuccessful");
                }

                break;
            case 4:
                System.out.println("Transactions:");
                this.printTransaction();
                break;
            default:
        }
    }
}
