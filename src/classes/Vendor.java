package classes;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.HashMap;

import static controllers.ProductController.categories;

public class Vendor {
    private SimpleStringProperty name;
    private SimpleStringProperty category;


    public Vendor(String name, String category) {
        this.name = new SimpleStringProperty(name);
        this.category = new SimpleStringProperty(category);

    }

    public String getName() {
        return name.get();
    }

    public String getCategory() {
        return category.get();
    }

    // database
    public static HashMap<String, String> getVendors() {

        // list of goods from db
        HashMap<String, String> vendors = new HashMap<String, String>();

        try {
            // Get a connection to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dsainventory", "root", "prince");

            // SQL statement
            Statement stmt=con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from vendors;");

            // process the results
            while(rs.next()) {
                int cat_ind = rs.getInt(3);
                System.out.println("=====================================================================");
                String category = categories.get(cat_ind);
                vendors.put(rs.getString(2), category);
            }

            // close mysql db connection
            con.close();

            return vendors;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return vendors;
        }


    }

}
