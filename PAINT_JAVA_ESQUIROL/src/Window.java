import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Window extends JFrame implements ActionListener {

    Drawing draw = new Drawing();

    //Constructeur
    public Window(String Title, int x, int y) {

        super(Title);
        this.setSize(x,y);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPanel = this.getContentPane();
        Container contentPanel2 = this.getContentPane();

        JMenuBar m= new JMenuBar();

        JMenu menu1 = new JMenu("File"); //Creation du menu fichier

        //Creation des items de ce menu
        JMenuItem New = new JMenuItem("New");
        New.addActionListener(this);

        JMenuItem Open = new JMenuItem("Open");
        Open.addActionListener(this);

        JMenuItem Save = new JMenuItem("Save");
        Save.addActionListener(this);
        Save.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));

        JMenuItem Quit = new JMenuItem("Quit");
        Quit.addActionListener(this);


        // Ajout de ces items au menu fichier
        menu1.add(New);
        menu1.add(Open);
        menu1.add(Save);
        menu1.add(Quit);
        menu1.insertSeparator(3); //Permet de séparer l'option quitter des 3 autres items

        // Ajout du menu fichier au menu principal
        m.add(menu1);

        // Création du menu A propos
        JMenu menu2 = new JMenu("À propos");

        // Ajout des items

        JMenuItem creditMenuItem = new JMenuItem("Crédits");
        creditMenuItem.addActionListener(this);

        menu2.add(creditMenuItem);

        // Ajout du menu A propos au menu principal
        m.add(menu2);


        // Message d'accueil
        JOptionPane info = new JOptionPane();
        info.showInternalMessageDialog( info, "Pour commencer, cliquez sur Ok",
                "Pop-Up",JOptionPane.INFORMATION_MESSAGE);


       // Création des boutons

        JPanel SouthPanel = new JPanel();
        SouthPanel.setLayout(new GridLayout(2,6));

        // Boutons couleurs
        JButton black = new JButton("Black");
        black.setBackground(Color.black);
        black.addActionListener(this);
        black.setOpaque(true); // pour mac car sinon ca n'affiche pas en couleur
        black.setBorderPainted(false);
        black.setForeground(Color.white); // pour que le mot noir soit écrit en blanc

        JButton red = new JButton("Red");
        red.setBackground(Color.red);
        red.addActionListener(this);
        red.setOpaque(true);
        red.setBorderPainted(false);

        JButton green = new JButton("Green");
        green.setBackground(Color.green);
        green.addActionListener(this);
        green.setOpaque(true);
        green.setBorderPainted(false);

        JButton blue = new JButton("Blue");
        blue.setBackground(Color.blue);
        blue.addActionListener(this);
        blue.setOpaque(true);
        blue.setBorderPainted(false);

        JButton yellow = new JButton("Yellow");
        yellow.setBackground(Color.yellow);
        yellow.addActionListener(this);
        yellow.setOpaque(true);
        yellow.setBorderPainted(false);

        JButton pink = new JButton("Pink");
        pink.setBackground(Color.pink);
        pink.addActionListener(this);
        pink.setOpaque(true);
        pink.setBorderPainted(false);

        JButton magenta = new JButton("Magenta");
        magenta.setBackground(Color.magenta);
        magenta.addActionListener(this);
        magenta.setOpaque(true);
        magenta.setBorderPainted(false);

        JButton orange = new JButton("Orange");
        orange.setBackground(Color.orange);
        orange.addActionListener(this);
        orange.setOpaque(true);
        orange.setBorderPainted(false);


        // Boutons outils
        JButton Ellipse = new JButton("Ellipse");
        Ellipse.addActionListener(this);

        JButton Circle = new JButton("Circle");
        Circle.addActionListener(this);

        JButton Rectangle = new JButton("Rectangle");
        Rectangle.addActionListener(this);

        JButton Square = new JButton("Square");
        Square.addActionListener(this);

        // Ajout des boutons au panneau

        SouthPanel.add(black);
        SouthPanel.add(red);
        SouthPanel.add(green);
        SouthPanel.add(blue);
        SouthPanel.add(Rectangle); // par soucis d'affichage on ne met pas tous les boutons couleurs à la suite
        SouthPanel.add(Ellipse);
        SouthPanel.add(yellow);
        SouthPanel.add(pink);
        SouthPanel.add(magenta);
        SouthPanel.add(orange);
        SouthPanel.add(Square);
        SouthPanel.add(Circle);



        // Création d'un outil gomme
        JPanel NorthPanel = new JPanel();
        NorthPanel.setLayout(new GridLayout(1, 4));
        JButton Eraser = new JButton("Eraser");
        Eraser.addActionListener(this);
        NorthPanel.add(Eraser);

        // Pour que le dessin puisse être au centre
        contentPanel.add(draw,"Center");


        //Ajout des panneaux et affichage
        contentPanel.add(SouthPanel, "South");
        contentPanel2.add(NorthPanel, "North");

        setJMenuBar(m);
        SouthPanel.setVisible(true);
        NorthPanel.setVisible(true);
        this.setVisible(true);
    }

    // Implementation ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        switch (cmd) {
            case "Black":
                System.out.println("You've been clicked on black!");
                draw.setColor(Color.black);
                break;

            case "Red":
                System.out.println("You've been clicked on red!");
                draw.setColor(Color.red);
                break;

            case "Green":
                System.out.println("You've been clicked on green!");
                draw.setColor(Color.green);
                break;

            case "Blue":
                System.out.println("You've been clicked on blue!");
                draw.setColor(Color.blue);
                break;

            case "Yellow":
                System.out.println("You've been clicked on yellow!");
                draw.setColor(Color.yellow);
                break;

            case "Pink":
                System.out.println("You've been clicked on pink!");
                draw.setColor(Color.pink);
                break;

            case "Magenta":
                System.out.println("You've been clicked on magenta!");
                draw.setColor(Color.magenta);
                break;

            case "Orange":
                System.out.println("You've been clicked on orange!");
                draw.setColor(Color.orange);
                break;

            case "Ellipse":
                System.out.println("You've been clicked on Ellipse!");
                draw.setNameFigure("Ellipse");
                break;

            case "Circle":
                System.out.println("You've been clicked on Circle!");
                draw.setNameFigure("Circle");
                break;

            case "Square":
                System.out.println("You've been clicked on Square!");
                draw.setNameFigure("Square");
                break;

            case "Rectangle":
                System.out.println("You've been clicked on Rectangle!");
                draw.setNameFigure("Rectangle");
                break;

            case "Eraser":
                System.out.println("You've been clicked on Eraser!");
                draw.setNameFigure("Eraser");
                break;

            case "New":
                this.draw.New();
                break;

            case "Open":
                this.draw.open();
                break;

            case "Save":
                this.draw.save();
                break;

            case "Quit":
                this.dispose();
                break;

            case "Crédits":
                JOptionPane info = new JOptionPane();
                info.showInternalMessageDialog( info, "Authors : ESQUIROL Charlotte",
                        "information",JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }



}