/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Jonathan O'Leary
 */

package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.collections.transformation.FilteredList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

import java.util.ResourceBundle;

public class GUIController implements Initializable {

    @FXML
    Label itemTitleLabel;
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

    Item currentItem;
    int numOfItems;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setInvisible();
        numOfItems = 0;

        addDatePicker.setValue(null);
        itemList.setItems(listAll);

        itemList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            currentItem = itemList.getSelectionModel().getSelectedItem();

            if (currentItem.getItemDate()!=null){
                dateLabel.setText(currentItem.getItemDate().toString());
            }
            else{
                dateLabel.setText( "- -");
            }

            descriptionTextBox.setText(currentItem.getItemDescription());
            itemTitleLabel.setText(currentItem.getItemTitle());

            if (currentItem.getComplete()) {
                completeLabel.setText("[COMPLETE]");
            } else{
                completeLabel.setText("[INCOMPLETE]");
            }
        });
    }

    @FXML
    public void addItem() {
            listAll.add(new Item(null, titleTextField.getText(), null, false));
            numOfItems++;
            refresh();
            setVisible();
    }


    @FXML
    public void deleteItem() throws IOException {
        if (numOfItems > 0) {
            listAll.remove(itemList.getSelectionModel().getSelectedItem());
            numOfItems--;
        }

        if (numOfItems <= 0) {
            Parent noItemsRoot = FXMLLoader.load(getClass().getClassLoader().getResource("NoItemsWarning.fxml"));

            Stage createStage = new Stage();
            createStage.setScene(new Scene(noItemsRoot));
            createStage.show();
            setInvisible();
        }

    }

    @FXML
    public void clearItemList() {
        listAll.removeAll(itemList.getItems());
        numOfItems = 0;
        itemList.refresh();
        setInvisible();
    }

    @FXML
    public void setDateButtonPress() {
       LocalDate date = addDatePicker.getValue();
       itemList.getSelectionModel().getSelectedItem().setItemDate(date);
       dateLabel.setText(date.toString());
    }

    @FXML
    public void setDescriptionAction() throws IOException {
        String description = descriptionTextBox.getText();
        if (description.length()<256) {
            itemList.getSelectionModel().getSelectedItem().setItemDescription(description);
            descriptionTextBox.setText(description);
        }
        else {
            Parent root1 = FXMLLoader.load(getClass().getClassLoader().getResource("DescriptionTooLong.fxml"));

            Stage createStage = new Stage();
            createStage.setScene(new Scene(root1));
            createStage.show();
        }
    }

    public void setComplete() {

        itemList.getSelectionModel().getSelectedItem().setComplete(!itemList.getSelectionModel().getSelectedItem().getComplete());
        if (currentItem.getComplete()) {
            completeLabel.setText("[COMPLETE]");
        } else{
            completeLabel.setText("[INCOMPLETE]");
        }
    }

    @FXML
    public void sortByAll() {
        System.out.println("Sorting by All");

        itemList.setItems(listAll);
    }

    @FXML
    public void sortByComplete() {
        System.out.println("Sorting by complete");

        FilteredList<Item> listComplete = new FilteredList<>(listAll, Item::getComplete);
        itemList.setItems(listComplete);
    }

    @FXML
    public void sortByIncomplete() {
        System.out.println("Sorting by incomplete");

        FilteredList<Item> listIncomplete = new FilteredList<>(listAll, item -> !item.getComplete());
        itemList.setItems(listIncomplete);
    }


    public void saveItemsAll(){
        System.out.println("Saving All Items");

        JFrame parent = new JFrame();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");

        int userSelection = fileChooser.showSaveDialog(parent);

        if (userSelection == JFileChooser.APPROVE_OPTION){
            try {
                FileWriter fw = new FileWriter((fileChooser.getSelectedFile()+".txt"));
                fw.write(String.valueOf(listAll));
                fw.close();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    public void userGuideOpen() {
        JFrame helpFrame = new JFrame();
        ImageIcon icon =new ImageIcon(getClass().getClassLoader().getResource("HelpScreenPicture.PNG"));

        JLabel label = new JLabel(icon);
        helpFrame.add(label);
        helpFrame.pack();
        helpFrame.setVisible(true);
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
        itemTitleLabel.setVisible(true);
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
        itemTitleLabel.setVisible(false);
    }


}
