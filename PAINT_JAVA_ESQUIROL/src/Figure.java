import java.awt.*;
import java.io.Serializable;


public abstract class Figure implements Serializable { //comme indiqué dans le sujet

    public Color c;
    protected Point point;

    // Getters et setters
    public Color getC() {
        return this.c;
    }
    public Point getP() {
        return this.point;
    }
    public int getPerimeter(){return 0;}
    public int getSurface(){
        return 0;
    }

    // Méthodes

    public abstract void setBoundingBox (int length, int width);
    public abstract void draw (Graphics g);


    // Constructeur
    public Figure(Color c, Point point) {
        this.c = c;
        this.point = point;
    }


    @Override
    public String toString() {
        return "Figure : p=" + point + " ; c=" + c;
    }


}