import java.awt.Color;
import java.awt.Graphics2D;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class F2kSolution extends AbstractSolution {

    private static final long serialVersionUID = -5657114344286736228L;

    public F2kSolution(int profondeur) {

        super(profondeur);
    }

    @Override
    public void drawSolutionk(Graphics2D drawingArea, int... arg) {

        if (arg[3] == 0) {

            return;
        }

        drawingArea.setColor(Color.GREEN);

        drawingArea.fillOval(arg[0], arg[1], arg[2], arg[2]);

        drawingArea.setColor(Color.BLACK);

        drawingArea.drawOval(arg[0], arg[1], arg[2], arg[2]);

        arg[3]--;

        if (arg[4] == 1) {

            drawSolutionk(drawingArea, arg[0] + arg[2] / 4,
                    arg[1] - arg[2] / 2, arg[2] / 2, arg[3], 1, 1, 0, 1);
        }

        if (arg[5] == 1) {

            drawSolutionk(drawingArea, arg[0] + arg[2], arg[1] + arg[2] / 4,
                    arg[2] / 2, arg[3], 1, 1, 1, 0);
        }

        if (arg[6] == 1) {

            drawSolutionk(drawingArea, arg[0] + arg[2] / 4, arg[1] + arg[2],
                    arg[2] / 2, arg[3], 0, 1, 1, 1);
        }

        if (arg[7] == 1) {

            drawSolutionk(drawingArea, arg[0] - arg[2] / 2,
                    arg[1] + arg[2] / 4, arg[2] / 2, arg[3], 1, 0, 1, 1);
        }
    }
}
