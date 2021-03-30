import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton undoBtn = new JButton("Undo");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {

        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(undoBtn);
        add(exitBtn);

        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        undoBtn.addActionListener(this::undo);
        exitBtn.addActionListener(this::exit);
    }

    private void save(ActionEvent e) {
        try {
            JFileChooser fileChooser = new JFileChooser();
            int returnVal = fileChooser.showOpenDialog(this);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                ImageIO.write( frame.canvas.image, "PNG", file );
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private void load(ActionEvent e){
        try{
            JFileChooser fileChooser = new JFileChooser();
            BufferedImage image;
            int returnVal = fileChooser.showOpenDialog( this );
            if(returnVal == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                image = ImageIO.read( file );
                frame.canvas.graphics.drawImage( image, 0, 0, this );
            }
        }catch(IOException ex){
            System.err.println(ex);
        }
    }

    private void reset(ActionEvent e){
        frame.canvas.reset();
    }

    private void undo(ActionEvent e){
        frame.canvas.clearLastShape();
    }

    private void exit(ActionEvent e){
        System.exit( 0 );
    }
}
