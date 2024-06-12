package controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.GameDAO;
import models.Card;
import models.Game;
import webserver.WebServerContext;
import models.TempCard;

public class GameController {

    public static ArrayList<Game> findAll(WebServerContext serverContext){
        GameDAO dao = new GameDAO();
        //serverContext.getResponse().ok("Tous les produits :");
        serverContext.getResponse().json(dao.findAll());
        return dao.findAll();
    }

    public static ArrayList<Card> createCards(WebServerContext serverContext) throws SQLException {
        GameDAO dao = new GameDAO();
        ArrayList<Card> cards = dao.createCard();
        ArrayList<TempCard> temp = new ArrayList<TempCard>();
        for(int i = 0; i < cards.size(); i++){
            TempCard temp_card = new TempCard(cards.get(i).getId(), cards.get(i).getState(), dao.findColorById(cards.get(i).getIdColor()), dao.findWordById(cards.get(i).getIdWord()));
            temp.add(temp_card);
        }
        serverContext.getResponse().json(temp);
        return cards;
    }
}

