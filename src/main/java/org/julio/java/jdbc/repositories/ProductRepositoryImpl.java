package org.julio.java.jdbc.repositories;

import org.julio.java.jdbc.model.Product;
import org.julio.java.jdbc.util.ConnectionDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Product repository.
 */
public class ProductRepositoryImpl implements Repository<Product> {

    private Connection getConnection() throws SQLException {
        return ConnectionDataBase.getInstance();
    }

    @Override
    public List<Product> list() throws SQLException {
        List<Product> products = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * from Products")) {

            while (rs.next()) {
                products.add(createProduct(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    @Override
    public Product getById(Long id) throws SQLException {
        Product product = null;
        try (PreparedStatement stmt = getConnection().
                prepareStatement("Select * from Products WHERE id = ?")) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    product = createProduct(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    private static Product createProduct(ResultSet rs) throws SQLException {
        Product product = new Product(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getInt("price"),
                rs.getDate("dateRegister"));
        return product;
    }

    @Override
    public void save(Product product) throws SQLException {

        String sql;
        if (product.getId() != null && product.getId() > 0) {
            sql = "UPDATE products SET name=?, price=? WHERE id=?";
        } else {
            sql = "INSERT INTO products(name, price, dateRegister) VALUES(?,?,?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setString(1, product.getName());
            stmt.setLong(2, product.getPrice());

            //update
            if (product.getId() != null && product.getId() > 0L) {
                stmt.setLong(3, product.getId());
            } else { //insert
                stmt.setDate(3, new Date(product.getDateRegister().getTime()));
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Long id) throws SQLException {

        try (PreparedStatement stmt = getConnection().prepareStatement("DELETE from products where id=?")) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
