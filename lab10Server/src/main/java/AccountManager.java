import java.util.LinkedList;
import java.util.List;

public class AccountManager {
    private List<Account> accountsList;

    AccountManager(){
        accountsList = new LinkedList<>();
    }

    public synchronized List<Account> getAccountsList() {
        return accountsList;
    }

    public synchronized void addAccount(Account account){
        this.accountsList.add(account);
    }

}
