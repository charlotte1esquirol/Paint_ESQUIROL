import java.awt.Color;

public class Circle extends Ellipse {

    // Constructeur
    public Circle(int px, int py, Color c){
        super(px, py, c);
    }

    // Getters et setters
    public int setSemiAxysX() {
        return semiAxisX;
    }
    public int setSemiAxysY() {
        return semiAxisY;
    }

    // Méthodes
    // On utilise les mêmes définitions que pour Square et Ellipse pour cette méthode

    public void setBoundingBox(int heightBB, int widthBB) {
        int max = Math.max(heightBB, widthBB);
        int min = Math.min(heightBB, widthBB);
        int signheight = (int) Math.signum(heightBB);
        int signwidth = (int) Math.signum(widthBB);
        if (Math.abs(min) > Math.abs(max)) { //seulement 2 cas aussi
            super.semiAxisX = signwidth*Math.abs(min);
            super.semiAxisY = signheight*Math.abs(min);
        } else {
            super.semiAxisX = signwidth*Math.abs(max);
            super.semiAxisY = signheight*Math.abs(max);
        }
    }
}