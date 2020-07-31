package Testing;

import javax.swing.*;

public class StartPanel extends JPanel {
    private JTextField boardScale;
    private JTextField amountOfShips;
    private JButton loginButton;
    //private LoginListener listener;

    public String getBoardScale(){
        return boardScale.getText();
    }
    public String getAmountOfShips(){
        return amountOfShips.getText();
    }
  //  public StartPanel(LoginListener listener){
        
   // }

}
