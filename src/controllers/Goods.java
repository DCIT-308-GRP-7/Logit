package controllers;

import classes.Good;
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
    @FXML private TableView<Good> tableView;
    @FXML private TableColumn<Good, Integer> idColumn;
    @FXML private TableColumn<Good, String> nameColumn;
    @FXML private TableColumn<Good, Integer> quantityColumn;
    @FXML private TableColumn<Good, Float> costPriceColumn;
    @FXML private TableColumn<Good, Float> sellingPriceColumn;
    @FXML private TableColumn<Good, Float> grossPriceColumn;


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
        idColumn.setCellValueFactory(new PropertyValueFactory<Good, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Good, String>("name"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Good, Integer>("quantity"));
        costPriceColumn.setCellValueFactory(new PropertyValueFactory<Good, Float>("cost_price"));
        sellingPriceColumn.setCellValueFactory(new PropertyValueFactory<Good, Float>("selling_price"));
        grossPriceColumn.setCellValueFactory(new PropertyValueFactory<Good, Float>("gross_price"));

        // load data
        tableView.setItems(DBTest.getGoods());

    }
}