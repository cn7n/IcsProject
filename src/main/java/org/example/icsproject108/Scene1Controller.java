package org.example.icsproject108;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene1Controller {

    @FXML
    TextField nameTextField;
    @FXML
    PasswordField passwordField;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label AlertLabel;

    public void login(ActionEvent event) throws IOException {
        String username = nameTextField.getText();
        String password = passwordField.getText();

        if ("admin".equals(username)  && "admin".equals(password)) {
            loadAdminScene(event);
        } else if ("user".equals(username) && "user".equals(password)) {
            loadUserScene(event);
        } else {
            AlertLabel.setText("Wrong input" + "\n" + "HINT: USE SMALLER LITTER!");
        }
    }

    private void loadAdminScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("adminscene.fxml"));
        root = loader.load();
        Scene2Controller controller = loader.getController();
        controller.displayName(nameTextField.getText());
        setupScene(event);
    }

    private void loadUserScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserScene.fxml"));
        root = loader.load();
        userController controller = loader.getController();
        controller.displayName(nameTextField.getText());
        setupScene(event);
    }

    private void setupScene(ActionEvent event) {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}