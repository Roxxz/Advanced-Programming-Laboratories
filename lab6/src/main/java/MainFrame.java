import com.sun.deploy.panel.ControlPanel;

import javax.swing.*;

import static javax.swing.SwingConstants.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //create the components
        canvas = new DrawingPanel(this);
        // arrange the components in the container (frame)
        // JFrame uses a BorderLayout by default
        add(canvas, SOUTH); // this is BorderLayout.CENTER.
        add(configPanel, NORTH);
        add(controlPanel, SOUTH);
        // invoke the layout manager
        pack();
    }
}