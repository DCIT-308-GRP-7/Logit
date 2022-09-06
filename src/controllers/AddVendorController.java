package controllers;

import classes.Product;
import classes.Vendor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import main.Main;

public class AddVendorController {

    // text fields in add cat
    @FXML
    private TextField nameTextField;
    @FXML private TextField quantityTextField;
    @FXML private TextField costTextField;
    @FXML private TextField categoryTextField;
    @FXML private TextField sellingTextField;

    @FXML public static ObservableList<String> categories = FXCollections.observableArrayList(
            "Beverages", "Bread / Bakery", "Canned / Jarred Goods", "Dairy", "Dry / Baking Goods", "Frozen Goods",
            "Meat", "Produce", "Cleaners", "Paper Goods", "Personal Care"
    );


    public void addBtn_Clicked(ActionEvent actionEvent) {
        String name = nameTextField.getText();
        int category = Integer.parseInt(categoryTextField.getText());

        // get category string
        String cat = categories.get(category - 1);

        // create new vendor object
        Vendor new_vendor = new Vendor(name, cat);


        // adds to the database and to the appropriate data structure
        Main.inventory.addVendor(new_vendor);

        // close window
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();

    }
}
