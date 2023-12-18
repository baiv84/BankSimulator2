import tools.ColorOutput;
import transactions.Bank;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Bank bank = new Bank();
        bank.initializeFromJsonFile("src/main/java/accounts.json");

        ColorOutput output = new ColorOutput();
        String message = output.yellowMessage("Bank initialized.");
        System.out.println(message);
    }
}
