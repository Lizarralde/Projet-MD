import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

/**
 * Où comment tracer un cercle avec des carrés. Pour un effet optimal, utilisez
 * un gros niveau de récursion (e.g. 512).
 * 
 * @author Dorian LIZARRALDE
 * 
 * 
 */
public class F4kSolution extends AbstractSolution {

    private static final long serialVersionUID = -5084512126828368692L;

    private Random r;

    public F4kSolution(int profondeur) {

        super(profondeur);
    }

    @Override
    public void drawSolutionk(Graphics2D drawingArea, int... arg) {

        if (arg[3] == 0) {

            return;
        }

        if (arg[4] == 1) {

            r = new Random();
        }

        drawingArea.setColor(new Color(r.nextFloat(), r.nextFloat(), r
                .nextFloat(), r.nextFloat()));

        drawingArea.drawRect(0, 0, arg[2], arg[2]);

        drawingArea.rotate(Math.PI / 256);

        arg[3]--;

        drawSolutionk(drawingArea, arg[0], arg[1], arg[2], arg[3], 0);
    }
}
