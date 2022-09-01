package sample;

import java.sql.*;

public class DBConnect {
    DBConnect(){

    }

    public static void connect(){

        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from users");

            while(resultSet.next()){
                System.out.println(resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getString(5));
            }

            connection.close();
        }
        catch(Exception e){
            System.out.println(e.fillInStackTrace());
        }
    }
}
