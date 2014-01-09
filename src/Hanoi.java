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
 * There is a lot of test with empty(), that's because if I try to pop or see
 * the top of a stack that is empty, it will throw an exception
 * 
 * Il y a un bug, dont je n'ai aucune idee de l'origine, ni pourquoi. Il apparait lors
 * de l'utilisation de la methode iterative car ce qu'il se passe, 
 * est que, lorsque le plus petit disque est en haut de la pile, il va bugger.
 * C'est a dire que lorsque je test, pour savoir si le plus petit disque est en haut de la pile, 
 * il va me renvoyer le disque qui se trouve en dessous. Et la taille de la pile sera de n-1 au
 * lieu de n et fait donc totalement bugger l'algorithme, qui lui est juste.
 * 
 * @author Nabil EL MOUSSAID
 */
public class Hanoi {

    // Lots of properties because I use them everywhere and I don't want to
    // have a constructor of ~100 lines
    private JFrame frame;
    private int moves, disks;
    private JPanel panel;
    private int width, height, xLeft, xMiddle, xRight, yBottom, yTop, pegWidth,
            pegSpace;
    private Graphics g;
    private TowerStack start, mid, finish;

    /**
     * Construct the window
     * 
     * @param nb
     */
    public Hanoi(int nb) {
        this.disks = nb;
        start = new TowerStack();
        mid = new TowerStack();
        finish = new TowerStack();
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
        yTop = yBottom - 200;
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
     */
    private void run() {
        moves = 0;
        start.setSize(0);

        for (int i = disks; i > 0; i--) {
            start.push(i);
        }
        mid.setSize(0);
        finish.setSize(0);
        drawTowers(g);
        // iterative(disks);
        moveDisks(disks, start, mid, finish);
        String out = "" + moves + " mouvements pour " + disks + " disque"
                + (moves > 1 ? "s" : "") + "";
        int x = (width - 6 * out.length()) / 2;
        g.drawString(out, x >= 0 ? x : 0,
                panel.getHeight() + (yTop - panel.getHeight()) / 2);

    }

    /**
     * Recursive function doing the work
     * 
     * @param n
     * @param start
     * @param mid
     * @param finish
     */
    public void moveDisks(int n, TowerStack start, TowerStack mid,
            TowerStack finish) {
        if (n == 0) {
            return;
        }
        moveDisks(n - 1, start, finish, mid);
        finish.push(start.pop());
        moves++;
        drawTowers(g);
        moveDisks(n - 1, mid, start, finish);
    }

    /**
     * Iterative function
     * 
     * @param nb
     * @param start
     * @param mid
     * @param finish
     */
    public void iterative(int nb) {
        /**
         * If there's only one disk
         */
        if (nb == 1) {
            finish.push(start.pop());
            moves++;
            drawTowers(g);
            return;
        }

        // If there's an even number of disk
        //
        if (nb % 2 == 0) {

            // Steps for 2 disk
            mid.push(start.pop());
            moves++;
            drawTowers(g);
            finish.push(start.pop());
            moves++;
            drawTowers(g);
            finish.push(mid.pop());
            moves++;
            drawTowers(g);

            // Steps for more than 2 disks
            while (finish.size() < nb) {
                move();
                shiftRight();
            }
            return;
        }

        // If the number of disks is odd
        //
        if (nb % 2 != 0) {
            // Beginning of the 3 disks algorithm
            finish.push(start.pop());
            moves++;
            drawTowers(g);
            mid.push(start.pop());
            moves++;
            drawTowers(g);
            mid.push(finish.pop());
            moves++;
            drawTowers(g);

            while (finish.size() < nb) {
                move();
                shiftLeft();
            }
            return;
        }
    }

    /**
     * Moves the smallest disk to the right
     */
    private void shiftRight() {
        if (!start.empty()) {
            if (start.peek() == 1) {
                mid.push(start.pop());
                moves++;
                drawTowers(g);
            }
        }
        if (!mid.empty()) {
            if (mid.peek() == 1) {
                finish.push(mid.pop());
                moves++;
                drawTowers(g);
            }
        }
        if (!finish.empty()) {
            if (finish.peek() == 1) {
                start.push(finish.pop());
                moves++;
                drawTowers(g);
            }
        }
    }

    /**
     * Move the smallest disk to the left
     */
    private void shiftLeft() {
        if (!start.empty()) {
            if (start.peek() == 1) {
                finish.push(start.pop());
                moves++;
                drawTowers(g);
            }
        }
        if (!mid.empty()) {
            if (mid.peek() == 1) {
                start.push(mid.pop());
                moves++;
                drawTowers(g);
            }
        }
        if (!finish.empty()) {
            if (finish.peek() == 1) {
                mid.push(finish.pop());
                moves++;
                drawTowers(g);
            }
        }
    }

    /**
     * Functions moving the disks according to the step
     * 
     * @param start
     * @param mid
     * @param finish
     */
    private void move() {

        /**
         * If the smallest disk is on top of the first tower
         */
        if (!start.empty()) {
            if (start.peek() == 1) {
                if (!mid.empty()) {
                    if (finish.peek() > mid.peek()) {
                        finish.push(mid.pop());
                        moves++;
                        drawTowers(g);
                    } else {
                        mid.push(finish.pop());
                        moves++;
                        drawTowers(g);
                    }
                }
                return;
            }
        }

        if (!mid.empty()) {
            if (mid.peek() == 1) {
                if (!finish.empty()) {
                    if (start.peek() > finish.peek()) {
                        start.push(finish.pop());
                        moves++;
                        drawTowers(g);
                    }
                } else {
                    finish.push(start.pop());
                    moves++;
                    drawTowers(g);
                }
                return;
            }
        }

        if (!finish.empty()) {
            if (finish.peek() == 1) {
                if (!mid.empty()) {
                    if (start.peek() > mid.peek() || start.empty()) {
                        start.push(mid.pop());
                        moves++;
                        drawTowers(g);
                    }
                } else {
                    mid.push(start.pop());
                    moves++;
                    drawTowers(g);
                }
            }
            return;
        }

    }

    /**
     * Draws the lines for the towers
     * 
     * @param g
     */
    public void drawLines(Graphics g) {
        // Draw the support
        g.setColor(Color.black);
        g.drawRoundRect((int) (0.5 * xLeft), yBottom, (int) (0.8 * width),
                (int) (0.03 * height), 10, 10);

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
        start.display(xLeft, yBottom, g);
        mid.display(xMiddle, yBottom, g);
        finish.display(xRight, yBottom, g);
        try {
            Thread.sleep(500);
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
                g.setColor(Color.black);
                g.drawRoundRect(x - width / 2, y - 10 * (i + 1), width + 1, 10,
                        10, 10);
            }
        }
    }
}
