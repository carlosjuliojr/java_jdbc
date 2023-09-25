package org.julio.java.jdbc;

import org.julio.java.jdbc.util.ConnectionDataBase;

import java.sql.*;

public class ExampleJdbc {

    public static void main(String[] args) {


        //connection stmt and resultSet close automatically
        try(Connection connection = ConnectionDataBase.getInstance();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("Select * FROM products")) {
            System.out.println("ID\t\t |\tname\t\t|\tprice\t\t|\tdate registered");
            while (resultSet.next()){

                System.out.print(resultSet.getString("id")+"\t\t\t");
                System.out.print(resultSet.getString("name")+"\t\t\t");
                System.out.print(resultSet.getInt(3)+"\t\t\t");
                System.out.println(resultSet.getDate(4)+"\t");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
