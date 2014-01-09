import java.awt.Graphics;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class F3kSolution extends AbstractSolution {

    private static final long serialVersionUID = -6414867756496912758L;

    public F3kSolution(int profondeur) {

        super(profondeur);
    }

    @Override
    public void drawSolutionk(Graphics drawingArea, int... arg) {

        if (arg[3] == 0) {

            return;
        }

        drawingArea.drawRect(arg[0], arg[1], arg[2], arg[2]);

        arg[3]--;

        if (arg[4] == 1) {

            drawSolutionk(drawingArea, arg[0], arg[1] - arg[2] / 2, arg[2] / 2,
                    arg[3], 1, 1, 0, 1);
        }

        if (arg[5] == 1) {

            drawSolutionk(drawingArea, arg[0] + arg[2], arg[1], arg[2] / 2,
                    arg[3], 1, 1, 1, 0);
        }

        if (arg[6] == 1) {

            drawSolutionk(drawingArea, arg[0] + arg[2] / 2, arg[1] + arg[2],
                    arg[2] / 2, arg[3], 0, 1, 1, 1);
        }

        if (arg[7] == 1) {

            drawSolutionk(drawingArea, arg[0] - arg[2] / 2,
                    arg[1] + arg[2] / 2, arg[2] / 2, arg[3], 1, 0, 1, 1);
        }
    }
}
