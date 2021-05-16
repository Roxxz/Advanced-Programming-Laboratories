import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketTimeoutException;

public class SocialNetwork{
    String serverAddress;
    int PORT;
    static ServerSocket serverSocket;
    static boolean stop = false;


    SocialNetwork(int PORT, String serverAddress) throws IOException {
        this.PORT = PORT;
        this.serverAddress = serverAddress;
        serverSocket = new ServerSocket(PORT);
        serverSocket.setSoTimeout(1000 * 60 * 5);
        init();
    }

    private void init() throws IOException {
        AccountManager accountManager = new AccountManager();
        try{
            while (!stop) {
                System.out.println("Server started");
                System.out.println("Waiting for a client ...");
                try{
                    new Thread(new SocketClass(serverSocket.accept(), accountManager)).start();
                    System.out.println("Client accepted");
                }catch (SocketTimeoutException timeoutException){
                    System.out.println("Socket Timeout");
                }
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }finally{
            serverSocket.close();
            System.out.println("Server closed all connections");
        }
    }
}
