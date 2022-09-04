package classes;

import main.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static controllers.ProductController.categories;

public class Sale {
    public int id;
    public String product_code;

    public Sale(int sale_id, String product_code) {
        this.id = sale_id;
        this.product_code = product_code;
    }

    public int getId() {
        return id;
    }

    public String getProduct_code() {
        return product_code;
    }

    public static int getSales() {

        try {
            // Get a connection to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dsainventory", "root", "prince");

            // SQL statement
            Statement stmt=con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from sale;");

            // process the results
            while(rs.next()) {
                // update Maps data structure
                Main.inventory.productSales.put(rs.getInt(1), rs.getString(2));
            }

            // close mysql db connection
            con.close();

            return 1;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }


    }
}
