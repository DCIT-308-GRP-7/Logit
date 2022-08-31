package sample;

import classes.Good;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.List;

public class DBTest {

    public static void main(String[] args) {
        try {
            // Get a connection to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dsainventory", "root", "prince");

            // SQL statement
            Statement stmt=con.createStatement();

            // Execute SQL query
            ResultSet rs=stmt.executeQuery("select * from good");

            //
            List<Good> goods = null;

            // process the results
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3) +"  "+rs.getString(4) +"  "+rs.getString(6));
                goods.add(new Good(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getFloat(4), rs.getFloat(5), rs.getFloat(6)));
            // close mysql db connection
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static ObservableList<Good> getGoods(){
        try {
            // Get a connection to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dsainventory", "root", "prince");

            // SQL statement
            Statement stmt=con.createStatement();

            // Execute SQL query
            ResultSet rs=stmt.executeQuery("select * from good");

            // list of goods from db
            ObservableList<Good> goods = FXCollections.observableArrayList();

            // process the results
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3) +"  "+rs.getString(4) +"  "+rs.getString(6));
            goods.add(new Good(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getFloat(4), rs.getFloat(5), rs.getFloat(6)));
            // close mysql db connection
            con.close();

            return goods;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
