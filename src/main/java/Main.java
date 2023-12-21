import tools.ColorOutput;
import tools.LongRandomNumberGenerator;
import transactions.Account;
import transactions.Bank;
import transactions.TaskRunner;

import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Bank bank = new Bank();
        bank.initializeFromJsonFile("src/main/java/accounts.json");

        Map<String, Account> items = bank.getAccounts();
        for (Map.Entry<String, Account> item: items.entrySet())
        {
            String accountNumber = item.getKey();
            Account account = item.getValue();
            Thread th = new Thread(new TaskRunner(account));
            th.start();
        }

    }
}
