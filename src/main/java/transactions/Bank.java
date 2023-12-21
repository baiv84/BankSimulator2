package transactions;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

@Data
public class Bank {
    private final Map<String, Account> accounts = new HashMap<>();
    private final Random random = new Random();

    /* Fraud decision-making procedure */
    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }


    /* TODO: Add new account into bank accounts storage */
    public void addNewAccount(String accNumber, Account account) {
        accounts.put(accNumber, account);
    }

    public void initializeFromJsonFile(String filePath) {
        accounts.clear();
        ObjectMapper mapper = new ObjectMapper();
        List<Account> myAccounts;

        try {
            myAccounts = Arrays.asList(mapper.readValue(Paths.get(filePath).toFile(), Account[].class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        myAccounts.forEach(account -> {
            account.setMyBank(this);
            String accNum = account.getAccountNumber();
            addNewAccount(accNum, account);
        });

    }

    /* TODO: Return Account entity with particular account number */
    public List<Account> getAccountObjectByNumber(String number) {
        List<Account> foundAccounts = new ArrayList<>();
        if ((accounts.containsKey(number))) {
            foundAccounts.add(accounts.get(number));
        }
        return foundAccounts;
    }


    public Account getRandomAccountExceptMe(Account account) {
        Set<String> keysAccount = accounts.keySet();
        Object[] keysAsArray = keysAccount.toArray();

        int randomIndex = 0;
        int size = keysAccount.size();
        Account randomAccount;

        while (true) {
            randomIndex = new Random().nextInt(size);
            String randomKey = (String)keysAsArray[randomIndex];
            randomAccount = accounts.get(randomKey);

           if (!randomAccount.equals(account)) {
               break;
           }
        }
        return randomAccount;
    }


    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public boolean transfer(String fromAccountNum, String toAccountNum, long amount) {
//        boolean transferResult = true;
//        Client from = new Client();
//        Client to = new Client();
//
//        List<Client> fromClients = getClientsByAccountNumber(fromAccountNum);
//        if (!fromClients.isEmpty()) {
//            from = fromClients.getFirst();
//        }
//        else {
//            transferResult = false;
//        }
//
//        List<Client> toClients = getClientsByAccountNumber(fromAccountNum);
//        if (!toClients.isEmpty()) {
//            to = toClients.getFirst();
//        }
//        else {
//            transferResult = false;
//        }
//
//        if (transferResult) {
//            from.sendMoney(to, 1000);
//        }
        return true;
    }


    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        List<Account> accounts = getAccountObjectByNumber(accountNum);
        return accounts.isEmpty() ? -1 :accounts.getFirst().getMoney();
    }

    public long getSumAllAccounts() {
        long totalSum = 0;
        Set<String> keys = accounts.keySet();

        for (String key : keys) {
            Account account = accounts.get(key);
            totalSum += account.getMoney();
        }
        return  totalSum;
    }
}

