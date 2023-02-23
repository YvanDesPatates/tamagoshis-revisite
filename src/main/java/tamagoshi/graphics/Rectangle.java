package tamagoshi.graphics;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends ObjetGraphique{
    private final Rectangle2D rectangle2D;

    public Rectangle(){
        rectangle2D = Rectangle2D.EMPTY;
    }

    public Rectangle(double x, double y, double largeur, double hauteur){
        this(new Point2D(x, y), largeur, hauteur);
    }

    public Rectangle(Point2D p, double largeur, double hauteur){
        super();
        rectangle2D = new Rectangle2D(p.getX(), p.getY(), largeur, hauteur);
    }

    public Rectangle(Point2D p, double largeur, double hauteur, Color c){
        this(p.getX(), p.getY(), largeur, hauteur, c);
    }

    public Rectangle(double x, double y, double largeur, double hauteur, Color couleur){
        super(couleur);
        rectangle2D = new Rectangle2D(x, y, largeur, hauteur);
    }


    @Override
    public void dessineToi(GraphicsContext graphicsContext) {
        graphicsContext.setStroke(getCouleur());
        graphicsContext.strokeRect(rectangle2D.getMinX(),
                rectangle2D.getMinY(),
                rectangle2D.getWidth(),
                rectangle2D.getHeight());
    }

    @Override
    public void colorieToi(GraphicsContext graphicsContext) {
        graphicsContext.setFill(getCouleur());
        graphicsContext.fillRect(rectangle2D.getMinX(),
                rectangle2D.getMinY(),
                rectangle2D.getWidth(),
                rectangle2D.getHeight());
    }

    @Override
    public boolean contient(int x, int y) {
        return rectangle2D.contains(x, y);
    }
}
