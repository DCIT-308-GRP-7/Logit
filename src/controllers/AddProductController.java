package controllers;

import classes.Product;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import main.Main;

public class AddProductController {

    // text fields in add cat
    @FXML
    private TextField nameTextField;
    @FXML private TextField quantityTextField;
    @FXML private TextField costTextField;
    @FXML private TextField categoryTextField;
    @FXML private TextField sellingTextField;


    public void addBtn_Clicked(ActionEvent actionEvent) {
        String name = nameTextField.getText();
        int quantity = Integer.parseInt(quantityTextField.getText());
        int category = Integer.parseInt(categoryTextField.getText());
        float cost = Float.parseFloat(costTextField.getText());
        float selling = Float.parseFloat(sellingTextField.getText());

        // get the max id
        ObservableList<Product> prod = Main.inventory.dsToObservableList(0);
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
}
