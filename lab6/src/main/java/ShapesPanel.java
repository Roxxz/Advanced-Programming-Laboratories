import javax.swing.*;

public class ShapesPanel extends JPanel {
    final MainFrame frame;

    ShapesPanel(MainFrame frame){
        this.frame = frame;
        init();
    }

    private void init(){
        JLabel label = new JLabel("Available shapes:");
        JList<String> list = new JList<>( new String [] {"Regular Polygon", "Circle", "Free Drawing"});
        add( label );
        add( list );
    }
}
