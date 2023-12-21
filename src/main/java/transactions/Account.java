package transactions;

import lombok.Data;

@Data
public class Account {
    private String ownerName;
    private String accountNumber;
    private long money;
    private Bank myBank;


    public Account() {
    }

    public Account(String ownerName, String accountNumber, long money) {
        this.ownerName = ownerName;
        this.accountNumber = accountNumber;
        this.money = money;
    }

    @Override
    public String toString() {
        return  "ownerName='" + ownerName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", money=" + money ;
    }

    public void incrementMoney(long money) {
        this.money += money;
    }

    public void decrementMoney(long money) {
        this.money -= money;
    }

}
