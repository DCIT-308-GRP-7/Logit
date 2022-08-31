package classes;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class Product {
    public SimpleIntegerProperty id;
    public SimpleStringProperty name;
    public SimpleIntegerProperty quantity;
    public SimpleFloatProperty cost_price;
    public SimpleFloatProperty selling_price;
    public SimpleFloatProperty gross_price;

    public Product(int id, String name, int quantity, float cost_price, float selling_price, float gross_price) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.cost_price = new SimpleFloatProperty(cost_price);
        this.selling_price = new SimpleFloatProperty(selling_price);
        this.gross_price = new SimpleFloatProperty(gross_price);
    }

    public String getName() {
        return name.get();
    }

    public int getId() {
        return id.get();
    }

    public float getCost_price() {
        return cost_price.get();
    }

    public float getSelling_price() {
        return selling_price.get();
    }

    public float getGross_price() {
        return gross_price.get();
    }

    public int getQuantity() {
        return quantity.get();
    }

    // database
    public static ObservableList<Category> getProducts() {

        // list of categories
        ObservableList<Category> categories = FXCollections.observableArrayList();

        // Get a connection to the database
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dsainventory", "root", "prince");

            // SQL statement
            Statement stmt = con.createStatement();

            // Execute SQL query
            ResultSet rs = stmt.executeQuery("select * from category");


            // process the results
            while (rs.next()) {
                System.out.println("Adding");
                categories.add(new Category(rs.getInt(1), rs.getString(2), rs.getString(3)));
                System.out.println("Added");
            }

            // close mysql db connection
            con.close();

            return categories;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return categories;

        }
    }

    public static int addproduct(String name, String description) {

        // Get a connection to the database
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dsainventory", "root", "prince");

            String sql = "INSERT INTO `category` (`name`, `description`) VALUES (?, ?);";
            // SQL statement
//            Statement stmt = con.createStatement();

            // Execute SQL query
//            ResultSet rs = stmt.executeQuery("INSERT INTO `category` (`name`, `description`) VALUES (?, ?);\n");
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString (1, name);
            preparedStmt.setString (2, description);
            preparedStmt.execute();


            // close mysql db connection
            conn.close();

            return 1;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;

        }
    }

}
