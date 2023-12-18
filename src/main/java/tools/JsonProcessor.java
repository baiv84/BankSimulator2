package tools;

import transactions.Account;
import java.util.List;

public interface JsonProcessor {
    String toJson(List<Account> accounts);
    List<Account> fromJson(String json);
}
