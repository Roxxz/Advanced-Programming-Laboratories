import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SocketClass implements Runnable{
    private final Socket socket;
    private final BufferedReader in;
    private final PrintWriter out;
    private Account account=null;
    private final AccountManager accountManager;

    public SocketClass(Socket socket, AccountManager accountManager) throws IOException {
        this.socket = socket;
        this.socket.setSoTimeout(1000*60*3);
        this.accountManager = accountManager;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            while (!SocialNetwork.stop) {
                String request = in.readLine();
                String response;
                System.out.println("Server received request: " + request);

                if(request.equals("stop")){
                    response = "Server stopped";
                    out.println(response);
                    out.flush();
                    SocialNetwork.stop = true;
                    break;
                }
                else if(this.account == null){
                    response = this.commandsForNewClients(request);
                }
                else{
                    response = this.commandsForExistingClients(request);
                }

                out.println(response);
                out.flush();
            }
        } catch (SocketTimeoutException timeoutException){
            System.out.println("Socket Timeout");
    } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close();
                SocialNetwork.serverSocket.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private String commandsForExistingClients(String request) {
        if(request.startsWith("friend")){
            int firstSpace = request.indexOf(" ");
            if(firstSpace != -1){
                return this.friendClient(request.substring(firstSpace+1));
            }
        }
        else if(request.startsWith("send")){
            int firstSpace = request.indexOf(" ");
            if(firstSpace != -1){
                return this.sendMessage(request.substring(firstSpace+1));
            }
        }
        else if(request.startsWith("read")) {
            return this.readMessage();
        }

        return "Not logged";
    }

    private String readMessage() {
        return this.account.getMessages().toString();
    }

    private String sendMessage(String message) {
        try{
            if(this.account.getFriendsList().size() == 0){
                return "Empty Friends List";
            }
            if(message == null){
                return "Empty message";
            }

            for(Account acc : account.getFriendsList()) {
                acc.getMessages().add(String.format("<<From '%s'>>: %s", this.account.getName(), message));
            }

            return "Message sent";
        }catch(Exception e){
            e.printStackTrace();
            return "Account incorrect";
        }
    }

    private String friendClient(String client) {
        try{
            List<Account> accountList = new LinkedList<>();
            for(Account acc : accountManager.getAccountsList()){
                if( !this.account.getName().equals(acc.getName()) && this.account.getFriendsList().stream()
                .filter(item -> item.getName().equals(client)).toArray().length == 0){
                    accountList.add(acc);
                    acc.getFriendsList().add(this.account);
                    this.account.getFriendsList().add(acc);
                    break;
                }
            }

            if(accountList.size() == 0){
                return "This account doesn't exist";
            }
            return "Friendship created";
        }catch (Exception e){
            e.printStackTrace();
            return "Account incorrect";
        }
    }

    private String commandsForNewClients(String request) {
        if (request.startsWith("login")) {
            int firstSpace = request.indexOf(" ");
            if (firstSpace != -1) {
                return this.loginClient(request.substring(firstSpace + 1));
            }
        }
        else if(request.startsWith("register")){
            int firstSpace = request.indexOf(" ");
            if(firstSpace != -1){
                 return this.registerClient(request.substring(firstSpace+1));
            }
        }
        return "Unknown command";
    }

    private String registerClient(String name) {
        if (name != null) {
            try {
                accountManager.addAccount(new Account(name));
                return "Successfully registered";
            } catch (Exception e) {
                System.out.println("Internal error");
            }
        }
        return "Empty name";
    }

    private String loginClient(String name) {
        if (name != null) {
            try {
                List<Account> results = accountManager.getAccountsList()
                        .stream().filter(e -> e.getName().equals(name)).collect(Collectors.toList());
                if (results.size() == 0) {
                    return "Account with this name does not exits";
                }
                this.account = results.get(0);
                return "Successfully logged in";
            } catch (Exception e) {
                System.out.println("Internal error");
            }
        }
        return "Empty name";
    }
}