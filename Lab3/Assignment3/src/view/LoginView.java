package view;

import java.util.Scanner;

import controller.BankingSystem;
import model.Account;

public class LoginView {
    private Scanner sc;
    private BankingSystem _BankingSystem;
    private Account acc;

    public LoginView(BankingSystem bankingSystem) {
        this._BankingSystem = bankingSystem;
        this.sc = new Scanner(System.in);
    }

    public boolean Login() {
        System.out.println("Please enter your username:");
        String userName = sc.nextLine();
        System.out.println("Please enter your password:");
        String password = sc.nextLine();
        acc = _BankingSystem.authenticateUser(userName, password);
        if (acc != null) {
            return true;
        } else {
            return false;
        }
    }

    public Account getAcc() {
        return acc;
    }
}
