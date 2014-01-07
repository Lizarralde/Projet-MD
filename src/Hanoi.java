import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * This program show the moves of the Towers of Hanoi puzzle
 * 
 */
public class Hanoi {
    // TODO Comments/Javadoc
    
    // Lots of properties because I use them everywhere and I don't want to
    // have a constructor of ~100 lines
    // #yolo
    // #swag

    private JFrame frame;
    private int moves, disks;
    private JPanel panel;
    private int width, height, xLeft, xMiddle, xRight, yBottom, yTop, pegWidth, pegSpace;
    private Graphics g;
    private TowerStack tower1, tower2, tower3;

    /**
     * Construct the window
     */
    public Hanoi(int nb) {
        this.disks = nb;
        tower1 = new TowerStack();
        tower2 = new TowerStack();
        tower3 = new TowerStack();
        setFrame();
        setDimensions();
        setPanel();
        run();
        
    }

    /**
     * Sets the frame
     */
    private void setFrame() {
        frame = new JFrame("Tours de Hanoi : " + disks + " disques");
        Toolkit tk = Toolkit.getDefaultToolkit();
        width = tk.getScreenSize().width / 2;
        height = tk.getScreenSize().height / 2;
        frame.setSize(width, height);
        frame.setLocation(tk.getScreenSize().width / 4,
                tk.getScreenSize().height / 4);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

    }

    /**
     * Set the dimensions of the frame
     */
    private void setDimensions() {
        xLeft = (int) (0.2 * width);
        xMiddle = (int) (0.5 * width);
        xRight = (int) (int) (0.8 * width);
        yBottom = (int) (0.8 * height);
        yTop = yBottom - 250;
        pegWidth = xLeft + 150;
        pegSpace = (int) ((width - 3 * pegWidth) / 4.0);
    }

    /**
     * Set the panel
     */
    private void setPanel() {
        panel = new JPanel();
        frame.add(panel);
        frame.setVisible(true);
        g = frame.getGraphics();

    }
    
    /**
     * Run the program
     * @param n
     */
    private void run() {
        moves = 0;
        tower1.setSize(0);
        
        for (int i = disks; i > 0; i--) {
            tower1.push(i);
        }

        tower2.setSize(0);
        tower3.setSize(0);
        drawTowers(g);
        moveDisks(disks, tower1, tower2, tower3);
        String out = moves + " mouvements pour " + disks + " disque"
                + (moves > 1 ? "s" : "");
        int x = (width - 6 * out.length()) / 2;
        g.drawString(out, x >= 0 ? x : 0,
                panel.getHeight() + (yTop - panel.getHeight()) / 2);
        
    }

    /**
     * Recursive function doing the work
     * 
     * @param n
     * @param start
     * @param aux
     * @param finish
     */
    public void moveDisks(int n, TowerStack start, TowerStack aux,
            TowerStack finish) {
        if (n == 0) {
            return;
        }
        moveDisks(n - 1, start, finish, aux);
        finish.push(start.pop());
        moves++;
        drawTowers(g);
        moveDisks(n - 1, aux, start, finish);
    }

    /**
     * Draws the lines for the towers
     * 
     * @param g
     */
    public void drawLines(Graphics g) {
        
        // Draw the support
        g.setColor(Color.black);
        g.drawRoundRect((int) (0.5*xLeft), yBottom, (int) (0.8*width), (int) (0.03*height), 10, 10);
        //g.fillRoundRect((int) (0.5*xLeft), yBottom, (int) (0.8*width), (int) (0.03*height), 10, 10);
        
        g.setColor(Color.black);
        // Draw lines for the left tower
        g.drawLine(xLeft, yBottom, xLeft, yTop);
        
        // Draw lines for the middle tower
        g.drawLine(xMiddle, yBottom, xMiddle, yTop);

        // Draw lines for the right tower
        g.drawLine(xRight, yBottom, xRight, yTop);
        
    }

    /**
     * Draws towers for each step
     * 
     * @param g
     */
    public void drawTowers(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.red);
        drawLines(g);
        tower1.display(xLeft, yBottom, g);
        tower2.display(xMiddle, yBottom, g);
        tower3.display(xRight, yBottom, g);
        try {
            Thread.sleep(501);
        } catch (Exception e) {
        }
    }
    
    public static void main(String[] args) {
        new Hanoi(4);
    }

    /**
     * A helper class to hold the disks
     */
    class TowerStack extends Stack<Integer> {

        /**
         * Display disks for a step
         * 
         * @param x
         * @param y
         * @param g
         */
        public void display(int x, int y, Graphics g) {
            for (int i = 0; i < size(); i++) {
                int width = 20 * get(i);
                g.setColor(Color.red);
               // g.fillRoundRect(x - width / 2, y - 10 * (i + 1), width + 1, 10,
                 //       10, 10);
                g.setColor(Color.black);
                g.drawRoundRect(x - width / 2, y - 10 * (i + 1), width + 1, 10,
                        10, 10);
            }
        }
    }
}
