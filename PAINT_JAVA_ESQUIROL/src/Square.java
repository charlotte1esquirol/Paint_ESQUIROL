import java.awt.*;

public class Square extends Rectangle {

    // Constructeur
    public Square(int px, int py, Color c) {
        super(px, py, c);
    }

    // Getters et setters
    public int setLength() {
        return getLength();
    }

    public int setWidth() {
        return getWidth();
    }


    // Méthodes

    // Ici, pour cette méthode, comme notre forme est un carré,
    // on prend le max entre length et width et on crée une bounding box
    // à partir de cela. Les signes permettent de définir la direction

    public void setBoundingBox(int heightBB, int widthBB) {
        int max = Math.max(heightBB, widthBB);
        int min = Math.min(heightBB, widthBB);
        int signheight = (int) Math.signum(heightBB);
        int signwidth = (int) Math.signum(widthBB);
        if (Math.abs(min) > Math.abs(max)) { //seulement 2 cas
            super.width = signwidth*Math.abs(min);
            super.length = signheight*Math.abs(min);
        } else {
            super.width = signwidth*Math.abs(max);
            super.length = signheight*Math.abs(max);
        }
    }
}