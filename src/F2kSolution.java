import java.awt.Graphics;

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

        drawWestSolutionk(drawingArea, arg[0] - arg[2] / 2,
                arg[1] + arg[2] / 4, arg[2] / 2, arg[3]);

        drawNorthSolutionk(drawingArea, arg[0] + arg[2] / 4, arg[1] - arg[2]
                / 2, arg[2] / 2, arg[3]);
    }

    public void drawNorthSolutionk(Graphics drawingArea, int... arg) {

        if (arg[3] == 0) {

            return;
        }

        drawingArea.drawOval(arg[0], arg[1], arg[2], arg[2]);

        arg[3]--;

        drawEastSolutionk(drawingArea, arg[0] + arg[2], arg[1] + arg[2] / 4,
                arg[2] / 2, arg[3]);

        drawWestSolutionk(drawingArea, arg[0] - arg[2] / 2,
                arg[1] + arg[2] / 4, arg[2] / 2, arg[3]);

        drawNorthSolutionk(drawingArea, arg[0] + arg[2] / 4, arg[1] - arg[2]
                / 2, arg[2] / 2, arg[3]);
    }

    public void drawSouthSolutionk(Graphics drawingArea, int... arg) {

        if (arg[3] == 0) {

            return;
        }

        drawingArea.drawOval(arg[0], arg[1], arg[2], arg[2]);

        arg[3]--;

        drawEastSolutionk(drawingArea, arg[0] + arg[2], arg[1] + arg[2] / 4,
                arg[2] / 2, arg[3]);

        drawWestSolutionk(drawingArea, arg[0] - arg[2] / 2,
                arg[1] + arg[2] / 4, arg[2] / 2, arg[3]);

        drawSouthSolutionk(drawingArea, arg[0] + arg[2] / 4, arg[1] + arg[2],
                arg[2] / 2, arg[3]);
    }

    public void drawEastSolutionk(Graphics drawingArea, int... arg) {

        if (arg[3] == 0) {

            return;
        }

        drawingArea.drawOval(arg[0], arg[1], arg[2], arg[2]);

        arg[3]--;

        drawNorthSolutionk(drawingArea, arg[0] + arg[2] / 4, arg[1] - arg[2]
                / 2, arg[2] / 2, arg[3]);

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

        drawNorthSolutionk(drawingArea, arg[0] + arg[2] / 4, arg[1] - arg[2]
                / 2, arg[2] / 2, arg[3]);

        drawSouthSolutionk(drawingArea, arg[0] + arg[2] / 4, arg[1] + arg[2],
                arg[2] / 2, arg[3]);

        drawWestSolutionk(drawingArea, arg[0] - arg[2] / 2,
                arg[1] + arg[2] / 4, arg[2] / 2, arg[3]);
    }

    public static void main(String[] args) {

        Parser p = new Parser();

        new F2kSolution(p.getInt());
    }
}
