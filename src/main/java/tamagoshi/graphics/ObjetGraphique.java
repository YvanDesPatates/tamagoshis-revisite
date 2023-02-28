package tamagoshi.graphics;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * graphical objects which can be drawn on a graphicContext
 */
public abstract class ObjetGraphique {
    private Color couleur;

    protected ObjetGraphique(Color couleur) {
        this.couleur = couleur;
    }

    protected ObjetGraphique(){
        this(Color.BLACK);
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    /**
     * draw the shape on the graphicsContext
     */
    public abstract void dessineToi(GraphicsContext graphicsContext);

    /**
     * draw the shape on the graphicsContext and fill it
     */
    public abstract void colorieToi(GraphicsContext graphicsContext);

    /**
     * @return true if the point (x, y) is in the area of the shape
     */
    public abstract boolean contient(int x, int y);
}
