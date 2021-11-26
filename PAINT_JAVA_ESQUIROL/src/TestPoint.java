public class TestPoint{
        static public void main(String args[]){
            Point p = new Point();
            p.setX (3);
            p.setY (4);
            System.out.println( p.getX() );
            System.out.println( p.getY() );
            System.out.println("(X;Y)=(" + p.getX() + ";" + p.getY() + ")");
        }
};
