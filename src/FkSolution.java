import java.awt.Graphics;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class FkSolution extends AbstractSolution {

    public FkSolution(int profondeur) {

        super(profondeur);
    }

    private static final long serialVersionUID = -94828715077855826L;

    @Override
    public void drawSolutionk(Graphics drawingArea, int... arg) {

        if (arg[3] == 0) {

            return;
        }

        drawingArea.drawOval(arg[0], arg[1], arg[2], arg[2]);

        arg[3]--;

        drawEastSolutionk(drawingArea, arg[0] + arg[2], arg[1] + arg[2] / 4,
                arg[2] / 2, arg[3]);

        drawSouthSolutionk(drawingArea, arg[0] + arg[2] / 4, arg[1] + arg[2],
                arg[2] / 2, arg[3]);

        drawWestSolutionk(drawingArea, arg[0] - arg[2] / 2, arg[1] + arg[2] / 4,
                arg[2] / 2, arg[3]);

        drawNorthSolutionk(drawingArea, arg[0] + arg[2] / 4, arg[1] - arg[2] / 2,
                arg[2] / 2, arg[3]);
    }

    public void drawNorthSolutionk(Graphics drawingArea, int... arg) {

        if (arg[3] == 0) {

            return;
        }

        drawingArea.drawOval(arg[0], arg[1], arg[2], arg[2]);

        arg[3]--;

        drawEastSolutionk(drawingArea, arg[0] + arg[2], arg[1] + arg[2] / 4,
                arg[2] / 2, arg[3]);

        drawWestSolutionk(drawingArea, arg[0] - arg[2] / 2, arg[1] + arg[2] / 4,
                arg[2] / 2, arg[3]);

        drawNorthSolutionk(drawingArea, arg[0] + arg[2] / 4, arg[1] - arg[2] / 2,
                arg[2] / 2, arg[3]);
    }

    public void drawSouthSolutionk(Graphics drawingArea, int... arg) {

        if (arg[3] == 0) {

            return;
        }

        drawingArea.drawOval(arg[0], arg[1], arg[2], arg[2]);

        arg[3]--;

        drawEastSolutionk(drawingArea, arg[0] + arg[2], arg[1] + arg[2] / 4,
                arg[2] / 2, arg[3]);

        drawWestSolutionk(drawingArea, arg[0] - arg[2] / 2, arg[1] + arg[2] / 4,
                arg[2] / 2, arg[3]);

        drawSouthSolutionk(drawingArea, arg[0] + arg[2] / 4, arg[1] + arg[2],
                arg[2] / 2, arg[3]);
    }

    public void drawEastSolutionk(Graphics drawingArea, int... arg) {

        if (arg[3] == 0) {

            return;
        }

        drawingArea.drawOval(arg[0], arg[1], arg[2], arg[2]);

        arg[3]--;

        drawNorthSolutionk(drawingArea, arg[0] + arg[2] / 4, arg[1] - arg[2] / 2,
                arg[2] / 2, arg[3]);

        drawEastSolutionk(drawingArea, arg[0] + arg[2], arg[1] + arg[2] / 4,
                arg[2] / 2, arg[3]);

        drawSouthSolutionk(drawingArea, arg[0] + arg[2] / 4, arg[1] + arg[2],
                arg[2] / 2, arg[3]);
    }

    public void drawWestSolutionk(Graphics drawingArea, int... arg) {

        if (arg[3] == 0) {

            return;
        }

        drawingArea.drawOval(arg[0], arg[1], arg[2], arg[2]);

        arg[3]--;

        drawNorthSolutionk(drawingArea, arg[0] + arg[2] / 4, arg[1] - arg[2] / 2,
                arg[2] / 2, arg[3]);

        drawSouthSolutionk(drawingArea, arg[0] + arg[2] / 4, arg[1] + arg[2],
                arg[2] / 2, arg[3]);

        drawWestSolutionk(drawingArea, arg[0] - arg[2] / 2, arg[1] + arg[2] / 4,
                arg[2] / 2, arg[3]);
    }

    public void drawOldSolutionk(Graphics drawingArea, int... arg) {

        if (arg[3] == 0) {

            return;
        }

        drawingArea.drawOval(arg[0], arg[1], arg[2], arg[2]);

        arg[3]--;

        drawSolutionk(drawingArea, arg[0] + arg[2], arg[1] + arg[2] / 4,
                arg[2] / 2, arg[3]);

        drawSolutionk(drawingArea, arg[0] + arg[2] / 4, arg[1] + arg[2],
                arg[2] / 2, arg[3]);
    }
}
