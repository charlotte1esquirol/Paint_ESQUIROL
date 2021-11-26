import java.io.Serializable;


public class Point implements Serializable { //comme indiqué dans le sujet

    public int X;
    public int Y;

    // Setters et getters
    public int getX() {
        return X;
    }
    public int getY() {
        return Y;
    }
    public void setX(int p) {
        X = p;
    }
    public void setY(int q) {
        Y = q;
    }

   // Constructeurs
    public Point(int x, int y) {
        X = x;
        Y = y;
    }

    public Point() {
    }

    @Override  //on redéfinit methode existante pour cet objet la en particulier
    public String toString() {
        return ("(X;Y)=(" + getX() + ";" + getY() + ")");
    }

}