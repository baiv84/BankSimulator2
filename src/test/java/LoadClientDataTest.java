import com.fasterxml.jackson.databind.ObjectMapper;
import tools.JsonDataLoader;
import org.junit.Assert;
import org.junit.Test;
import transactions.Account;
import transactions.Bank;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoadClientDataTest {
    private final ObjectMapper mapper = new ObjectMapper();
    private final List<Account> accounts = new ArrayList<>();
    private final JsonDataLoader dataLoader = new JsonDataLoader();

    @Test
    public void toJson_validObject_success() {
        accounts.add(new Account("Ivan Babintsev","12345678", 1000000));
        String json = dataLoader.toJson(accounts);
        System.out.println("Result - "+json);
    }

    @Test
    public void fromJson_validObject_success() throws IOException {
        List<Account> myAccounts = Arrays.asList(mapper.readValue(Paths.get("src/main/java/accounts.json").toFile(),
                Account[].class));
        myAccounts.forEach(System.out::println);
    }

    @Test
    public void totalMoney_calculate_success() throws IOException {
        Bank bank = new Bank();
        bank.initializeFromJsonFile("src/main/java/accounts.json");
        Assert.assertEquals(bank.getSumAllAccounts(),6435929);
    }
}
