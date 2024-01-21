
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        FileWriterFacade nFileWriterFacade = new FileWriterFacade();
        Menu menu = new Menu();
        menu.showMenu();
        int choice = sc.nextInt();
        nFileWriterFacade.writeData(choice);
    }
}
