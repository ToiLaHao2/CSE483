
import controller.BankingSystem;
import model.Account;
import view.BankView;
import view.LoginView;

public class App {
    public static void main(String[] args) throws Exception {
        BankingSystem bankingSystem = new BankingSystem();
        LoginView login = new LoginView(bankingSystem);
        boolean checking = false;
        Account acc = null;
        while (checking == false) {
            System.out.println("Wrong Information");
            checking = login.Login();
            if (checking == true) {
                acc = login.getAcc();
                break;
            }
        }
        BankView bankView = new BankView(acc, bankingSystem);
        bankView.printMenu();
    }
}
