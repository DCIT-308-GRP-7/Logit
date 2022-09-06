package controllers;

import classes.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import main.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class AddProductController implements Initializable {

    // text fields in add cat
    @FXML
    private TextField nameTextField;
    @FXML private TextField quantityTextField;
    @FXML private TextField costTextField;
    @FXML private ComboBox<String> categoryComboField;
    @FXML private TextField sellingTextField;

    @FXML public static ObservableList<String> categories = FXCollections.observableArrayList(
            "Beverages", "Bread / Bakery", "Canned / Jarred Goods", "Dairy", "Dry / Baking Goods", "Frozen Goods",
            "Meat", "Produce", "Cleaners", "Paper Goods", "Personal Care"
    );


    public void addBtn_Clicked(ActionEvent actionEvent) {
        String name = nameTextField.getText();
        int quantity = Integer.parseInt(quantityTextField.getText());
        String cat = categoryComboField.getValue();
        float cost = Float.parseFloat(costTextField.getText());
        float selling = Float.parseFloat(sellingTextField.getText());

        int category = categories.indexOf(cat) + 1;

        // get the max id
        ObservableList<Product> prod = Main.inventory.dsToObservableList();
        Integer max_id = prod.get(0).id.getValue();
        for (int i = 0; i < prod.size(); i++) {
            int id = prod.get(i).id.getValue();
            if (max_id < id){
                max_id = id;
            }
        }

        // add to data structure
        Main.inventory.addProduct(new Product(max_id+1, name, quantity, cost, selling, cost*quantity, category));

        // adds to the database and to the appropriate data structure
        int add_response = Product.addProduct(name, quantity, cost, selling, category);
        System.out.println(add_response);

        // close window
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        categoryComboField.setItems(categories);
    }
}
