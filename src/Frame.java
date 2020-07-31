import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Frame extends JFrame {




    public Frame() {
        super("StatkiV2");
        setPreferredSize(new Dimension(1280, 720));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       // JButton button1 = new JButton("Button1");
       // JButton button2 = new JButton("Button2");
       // JButton button3 = new JButton("Button3")
       // JButton button4 = new JButton("Button4");
       // JButton button5 = new JButton("Button5");
       // JButton button6 = new JButton("Button6");
       // JButton button7 = new JButton("Button7");
       // JButton button8 = new JButton("Button8");

        Container mainConteiner = this.getContentPane();
        mainConteiner.setLayout(new BorderLayout(8, 6));// Główne odstępy pomiędzy (kontenerami?)
        mainConteiner.setBackground(Color.GRAY);// Ustawiamy główne tło na szare
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK)); // Tworzy czarny pierścień na obrzeżach

        /*Tworzymy górny panel*/
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(1280,40));
        topPanel.add(Box.createHorizontalStrut(53),BorderLayout.NORTH);
        topPanel.setBorder(new LineBorder(Color.BLACK, 3)); //Czarny pierścień wokoło kontenera
        topPanel.setBackground(Color.cyan); // Tło górnego kontenera
        topPanel.setLayout(new FlowLayout(0));// Typ rozkładu przycisków

        /*Przypisujemy przyciski do górnego panelu*/
        for (int i = 1; i <=8 ; i++) {
            topPanel.add(new JButton(""+i));

        }

        mainConteiner.add(topPanel, BorderLayout.NORTH); /*Dodajemy do kontenera górny panel oraz
                                                           ustawiamy jego pozycję w oknie         */
        /*Tworzymy środkowy panel*/
        JPanel middlePanel = new JPanel();
        middlePanel.setBorder(new LineBorder(Color.BLACK, 1)); //Ustawiamy czarny pierścień wokoło środkowego panelu
        middlePanel.setLayout(new FlowLayout(4, 4, 4)); //Ustawiamy odległości na środkowego panelu
        middlePanel.setBackground(Color.RED);//tło środkowego panelu

        /*Tworzymy panel w środkowym panelu*/
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(0, 1, 5, 5));//Ustawiamy w nim odległości
        gridPanel.setBorder(new LineBorder(Color.BLACK, 3)); // Tworzymy czarny pierścień wokoło danego panelu
        gridPanel.setBackground(Color.BLUE); // Ustawiamy tło panelu
        for( char C = 'A'; C <= 'K'; C++ ) {
            gridPanel.add(new JButton(""+C));

        }


        JLabel label = new JLabel("Center Box", SwingConstants.CENTER);// Torzymy center box w centrum
        label.setOpaque(true);
        label.setBorder(new LineBorder(Color.BLACK, 3));// Tworzymy czarny pierścień


        middlePanel.add(gridPanel);
        mainConteiner.add(label);
        mainConteiner.add(middlePanel, BorderLayout.WEST);// przypisujemy środkowy panel do lewej strony

        pack();
        setVisible(true);
    }
}
