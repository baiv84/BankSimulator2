package transactions;

import tools.ColorOutput;
import tools.LongRandomNumberGenerator;

public class TaskRunner implements Runnable{
    private final Account account;
    public TaskRunner(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        Bank bank = account.getMyBank();
        long accountBalance = 0;
        long sendMoney = 0;

        try {
            while (true) {
                Thread.sleep(1000);
                Account randomAccount = bank.getRandomAccountExceptMe(account);
                LongRandomNumberGenerator generator = new LongRandomNumberGenerator(1, 52500);
                long summOfMoney = generator.nextLong();

                if ((summOfMoney > 50000) && (bank.isFraud(account.getOwnerName(), randomAccount.getOwnerName(), summOfMoney))) {
                    String fraudMessage = new ColorOutput(String.valueOf(summOfMoney)).redMessage();
                    System.out.println(fraudMessage);
                    continue;
                }

                String sender = new ColorOutput(account.getOwnerName()).greenMessage();
                String receiver = new ColorOutput(randomAccount.getOwnerName()).blueMessage();
                String summ = new ColorOutput(String.valueOf(summOfMoney)).cyanMessage();

                String message = String.format("Sender - %s, receiver - %s, summ of money - %s", sender, receiver, summ);
                System.out.println(message);
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
