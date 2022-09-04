package controllers;

import classes.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.Main;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class IssuedGoodsController implements Initializable {
    @FXML
    private TableView<Product> tableView;
    @FXML private TableColumn<Product, Integer> idColumn;
    @FXML private TableColumn<Product, String> nameColumn;
    @FXML private TableColumn<Product, Integer> quantityColumn;
    @FXML private TableColumn<Product, Float> costPriceColumn;
    @FXML private TableColumn<Product, Float> sellingPriceColumn;
    @FXML private TableColumn<Product, Float> grossPriceColumn;

    // text fields in add cat
    @FXML private TextField nameTextField;
    @FXML private TextField quantityTextField;
    @FXML private TextField costTextField;
    @FXML private TextField categoryTextField;
    @FXML private TextField sellingTextField;


    // combobox
    @FXML private ComboBox<String> comboBox;
    @FXML private ComboBox<String> comboBoxType;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("quantity"));
        costPriceColumn.setCellValueFactory(new PropertyValueFactory<Product, Float>("cost_price"));
        sellingPriceColumn.setCellValueFactory(new PropertyValueFactory<Product, Float>("selling_price"));
        grossPriceColumn.setCellValueFactory(new PropertyValueFactory<Product, Float>("gross_price"));


        ObservableList<Product> issued_prod = FXCollections.observableArrayList();

        // Using Iterators
        ArrayList<Product> issued_products = Product.getIssuedProducts();
        Iterator<Product> iter= issued_products.iterator();
        while (iter.hasNext()) {
            issued_prod.add(iter.next());
        }

        tableView.setItems(issued_prod);
    }

    public void addProduct(MouseEvent actionEvent) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("../fxml/addproduct.fxml"));
            Stage stage = new Stage();
            stage.setTitle("My New Stage Title");
            stage.setScene(new Scene(root));
            stage.showAndWait();

            // refresh table
            String selected = comboBoxType.getValue();
            if (comboBoxType.getValue() != null){
                selected = comboBoxType.getValue();
                tableView.setItems(Main.inventory.dsToObservableList(selected));
            } else {
                tableView.setItems(Main.inventory.dsToObservableList(0));
            }
            // Hide this current window (if this is what you want)
//            ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openVendorsClicked(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/vendors.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void comboBoxTypeChanged(ActionEvent actionEvent) {
        // selected category
        String selected = comboBoxType.getValue();

        // clear combobox
        comboBox.valueProperty().set(null);

        ObservableList<Product> products = Main.inventory.dsToObservableList(selected);
        tableView.setItems(products);
    }

    public void salesBtnClicked(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/sales.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void productsClicked(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/products.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
