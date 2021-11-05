package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;


public class GUIController implements Initializable {
/*
    @FXML
    CheckBox completeCheckBox;
    @FXML
    Button setDescriptionButton;
    @FXML
    Label dateLabel;
    @FXML
    Button setDateButton;
    @FXML
    Label datePromptLabel;
    @FXML
    TextArea descriptionTextBox;
    @FXML
    DatePicker addDatePicker;
    @FXML
    Button addItemButton;
    @FXML
    TextField titleTextField;
    @FXML
    Button completeButton;
    @FXML
    Label completeLabel;
    @FXML
    ListView<Item> itemList;

    ObservableList<Item> listAll = FXCollections.observableArrayList();
    ObservableList<Item> listComplete = FXCollections.observableArrayList();
    ObservableList<Item> listIncomplete = FXCollections.observableArrayList();

    Item currentItem;

    int numOfItems;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setInvisible();
        numOfItems = 0;

        addDatePicker.setValue(null);

        itemList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            currentItem = itemList.getSelectionModel().getSelectedItem();

            if (currentItem.getItemDate()!=null){
                dateLabel.setText(currentItem.getItemDate().toString());
            }
            else{
                dateLabel.setText( "- -");
            }

            descriptionTextBox.setText(currentItem.getItemDescription());

            if (currentItem.getComplete()) {
                completeLabel.setText("[COMPLETE]");
            } else{
                completeLabel.setText("[INCOMPLETE]");
            }
        });
    }

    @FXML
    public void addItem() throws IOException {
        if(numOfItems<100) {
            listAll.add(new Item(null, titleTextField.getText(), null, false));
            itemList.setItems(listAll);
            numOfItems++;
            refresh();
            setVisible();
        }
        else {
            Parent root1 = FXMLLoader.load(getClass().getClassLoader().getResource("TooManyItemsWarning.fxml"));

            Stage createStage = new Stage();
            createStage.setScene(new Scene(root1));
            createStage.show();
        }
    }

    @FXML
    public void deleteItem() throws IOException {
        if (numOfItems != 0) {
            listAll.remove(itemList.getSelectionModel().getSelectedItem());
            numOfItems--;
        }

        else {
            Parent root1 = FXMLLoader.load(getClass().getClassLoader().getResource("NoItemsWarning.fxml"));

            Stage createStage = new Stage();
            createStage.setScene(new Scene(root1));
            createStage.show();
            setInvisible();
        }

    }

    @FXML
    public void clearItemList(ActionEvent actionEvent) {
        listAll.removeAll(itemList.getItems());
        numOfItems = 0;
        itemList.refresh();
        setInvisible();
    }

    @FXML
    public void setDateButtonPress() {
       LocalDate date = addDatePicker.getValue();
       itemList.getSelectionModel().getSelectedItem().setItemDate(date);
    }

    @FXML
    public void setDescriptionAction() {
        String description = descriptionTextBox.getText();
        itemList.getSelectionModel().getSelectedItem().setItemDescription(description);
    }

    public void setComplete(ActionEvent actionEvent) {

        if (!itemList.getSelectionModel().getSelectedItem().getComplete()) {
            itemList.getSelectionModel().getSelectedItem().setComplete(true);
        }
        else {
            itemList.getSelectionModel().getSelectedItem().setComplete(false);
        }
    }

    @FXML
    public void sortByAll(ActionEvent actionEvent) {

        itemList.setItems(listAll);
    }

    public void sortByComplete(ActionEvent actionEvent) {

        int currentListItemNumber = listAll.size();
        System.out.println(currentListItemNumber);





    }

    public void sortByIncomplete(ActionEvent actionEvent) {


    }



    @FXML
    private void refresh(){
        addDatePicker.setValue(null);
        titleTextField.setText(null);
        itemList.refresh();
    }

    private void setVisible(){
        descriptionTextBox.setVisible(true);
        dateLabel.setVisible(true);
        setDateButton.setVisible(true);
        datePromptLabel.setVisible(true);
        addDatePicker.setVisible(true);
        setDescriptionButton.setVisible(true);
        completeLabel.setVisible(true);
        completeButton.setVisible(true);
    }

    private void setInvisible(){
        descriptionTextBox.setVisible(false);
        dateLabel.setVisible(false);
        setDateButton.setVisible(false);
        datePromptLabel.setVisible(false);
        addDatePicker.setVisible(false);
        setDescriptionButton.setVisible(false);
        completeLabel.setVisible(false);
        completeButton.setVisible(false);
    }

*/
}
