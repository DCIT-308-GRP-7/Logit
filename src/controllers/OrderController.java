package controllers;

import classes.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import main.Main;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class OrderController implements Initializable {
    @FXML
    private TableView<Product> tableView;
    @FXML private TableColumn<Product, String> nameColumn;
    @FXML private TableColumn<Product, Float> priceColumn;

    // text fields in add cat
    @FXML private TextField nameTextField;
    @FXML private TextField quantityTextField;
    @FXML private TextField searchTextField;


    @FXML public static ObservableList<String> categories = FXCollections.observableArrayList(
            "Beverages", "Bread / Bakery", "Canned / Jarred Goods", "Dairy", "Dry / Baking Goods", "Frozen Goods",
            "Meat", "Produce", "Cleaners", "Paper Goods", "Personal Care"
    );

    @FXML public static ObservableList<String> types = FXCollections.observableArrayList("Stacked", "Queued", "List");


    // Categories and Structure
    private Map<String, String> category_ds = new HashMap<String, String>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Product, Float>("cost_price"));

        tableView.setItems(Main.inventory.dsToObservableList());
    }

    public void openVendorsClicked(ActionEvent actionEvent) {
    }

    public void issuedClicked(ActionEvent actionEvent) {
    }

    public void salesBtnClicked(ActionEvent actionEvent) {
    }

    public void searchTextFieldChanged(InputMethodEvent inputMethodEvent) {
        String search = searchTextField.getText();

        ObservableList<Product> prod = Main.inventory.dsToObservableList();

        ObservableList<Product> search_prods = FXCollections.observableArrayList();

        for(int i = 0; i< prod.size(); i++){
            Product p = prod.get(i);
            if (p.name.toString().toLowerCase().contains(search.toLowerCase())){
                search_prods.add(p);
            }
        }

        tableView.setItems(search_prods);
    }

    public void searchTextFieldChanged2(KeyEvent keyEvent) {
        String search = searchTextField.getText();

        ObservableList<Product> prod = Main.inventory.dsToObservableList();

        ObservableList<Product> search_prods = FXCollections.observableArrayList();

        for(int i = 0; i< prod.size(); i++){
            Product p = prod.get(i);
            if (p.name.toString().toLowerCase().contains(search.toLowerCase())){
                search_prods.add(p);
            }
        }

        tableView.setItems(search_prods);
    }
}
