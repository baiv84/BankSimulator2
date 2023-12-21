package transactions;

public class TaskRunner implements Runnable{
    private final Account account;
    public TaskRunner(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        Bank bank = account.getMyBank();
        try {
            while (true) {
                Thread.sleep(1000);
                Account randomAccount = bank.getRandomAccountExceptMe(account.getAccountNumber());
                System.out.println("Random account to send money: " + randomAccount.getOwnerName());
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
