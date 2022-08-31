package sample;

import classes.Category;
import classes.Product;
import classes.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.List;

public class DBTest {

    public static void main(String[] args) {
        ObservableList<Product> goods = FXCollections.observableArrayList();

        System.out.println("Adding");
        goods.add(new Product(2, "Prince", 23, 4.5f, (float) 5.6, 123));
        System.out.println(goods.toString());

        System.out.println("Added");

        int response  = Category.addCategory("Something", "else");
        System.out.println(response);
//        try {
//            // Get a connection to the database
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dsainventory", "root", "prince");
//
//            // SQL statement
//            Statement stmt=con.createStatement();
//
//            // Execute SQL query
//            ResultSet rs=stmt.executeQuery("select * from good");
//
//            //
//            List<Good> goods = null;
//
//            // process the results
//            while(rs.next())
//                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3) +"  "+rs.getString(4) +"  "+rs.getString(6));
//                goods.add(new Good(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getFloat(4), rs.getFloat(5), rs.getFloat(6)));
//            // close mysql db connection
//            con.close();
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }

    public static ObservableList<Product> getGoods(){

        // list of goods from db
        ObservableList<Product> products = FXCollections.observableArrayList();
        try {
            // Get a connection to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dsainventory", "root", "prince");

            // SQL statement
            Statement stmt=con.createStatement();

            // Execute SQL query
            ResultSet rs=stmt.executeQuery("select * from product");



            // process the results
            while(rs.next()) {
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3) +"  "+rs.getString(4) +"  "+rs.getString(6));

                System.out.println("Adding");
                products.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getFloat(4), rs.getFloat(5), rs.getFloat(6)));
                System.out.println("Added");
            }

            // close mysql db connection
            con.close();

            return products;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return products;
        }
    }
}
