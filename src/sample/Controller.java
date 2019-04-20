package sample;

import DataStructures.LinkedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    Boolean FirstPalyer = true;//
    LinkedList Board = new LinkedList();
    @FXML
    public void BoardBtnAction(ActionEvent e)
    {
        Button btn = (Button)e.getSource();
        int NodeNumber = Integer.valueOf(btn.getText().substring(3));
        if(FirstPalyer) {
            Board.PlayerTurn("X", NodeNumber);
            btn.setText("X");
            FirstPalyer = !FirstPalyer;
        }
        else {
            Board.PlayerTurn("O", NodeNumber);
            btn.setText("O");
            FirstPalyer = !FirstPalyer;
        }


    }

}
