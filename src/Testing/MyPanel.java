package Testing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class MyPanel extends JPanel implements MouseListener {
    int fieldSize = 6;
    int numberOfHiddenShips = 35;
    int countOfDiscoveredShips = 0;
    private BufferedImage image;
    int[][] positionOfShipXY = new int[fieldSize][fieldSize];


    public MyPanel() {
        addMouseListener(this);

        File imageFile = new File("C:\\Users\\grzeg\\IdeaProjects\\StatkiV2\\Ship.png");
        try {
            image = ImageIO.read(imageFile);
        } catch (IOException e) {
            System.err.println("Błąd odczytu obrazu");
            e.printStackTrace();
        }


        /*Drawing coordinates of ships*/
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < fieldSize * fieldSize; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        for (int i = 0; i < numberOfHiddenShips; i++) {
            int x = list.get(i) / fieldSize;
            int y = list.get(i) % fieldSize;
            positionOfShipXY[x][y] = 5;
        }

    }

    boolean mouseAvailable = false;

    @Override public void mouseClicked(MouseEvent e) { }
    @Override public void mousePressed(MouseEvent e) { }
    @Override public void mouseEntered(MouseEvent e) { mouseAvailable = true; }
    @Override public void mouseExited(MouseEvent e) { mouseAvailable = false; }

    ArrayList points = new ArrayList();
    int coordinatesX, coordinatesY;

    @Override
    public void mouseReleased(MouseEvent e) {
        coordinatesX = e.getX();
        coordinatesY = e.getY();
        points.add(new Point(coordinatesX, coordinatesY));
        repaint();

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int reactSizeX = 50;
        int reactSizeY = 50;
        int lineNumber;
        int columnNumber;
        /*Drawing the board*/
        for (int j = 0; j < fieldSize * fieldSize; j = j + fieldSize) {
            lineNumber = j / fieldSize;
            for (int i = 0; i < fieldSize; i++) {
                columnNumber = i;
                g2d.drawRect(reactSizeX * columnNumber, reactSizeY * lineNumber, reactSizeX, reactSizeY);
            }
        }

        if (mouseAvailable && coordinatesX < (fieldSize*reactSizeX) && coordinatesY < (fieldSize*reactSizeY)) {
            int reactNumberAxisX;
            int reactNumberAxisY;
            reactNumberAxisX = coordinatesX / 50;
            reactNumberAxisY = coordinatesY / 50;
            if (positionOfShipXY[reactNumberAxisX][reactNumberAxisY] == 5) {
                g2d.setColor(Color.RED);
                countOfDiscoveredShips++;
                new TextFields().getCOAS(countOfDiscoveredShips);
                new TextFields().returnNOHS();
                g2d.drawImage(image, (reactNumberAxisX * reactSizeX) + 5, (reactNumberAxisY * reactSizeY) + 5, 40, 40, this);
                g2d.drawLine((reactNumberAxisX * reactSizeX), (reactNumberAxisY * reactSizeY), (reactNumberAxisX * reactSizeX) + 50, (reactNumberAxisY * reactSizeY) + 50);
                g2d.drawLine((reactNumberAxisX * reactSizeX) + 50, (reactNumberAxisY * reactSizeY), (reactNumberAxisX * reactSizeX), (reactNumberAxisY * reactSizeY + 50));
            } else {
                g2d.setColor(Color.DARK_GRAY);
                g2d.fillOval((reactNumberAxisX * reactSizeX) + 5, (reactNumberAxisY * reactSizeY) + 5, 40, 40);
                g2d.setColor(Color.WHITE);
                g2d.fillOval((reactNumberAxisX * reactSizeX) + 10, (reactNumberAxisY * reactSizeY) + 10, 30, 30);
            }
        }
    }
}