package controllers;

import classes.Product;
import classes.Product;
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
import sample.DBTest;


import java.net.URL;
import java.util.ResourceBundle;

public class Goods implements Initializable {
    @FXML private TableView<Product> tableView;
    @FXML private TableColumn<Product, Integer> idColumn;
    @FXML private TableColumn<Product, String> nameColumn;
    @FXML private TableColumn<Product, Integer> quantityColumn;
    @FXML private TableColumn<Product, Float> costPriceColumn;
    @FXML private TableColumn<Product, Float> sellingPriceColumn;
    @FXML private TableColumn<Product, Float> grossPriceColumn;


//    public void loginClicked(ActionEvent actionEvent) throws Exception {
//        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
//
//        Parent root = FXMLLoader.load(getClass().getResource("../fxml/vendors.fxml"));
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("quantity"));
        costPriceColumn.setCellValueFactory(new PropertyValueFactory<Product, Float>("cost_price"));
        sellingPriceColumn.setCellValueFactory(new PropertyValueFactory<Product, Float>("selling_price"));
        grossPriceColumn.setCellValueFactory(new PropertyValueFactory<Product, Float>("gross_price"));

        // load data
        tableView.setItems(DBTest.getGoods());

    }
}