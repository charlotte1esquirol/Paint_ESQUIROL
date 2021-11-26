import java.awt.*;

public class Ellipse extends Figure{
    protected int semiAxisX=0 ;
    protected int semiAxisY=0 ;


    // Constructeur
    public Ellipse(int px, int py, Color c) {
        super(c, new Point(px, py));
    }

    // Getters et setters
    public int getPerimeter() {

        return (int) (2*3.1416*(Math.sqrt(((this.getP().getX()*this.getP().getY())+(this.getP().getX()*this.getP().getY())/2))));
    }
    public int getSurface(){
        return (int) (this.getP().getX()*this.getP().getY()*3.1416);
    }
    public int setSemiAxysX() {
        return semiAxisX;
    }
    public int setSemiAxysY() {
        return semiAxisY;
    }
    public int getSemiAxysX() {
        return semiAxisX;
    }
    public int getSemiAxysY() {
        return semiAxisY;
    }


    // Méthodes

    // Ici, la bounding box est réctangulaire et on utilise comme pour la classe Rectangle ,
    // semiAxisX et semiAxisY comme tailles de ce rectangle.
    // Les signes sont ici aussi la direction.


    public void setBoundingBox(int heightBB, int semiAxisXBB) {
        this.semiAxisX = semiAxisXBB;
        this.semiAxisY = heightBB;
    }

    public void draw(Graphics g) {
        Color c = this.getC();
        int px = this.getP().getX();
        int py = this.getP().getY();
        g.setColor(c);
        if (this.semiAxisX > 0 && this.semiAxisY > 0) { //4 cas encore selon les directions
            g.fillOval(px, py, this.semiAxisX, this.semiAxisY);
        } else if (this.semiAxisX > 0 && this.semiAxisY < 0) {
            g.fillOval(px, py + this.semiAxisY, this.semiAxisX, -this.semiAxisY);
        } else if (this.semiAxisX < 0 && this.semiAxisY > 0) {
            g.fillOval(px + this.semiAxisX, py, -this.semiAxisX, this.semiAxisY);
        } else {
            g.fillOval(px + this.semiAxisX, py + this.semiAxisY, -this.semiAxisX, -this.semiAxisY);
        }
    }

    @Override
    public String toString(){
        return "Ellipse : px="+semiAxisX+" ; py="+semiAxisY+" ; c="+c;
    }
}