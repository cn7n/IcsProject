package org.example.secondscene;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Scene2Controller {

    @FXML
    private Label welcomeLabel,notificationButton;
    @FXML
    private Button logoutButton,addEventButton, showEventsButton, editEventButton;
    @FXML
    private ListView<String> listView;  //we need to make the capacity field as a String
    @FXML
    private TextField titleField, categoryField, descriptionField, dateField, timeField, locationField, capacityField;
    private String title , category , description , date , time , location , capacity;
    private ObservableList<String> events = FXCollections.observableArrayList(); //it notifies when any changes happen such as delete or add (this is the difference between observable and arrayList
    private String eventDetails;

    @FXML
    public void initialize() {
        listView.setItems(events);  // adding the observable to the listView in the scene builder
    }
    public void displayName(String username){
        welcomeLabel.setText("Admin Dashboard: "+ username);

    }
    @FXML
    private void handleAddEvent(ActionEvent event) {
        title = titleField.getText();
        category = categoryField.getText();
        description = descriptionField.getText();
        date = dateField.getText();
        time = timeField.getText();
        location = locationField.getText();
        capacity = capacityField.getText();
        //we use .isEmpty() only for strings so use it for title category etc.

        if(title.isEmpty() || category.isEmpty() || description.isEmpty() || date.isEmpty() || time.isEmpty() || location.isEmpty() || location.isEmpty() || capacity.isEmpty()){
            notificationButton.setText("Please fill all fields to add an event.");
        }
            else {
            // Creating a formatted string for each event

            eventDetails = String.format("Title: %s\nCategory: %s\nDescription: %s\nDate: %s\nTime: %s\nLocation: %s\nCapacity: %s\n- - - - - ", title, category, description, date, time, location, capacity);
            events.add(eventDetails);  // Adding the formatted event string to the ObservableList
            clearAllFields();  // Clear input fields after adding the event
        }
    }

    @FXML
    private void handleDeleteEvent(ActionEvent event) {
        String selectedEvent = listView.getSelectionModel().getSelectedItem();
        if (selectedEvent!= null){
            events.remove(selectedEvent);
        }
        else {
            notificationButton.setText("Please chose an event to delete.");
        }

    }
    @FXML
    private void handleEditEvent(ActionEvent event) {
        String selectedItem = listView.getSelectionModel().getSelectedItem();
    }

    //method we use it when we add event to clear all fields
    private void clearAllFields() {
        titleField.clear();
        categoryField.clear();
        descriptionField.clear();
        dateField.clear();
        timeField.clear();
        locationField.clear();
        capacityField.clear();
    }

    @FXML
    private void logout(ActionEvent event){
        System.exit(0);
    }
}
