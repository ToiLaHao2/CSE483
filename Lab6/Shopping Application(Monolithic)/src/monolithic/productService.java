package monolithic;
import database.datasLayer;

public class productService {
    private datasLayer datasLayer;
    
    public productService(){

    }

    private String mainMenu() {
        return "1. List all products\n" +
                "2. Add product \n" +
                "3. Order product \n" +
                "4. View inventory";
    }
}
