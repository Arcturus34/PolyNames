package controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.GameDAO;
import models.Card;
import models.Game;
import webserver.WebServerContext;

public class GameController {

    public static ArrayList<Game> findAll(WebServerContext serverContext){
        GameDAO dao = new GameDAO();
        //serverContext.getResponse().ok("Tous les produits :");
        serverContext.getResponse().json(dao.findAll());
        return dao.findAll();
    }

    public static ArrayList<Card> findCard(WebServerContext serverContext) throws SQLException {
        GameDAO dao = new GameDAO();
        serverContext.getResponse().json(dao.findCard());
        return dao.findCard();
    } 
}

