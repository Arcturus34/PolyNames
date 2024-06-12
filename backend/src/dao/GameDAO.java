package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import database.PolynamesDatabase;
import models.Game;
import models.Card;

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

    public String findWordById(int id) throws SQLException {
        String query = "SELECT nom FROM `mot` WHERE id = ?";
        PreparedStatement preparedStatement = database.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getString("nom");
        }
        return null;
    }
    
    public String findColorById(int id) throws SQLException {
        String query = "SELECT nom FROM `couleur` WHERE id = ?";
        PreparedStatement preparedStatement = database.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getString("nom");
        }
        return null;
    }

    private int randomIdWord(ArrayList<Integer> array, Random random) {
        ArrayList<Integer> word = array;
        int idword;
        boolean isUnique = false;
        do {
            idword = random.nextInt(400) + 1;
            isUnique = !word.contains(idword);
        } while (!isUnique);
        return idword;
    }
    
private int randomIdColor(Random random, AtomicInteger noir, AtomicInteger gris, AtomicInteger bleu) {
    int idcolor;
    do {
        idcolor = random.nextInt(3) + 1;
    } while (((idcolor == 1) && (bleu.get() >= 8)) || ((idcolor == 2) && (gris.get() >= 15)) || ((idcolor == 3) && (noir.get() >= 2)));
    
    switch (idcolor) {
        case 1:
            bleu.incrementAndGet();
            break;
        case 2:
            gris.incrementAndGet();
            break;
        case 3:
            noir.incrementAndGet();
            break;
    }
    
    return idcolor;
}

    

    public ArrayList<Card> createCard() throws SQLException {
        Random random = new Random();
        AtomicInteger noir = new AtomicInteger(0);
        AtomicInteger gris = new AtomicInteger(0);
        AtomicInteger bleu = new AtomicInteger(0);
        ArrayList<Integer> word = new ArrayList<Integer>();
        ArrayList<Card> cards = new ArrayList<Card>();
        for(int j = 1; j <= 25; j++){
            int idcolor = randomIdColor(random, noir, gris, bleu);
            int idword = randomIdWord(word, random);
            word.add(idword);
            int id = j;
            int state = 0;

            Card card = new Card(id, state, idcolor, idword);
            cards.add(card);
        }
        return cards;
        
    }
    
    /*public ArrayList<Card> CardsfindAll() throws SQLException {
        ArrayList<Card> cards = new ArrayList<>();
        String query = "SELECT * FROM `carte` ORDER BY `id`";
        PreparedStatement myStatement = database.prepareStatement(query);
        ResultSet results = myStatement.executeQuery();
        while (results.next()) {
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
    */
}