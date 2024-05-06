package org.example.icsproject108;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class userController {
    @FXML
    Stage stage ;
    @FXML
    Label userLabel;
    @FXML
    private AnchorPane userScenePane;
    @FXML
    private Button logoutButton;

    public void displayName(String username){
        userLabel.setText("user scene: "+ username);
    }
    public void logout(ActionEvent event){

        stage = (Stage) userScenePane.getScene().getWindow();
        System.out.println("You have succesfully logged out");
        stage.close();
    }
}