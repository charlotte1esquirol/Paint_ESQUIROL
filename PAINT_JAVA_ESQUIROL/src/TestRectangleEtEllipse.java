import java.awt.*;

public class TestRectangleEtEllipse {
    static public void main(String args[]){
        Rectangle r = new Rectangle(3,4, Color.green);

        System.out.println( r.getSurface() );
        System.out.println( r.getPerimeter() );

        Ellipse e = new Ellipse(3,4,Color.red);

        System.out.println( e.getSurface() );
        System.out.println( e.getPerimeter() );


    }
}
