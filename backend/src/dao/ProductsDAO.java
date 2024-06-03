package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.PolyBayDatabase;
import models.Product;

public class ProductsDAO{

    private PolyBayDatabase database;
    
    public ProductsDAO(){
        try {
            this.database = new PolyBayDatabase();
        } 
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<Product> findAll(){
        ArrayList<Product> produits = new ArrayList<Product>();
        String query = "SELECT * FROM product ORDER BY name ;";
        
        try {
            PreparedStatement myStatement = database.prepareStatement(query);
            ResultSet results = myStatement.executeQuery();
            while(results.next()){
                final String owner = results.getString("owner");
                final String name = results.getString("name");
                final int id = results.getInt("id");
                final int bid = results.getInt("bid");
                
                Product produit = new Product(id, name, owner, bid);
                
                produits.add(produit);
            }
            return produits;
        } 
        
        catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        
    }

    public Product findById(int id) throws SQLException {
        String query = "SELECT * FROM product WHERE id = ?";
        PreparedStatement preparedStatement = database.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new Product(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("owner"),
                    resultSet.getFloat("bid"));
        }
        return null;
    }

    public boolean bid(int productId) throws SQLException {
        String query = "UPDATE product SET bid = bid + 50 WHERE id = ?";
        PreparedStatement preparedStatement = database.prepareStatement(query);
        preparedStatement.setInt(1, productId);
        return preparedStatement.executeUpdate() > 0;
    }
}
