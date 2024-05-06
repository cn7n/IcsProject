package org.example.icsproject108;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Scene2Controller {

    @FXML
    Label welcomeLabel;
    @FXML
    private Button logoutButton ;
    @FXML
    private AnchorPane scenePane;

    Stage stage ;

    public void displayName(String username){
        welcomeLabel.setText("hello mr."+ username);
    }
    public void logout(ActionEvent event){

        stage = (Stage) scenePane.getScene().getWindow();
        System.out.println("You have succesfully logged out");
        stage.close();
    }
}