import java.awt.*;

public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setLocation( dim.width / 2 - mainFrame.getSize().width / 2, dim.height / 2 - mainFrame.getSize().height / 2);
        mainFrame.setVisible( true );
    }
}
