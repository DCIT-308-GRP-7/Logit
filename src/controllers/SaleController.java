package controllers;

import classes.Sale;
import classes.Vendor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.Main;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class SaleController implements Initializable {
    @FXML
    private TableView<Sale> tableView;
    @FXML private TableColumn<Sale, Integer> idColumn;
    @FXML private TableColumn<Sale, String> codeColumn;

    // db call for sales
    int response = Sale.getSales();

    // Map data structure for vendor information
    Map<Integer, String> sales = Main.inventory.productSales;

    // List of vendors
    ObservableList<Sale> sales_list = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        idColumn.setCellValueFactory(new PropertyValueFactory<Sale, Integer>("id"));
        codeColumn.setCellValueFactory(new PropertyValueFactory<Sale, String>("product_code"));

        // load data from vendor hashmaps to an arraylist
        for (int i = 0; i < sales.size(); i++){
            int id = Integer.parseInt(sales.keySet().toArray()[i].toString());
            String product_code = sales.get(id);

            sales_list.add(new Sale(id, product_code));
        }

        tableView.setItems(sales_list);

    }

    public void openProductClicked(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/products.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void openVendorsClicked(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/vendors.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void issuedClick(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/issuedproducts.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
