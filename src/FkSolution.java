import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class FkSolution extends AbstractSolution {

    private static final long serialVersionUID = -94828715077855826L;

    public FkSolution(int profondeur) {

        super(profondeur);
    }

    @Override
    public void drawSolutionk(Graphics drawingArea, int... arg) {

        if (arg[3] == 0) {

            drawingArea.drawRect(40, 54, 400, 400);
            return;
        }

        drawingArea.setColor(Color.PINK);

        drawingArea.fillOval(arg[0], arg[1], arg[2], arg[2]);

        drawingArea.setColor(Color.BLACK);

        drawingArea.drawOval(arg[0], arg[1], arg[2], arg[2]);

        arg[3]--;

        drawSolutionk(drawingArea, arg[0] + arg[2], arg[1] + arg[2] / 4,
                arg[2] / 2, arg[3]);

        drawSolutionk(drawingArea, arg[0] + arg[2] / 4, arg[1] + arg[2],
                arg[2] / 2, arg[3]);
    }

    public static void main(String[] args) {

        Parser p = new Parser();

        new FkSolution(p.getInt());
    }
}
