import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocialNetwork {
    String serverAddress;
    int PORT;
    PrintWriter out;
    BufferedReader in;
    int check = 0 ;

    SocialNetwork(int PORT, String serverAddress) throws IOException {
        this.PORT = PORT;
        this.serverAddress = serverAddress;
    }

    public void start(){
        try {
            Socket socket = new Socket(serverAddress, PORT);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true) {

                Scanner keyboard = new Scanner(System.in).useDelimiter("\\n");
                System.out.println(">");
                String command = keyboard.next();

                if(command.equals("stop")){
                    check++;
                }
                if (command.equals("exit") && check == 1) {
                    System.out.println("You closed connection with the server");
                    break;
                }

                out.println(command);

                String response = in.readLine();
                System.out.println(response);

            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        } catch (IOException e) {
            System.err.println("Error: " + e);
        }finally {
            try {
                in.close();
                out.close();
            } catch (IOException exception) {
                System.err.println("Error: " + exception);
            }


        }
    }
}
