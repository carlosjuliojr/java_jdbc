package org.julio.java.jdbc;

import org.julio.java.jdbc.model.Product;
import org.julio.java.jdbc.repositories.ProductRepositoryImpl;
import org.julio.java.jdbc.repositories.Repository;
import org.julio.java.jdbc.util.ConnectionDataBase;

import java.sql.*;
import java.util.Date;

public class ExampleJdbc {

    public static void main(String[] args) {

        //connection stmt and resultSet close automatically
        try(Connection connection = ConnectionDataBase.getInstance();

        ) {

            Repository<Product> repository = new ProductRepositoryImpl();

            System.out.println("************Get all products***********");
            repository.list().forEach(System.out::println);
            System.out.println("************ Get by id : 2 ************");
            System.out.println(repository.getById(2L).toString());
            System.out.println("************ Insert new product************");
            Product p = new Product("Keyboard mecanic",500, new Date());
            repository.save(p);
            System.out.println("************Get all products***********");
            repository.list().forEach(System.out::println);
            System.out.println("************ Update  product************");
             Product p2 = new Product(3L,"Keyboard",700, new Date());
            repository.save(p2);
            System.out.println("************Get all products after update***********");
            repository.list().forEach(System.out::println);
            System.out.println("************Delete***********");
            repository.delete(3L);
            repository.list().forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
