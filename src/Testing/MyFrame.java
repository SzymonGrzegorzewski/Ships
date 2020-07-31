package Testing;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MyFrame extends JFrame {

    MyPanel myPanel = new MyPanel();
    int theAnswer = myPanel.countOfDiscoveredShips;

    public MyFrame() {
        super("StatkiV2");

        TextFields myNewFrame = new TextFields();
        JPanel Table = new MyPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1280, 720));
        setResizable(false);
        setBackground(Color.lightGray);
        add(Table);

        JTextField JTLiczbaUkrytychStatków, JTLiczbaStatkówDoOdkrycia;
        JTLiczbaUkrytychStatków = new JTextField("Liczba ukrytych statków: " + myNewFrame.returnNOHS());
        JTLiczbaUkrytychStatków.setEditable(false);
        JTLiczbaStatkówDoOdkrycia = new JTextField("Liczba statków do odkrycia: " + myNewFrame.getCOAS(theAnswer));
        JTLiczbaStatkówDoOdkrycia.setEditable(false);

        Container mainConteiner = this.getContentPane();
        JPanel prawyPanel = new JPanel();
        prawyPanel.setPreferredSize(new Dimension(250, 720));
        prawyPanel.setBorder(new LineBorder(Color.BLACK, 3));
        prawyPanel.setBackground(Color.GRAY);
        prawyPanel.setLayout(new FlowLayout(FlowLayout.LEFT));// Type of buttons layout
        mainConteiner.add(prawyPanel, BorderLayout.EAST);

        prawyPanel.add(JTLiczbaUkrytychStatków);
        prawyPanel.add(JTLiczbaStatkówDoOdkrycia);

        pack();
        setVisible(true);
    }

}