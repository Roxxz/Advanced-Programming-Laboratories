import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 1280, H = 720;
    Point point1 = new Point();
    Point point2 = new Point();
    BufferedImage image;
    Graphics2D graphics;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);

    }

    private void init() {
        setPreferredSize(new Dimension(W, H));
        this.addMouseListener( new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            } //cant use lambdas
        } );
    }

    private void drawShape(int x, int y){
        Random random = new Random();
        int radius = random.nextInt(200);
        String pickedShape = (String) frame.configPanel.shapeCombo.getSelectedItem();
        int sides = (int) frame.configPanel.sidesNumber.getValue();
        String pickedColor = (String) frame.configPanel.colorCombo.getSelectedItem();

        Color color = Color.BLACK;

        if (pickedColor != null) {
            switch (pickedColor) {
                case "Random":
                    color = new Color( random.nextInt( 255 ), random.nextInt( 100 ), random.nextInt( 200 ) );
                    break;
                case "Black":
                    color = Color.BLACK;
                    break;
                case "Blue":
                    color = Color.BLUE;
                    break;
                case "Green":
                    color = Color.GREEN;
                    break;
                case "Yellow":
                    color = Color.YELLOW;
                    break;
                case "Red":
                    color = Color.RED;
                    break;
                case "Pink":
                    color = Color.MAGENTA;
                    break;
            }
        }

        graphics.setColor(color);

        if (pickedShape != null) {
            switch (pickedShape){
                case "Polygon":
                    frame.configPanel.currentShape = new RegularPolygon(x,y,radius,sides);
                    graphics.fill( frame.configPanel.currentShape );
                    frame.configPanel.shapes.add( frame.configPanel.currentShape );
                    break;
                case "Circle":
                    frame.configPanel.currentShape = new CircleShape(x, y, radius);
                    graphics.fill( frame.configPanel.currentShape );
                    frame.configPanel.shapes.add( frame.configPanel.currentShape );
                    break;
                case "Free Drawing":
                    setDoubleBuffered(false);
                    setDoubleBuffered(false);
                    addMouseListener(new MouseAdapter() {
                        public void mousePressed(MouseEvent e) {
                            point1.x = e.getX();
                            point1.y = e.getY();
                        }
                    });

                    addMouseMotionListener(new MouseMotionAdapter() {
                        public void mouseDragged(MouseEvent e) {
                            point2.x = e.getX();
                            point2.y = e.getY();

                            if (graphics != null) {
                                graphics.drawLine(point1.x, point1.y, point2.x, point2.y);
                                repaint();
                                point1.x = point2.x;
                                point1.y = point2.y;
                            }
                        }
                    });
                    break;
            }
        }
    }

    protected void reset(){
        frame.configPanel.shapes.clear();
        createOffscreenImage();
        update( graphics );
    }

    public void clearLastShape()
    {
        int size = frame.configPanel.shapes.size();
        if(size > 0){
            graphics.setColor( Color.WHITE );
            graphics.fill( frame.configPanel.shapes.get( size-1 ) );
            frame.configPanel.shapes.remove( frame.configPanel.shapes.get( size-1 ) );
        }
        repaint();
    }

    @Override
    public void update(Graphics g) {
        updateUI();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage( image, 0, 0, this );
        update( g );
    }
}
