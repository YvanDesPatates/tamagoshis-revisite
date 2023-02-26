package tamagoshi.graphics;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Trait extends ObjetGraphique{
    Line trait;

    public Trait(double x1, double y1, double x2, double y2){
        this(x1, y1, x2, y2, Color.BLACK);
    }

    public Trait(double x1, double y1, double x2, double y2, Color couleur){
        super(couleur);
        trait = new Line(x1, y1, x2, y2);
    }

    @Override
    public void dessineToi(GraphicsContext graphicsContext) {
        graphicsContext.setStroke(getCouleur());
        graphicsContext.strokeLine(trait.getStartX(),
                trait.getStartY(),
                trait.getEndX(),
                trait.getEndY());
    }

    public void dessineToi(GraphicsContext graphicsContext, int epaisseurTrait){
        graphicsContext.setLineWidth(epaisseurTrait);
        dessineToi(graphicsContext);
    }

    @Override
    public void colorieToi(GraphicsContext graphicsContext) {
        dessineToi(graphicsContext);
    }

    @Override
    public boolean contient(int x, int y) {
        return trait.contains(x, y);
    }
}
