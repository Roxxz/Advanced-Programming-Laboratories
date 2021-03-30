import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JSpinner sidesNumber;
    JComboBox<String> colorCombo = new JComboBox<>(new String[] {"Random", "Black", "Red", "Yellow", "Green", "Blue", "Pink"});
    JComboBox<String> shapeCombo = new JComboBox<>(new String[] {"Polygon", "Circle", "Free Drawing"});
    ArrayList<Shape> shapes = new ArrayList<>();
    Shape currentShape;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        JLabel sidesLabel = new JLabel( "Number of sides:" );
        sidesNumber = new JSpinner( new SpinnerNumberModel( 0, 0, 100, 1 ) );
        sidesNumber.setValue(6);

        JLabel colorLabel = new JLabel( "Color:" );
        JLabel shapeLabel = new JLabel( "Shape:" );

        add(sidesLabel);
        add(sidesNumber);
        add( colorLabel );
        add(colorCombo);
        add( shapeLabel );
        add( shapeCombo );
    }
}
