package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.PolynamesDatabase;
import models.Game;
import models.Card;
import models.Word;
import models.Color;
import models.Player;

public class GameDAO{

    private PolynamesDatabase database;
    
    public GameDAO(){
        try {
            this.database = new PolynamesDatabase();
        } 
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<Game> findAll(){
        ArrayList<Game> games = new ArrayList<Game>();
        String query = "SELECT * FROM `jeu` ORDER BY `id` ;";
        
        try {
            PreparedStatement myStatement = database.prepareStatement(query);
            ResultSet results = myStatement.executeQuery();
            while(results.next()){
                int id = results.getInt("id");
                int score = results.getInt("score");
                String code = results.getString("code");
                
                Game game = new Game(id, code, score);
                
                games.add(game);
            }
            return games;
        } 
        
        catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        
    }

    public Game findById(int id) throws SQLException {
        String query = "SELECT * FROM `jeu` WHERE id = ?";
        PreparedStatement preparedStatement = database.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new Game(
                    resultSet.getInt("id"),
                    resultSet.getString("code"),
                    resultSet.getInt("score")
                    );
        }
        return null;
    }

    public ArrayList<Card> findCard() throws SQLException {
        ArrayList<Card> cards = new ArrayList<Card>();
        String query = "SELECT * FROM `carte` ORDER BY `id`";
        PreparedStatement myStatement = database.prepareStatement(query);
        ResultSet results = myStatement.executeQuery();
        while(results.next()){
            int id = results.getInt("id");
            String state = results.getString("state");
            int position = results.getInt("position");
            int idColor = results.getInt("idColor");
            int idMot = results.getInt("idMot");
            
            Card card = new Card(id, state, position, idColor, idMot);
            
            cards.add(card);
        }
        return cards;
    } 
}