import java.awt.*;

// Cette classe permet de créer un outil gomme

public class Eraser extends Figure{

    // Constructeur
    public Eraser(int px, int py){
        super(Color.WHITE, new Point(px, py));
    }

    protected int width = 30;
    protected int length = 30;

    // Méthodes
    @Override
    public void setBoundingBox(int length, int width) {
    }

    public void draw(Graphics g) {
        int px = this.getP().getX();
        int py = this.getP().getY();
        g.setColor(Color.WHITE);
        g.fillRect(px, py, this.length, this.width); // On choisit comme gomme des rectangles blancs
    }
}