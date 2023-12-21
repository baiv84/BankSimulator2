package transactions;

import lombok.Data;

import java.util.Objects;

@Data
public class Account {
    private String ownerName;
    private String accountNumber;
    private long money;
    private Bank myBank;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return money == account.money && Objects.equals(ownerName, account.ownerName) && Objects.equals(accountNumber, account.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownerName, accountNumber, money);
    }

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
