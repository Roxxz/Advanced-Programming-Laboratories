import java.util.ArrayList;

public class Account {
    private String name;
    ArrayList<Account> friendsList;
    ArrayList<String> messages;

    Account(String name){
        this.name = name;
        this.messages = new ArrayList<>();
        this.friendsList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Account> getFriendsList(){
        return this.friendsList;
    }

    public ArrayList<String> getMessages(){
        return messages;
    }

    public void deleteMessages(){
        messages.clear();
    }
}
