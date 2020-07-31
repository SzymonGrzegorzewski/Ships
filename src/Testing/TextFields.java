package Testing;

import javax.swing.*;

public class TextFields extends JFrame {

    MyPanel myPanel = new MyPanel();
    int theAnswer = myPanel.countOfDiscoveredShips;

    public int returnNOHS() {
        MyPanel myPanel = new MyPanel();
        int NOFS = myPanel.numberOfHiddenShips;
        return NOFS;
    }

    public int getCOAS(int theAnswer) {
        MyPanel myPanel = new MyPanel();
        int COAS = myPanel.numberOfHiddenShips - theAnswer;
        return COAS;
    }
}