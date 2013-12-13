// Pour  Graphics, Frame
import java.awt.*;

//Pour fermer
import java.awt.event.WindowAdapter;

//Pour fermer
import java.awt.event.WindowEvent;

public abstract class AbstractSolution extends Frame {

    private static final long serialVersionUID = -7936469529917708210L;

    // taille initiale de la frame
    protected static final int WIDTH = 800;

    protected static final int HEIGHT = 1200;

    // profondeur de récursivité
    protected int profondeur;

    public AbstractSolution(int profondeur) {

        this.setSize(WIDTH, HEIGHT);

        this.setVisible(true);

        this.setBackground(Color.white);

        this.profondeur = profondeur;

        // pour fermer
        addWindowListener(new WindowHandler());

        setTitle("Dessins recursifs au niveau : " + profondeur);
    }

    private class WindowHandler extends WindowAdapter {

        public void windowClosing(WindowEvent e) {

            System.exit(0);
        }
    }

    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // taille du frame, cette fois avec
        // les bordures
        int frameHeight = getSize().height;

        int frameWidth = getSize().width;

        // La couleur avec laquelle on va dessiner
        // g2d.translate(frameWidth/2,frameHeight/2); //pour déplacer l'origine
        // si besoin
        g2d.setColor(Color.black);

        // mettre ici un appel de drawSolutionk avec une liste d'arguments
        // adaptés, par exemple :
        drawSolutionk(g2d, frameWidth / 20, frameHeight / 20, frameWidth / 4,
                profondeur);
    }

    /**
     * drawSolutionk Produit un dessin recursif Parametres: Graphics drawingArea
     * : L'objet graphique dans lequel on dessine int ... arg : les coordonnées,
     * longueur et autres si besoin, et profondeur de récursivité
     **/
    public abstract void drawSolutionk(Graphics drawingArea, int... arg);
}
