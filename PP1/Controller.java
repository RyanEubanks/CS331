import javax.swing.*;

import Constants.*;

import java.awt.*;

public class Controller extends JFrame{

    //private Table table;

    public static void main(String[] args) {
        StartGame();
        /*
        for(Card card : deck1.getDeck()) {
            System.out.println(card.getSuit() + " " + card.getFace() + ": " + card.getValue());
        }

        System.out.println("===========================================");
        
        deck1.shuffleDeck(500);
        for(Card cards : deck1.getDeck()) {
            System.out.println(cards.getSuit() + " " + cards.getFace() + ": " + cards.getValue());
        }
        */


    }

    public static void StartGame() {
        DeckOfCards deck1 = new DeckOfCards(1);
        Table table = new Table();
        table.drawTable();

        
    }

}