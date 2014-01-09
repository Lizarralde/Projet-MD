import java.awt.Color;
import java.awt.Graphics2D;

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
    public void drawSolutionk(Graphics2D drawingArea, int... arg) {

        if (arg[3] == 0) {

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
}
