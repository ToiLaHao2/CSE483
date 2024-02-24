package view;

import java.util.Scanner;

import controller.authenticateUser;

public class LoginView {
    private Scanner sc;
    private String username;
    private String password;

    public LoginView() {
        sc = new Scanner(System.in);
        System.out.println("Enter your account name");
        String userNameInput = sc.nextLine();
        this.username = userNameInput;
        System.out.println("Enter password");
        String passWordInput = sc.nextLine();
        this.password = passWordInput;
        if (authenticateUser() == true) {
            System.out.println("Welcome " + username + ", you are successfully logged in.");
        } else {
            System.out.println("Username or Password is incorrect!");
        }
    }

    private boolean authenticateUser() {
        authenticateUser authenticate = new authenticateUser();
        return authenticate.authenticate(username, password);
    }
}
