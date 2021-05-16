import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        SocialNetwork gameClient = new SocialNetwork(8100, "127.0.0.1");
        gameClient.start();

    }
}
