import java.awt.*;

public class TestSquareetCircle {
    static public void main(String args[]){
        Square s = new Square(3,3, Color.green);

        System.out.println( s.getSurface() );
        System.out.println( s.getPerimeter() );

        Circle ci = new Circle(3,3,Color.red);

        System.out.println( ci.getSurface() );
        System.out.println( ci.getPerimeter() );


    }
}
