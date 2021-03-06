import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class Drawing extends JPanel implements MouseListener, MouseMotionListener {
    public Color c;
    public ArrayList<Figure> list = new ArrayList<>();
    public String nameFigure;
    public int x;
    public int y;
    public boolean saveCanceled = false;

    // Setters et Getters
    public void setColor(Color c) {
        this.c = c;
    }
    public Color getColor() {
        return c;
    }
    public void setNameFigure(String nameFigure) {
        this.nameFigure = nameFigure;
    }

    // Constructeur
    public Drawing() {
        this.setBackground(Color.white);
        this.x = 0;
        this.y = 0;
        list.add(new Rectangle(0, 0, Color.BLACK)); // Pour que la figure de base
        // soit un réctangle noir si rien n'est selectionné
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }


    //Méthodes
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    // Dès que la souris est cliquée, on veut une nouvelle forme
    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();

        switch (nameFigure) {
            case "Ellipse":
                list.add(new Ellipse(x, y, c));
                break;
            case "Circle":
                list.add(new Circle(x, y, c));
                break;
            case "Rectangle":
                list.add(new Rectangle(x, y, c));
                break;
            case "Square":
                list.add(new Square(x, y, c));
                break;
            case "Eraser":
                list.add(new Eraser(x, y));
                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }


    // On veut que la taille de la bounding box soit modifiée en suivant la souris
    // mouseDragged permet cela, elle modifie la bounding box suivant la position de la souris et le point d'origine
    // mouseDragged permet pour la gomme de créer des carrés blanc pour simuler une gomme
    @Override
    public void mouseDragged(MouseEvent e) {
        if (nameFigure == "Eraser") {
            list.add(new Eraser(e.getX(), e.getY()));
            this.repaint();
        }
        else {
            ((Figure) this.list.get(this.list.size() - 1)).setBoundingBox(e.getY() - this.y, e.getX() - this.x);
            this.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }


    // paintComponent regarde tous les objets dans le tableau pour appeler la bonne méthode

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.white);
        Iterator nameFigure = this.list.iterator();

        while (nameFigure.hasNext()) {
            Figure f = (Figure) nameFigure.next();
            f.draw(g);
        }
    }


    //Méthodes save, open et new du menu "file"

    public void save() {
        JFileChooser fileChooser = new JFileChooser();
        JOptionPane info = new JOptionPane();
        info.showInternalMessageDialog( info, "Please save only in the Project Directory",
                "Warning",JOptionPane.INFORMATION_MESSAGE);
        int rVal = fileChooser.showOpenDialog(this);
        if (rVal == 0) {
            try {
                FileOutputStream fos = new FileOutputStream(fileChooser.getSelectedFile().getPath());
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeInt(this.list.size());
                Iterator v = this.list.iterator();

                while(v.hasNext()) {
                    Figure f = (Figure)v.next();
                    oos.writeObject(f);
                }

                oos.close();
            } catch (Exception e) {
                System.out.println("Drawing could not be saved");
            }

            this.saveCanceled = false;
        } else if (rVal == 1) {
            this.saveCanceled = true;
        }

    }


    public void open() {
        JFileChooser fileChooser = new JFileChooser();
        int vop = fileChooser.showOpenDialog(this);
        if (vop == JFileChooser.APPROVE_OPTION) {
            try {
                FileInputStream fis = new FileInputStream(fileChooser.getSelectedFile().getName());
                ObjectInputStream ois = new ObjectInputStream(fis);
                int size = ois.readInt();

                for(int i = 0; i < size; ++i) {
                    list.add((Figure)ois.readObject());
                }

                ois.close();
                repaint();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("File could not be opened");
            }
        }

    }


    public void New() {
        int result = JOptionPane.showConfirmDialog(this, "Do you want to save the modifications ?", "Save ?", 0, 3);
        if (result == 0) {
            this.save();
            if (!this.saveCanceled) {
                this.list = new ArrayList();
                this.repaint();
            }
        } else if (result == 1) {
            this.list = new ArrayList();
            this.repaint();
        }

    }

}
