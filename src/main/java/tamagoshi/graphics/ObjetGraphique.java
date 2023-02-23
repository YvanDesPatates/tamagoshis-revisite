package tamagoshi.graphics;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

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

    public abstract void dessineToi(GraphicsContext graphicsContext);
    public abstract void colorieToi(GraphicsContext graphicsContext);


    public abstract boolean contient(int x, int y);
}
