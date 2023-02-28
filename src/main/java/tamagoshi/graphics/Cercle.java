package tamagoshi.graphics;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * a circle that can be drawn on a graphicContext
 */
public class Cercle extends ObjetGraphique{
    private final Circle circle;

    public Cercle(Point2D centre, double rayon){
        super();
        circle = new Circle(centre.getX(), centre.getY(), rayon);
    }


    public Cercle(Point2D centre, double rayon, Color couleur){
        super(couleur);
        circle = new Circle(centre.getX(), centre.getY(), rayon);
    }

    @Override
    public void dessineToi(GraphicsContext graphicsContext) {
        double x = circle.getCenterX() - circle.getRadius()/2;
        double y = circle.getCenterY() - circle.getRadius()/2;
        graphicsContext.setStroke(getCouleur());
        graphicsContext.strokeOval(x,y, circle.getRadius(), circle.getRadius());
    }

    @Override
    public void colorieToi(GraphicsContext graphicsContext) {
        double x = circle.getCenterX() - circle.getRadius()/2;
        double y = circle.getCenterY() - circle.getRadius()/2;
        graphicsContext.setFill(getCouleur());
        graphicsContext.fillOval(x,y, circle.getRadius(), circle.getRadius());
    }

    @Override
    public boolean contient(int x, int y) {
        return circle.contains(x, y);
    }

    public double getRayon(){
        return circle.getRadius();
    }

    public Point2D getCentre(){
        return new Point2D(circle.getCenterX(), circle.getCenterY());
    }

}
