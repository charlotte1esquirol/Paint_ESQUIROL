import java.awt.*;

public class Rectangle extends Figure {
    public int width=0;
    public int length=0;

    // Constructeur
    public Rectangle(int px, int py, Color c){
        super(c, new Point(px,py));
    }


    // Getters et Setters
    public int getWidth() {
        return this.width;
    }
    public int getLength() {
        return this.length;
    }
    public int setLength() {
        return length;
    }
    public int setWidth() {
        return width;
    }
    public int getPerimeter() {
        return (this.getP().getX()+this.getP().getY())*2;
    }
    public int getSurface(){
        return this.getP().getX()*this.getP().getY();
    }


    // Méthodes

    // Pour cette méthode, vu que la forme est un rectangle,
    // on récupère length et width pour définir la taille de la bounding box.
    @Override
    public void setBoundingBox (int heightBB, int widthBB){
        length = heightBB;
        width = widthBB;
    }

    @Override
    public void draw(Graphics g) {
        Color c = this.getC();
        int px = this.getP().getX();
        int py = this.getP().getY();
        int width = this.getWidth();
        int length = this.getLength();
        g.setColor(c);
        if (width > 0 && length > 0) {   //4 cas selon la direction
            g.fillRect(px, py, width, length);
        } else if (width > 0 && length < 0) {
            g.fillRect(px, py + length, width, -length);
        } else if (width < 0 && length > 0) {
            g.fillRect(px + width, py, -width, length);
        } else {
            g.fillRect(px + width, py + length, -width, -length);
        }

    }

    @Override
    public String toString() {
        return "Rectangle : px="+length+" ; py="+width+" ; c="+c;
    }

}