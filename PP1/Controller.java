import javax.swing.*;

import Constants.*;

import java.awt.*;

public class Controller extends JFrame{

    //private Table table;

    public static void main(String[] args) {
        //StartGame();
        test();

    }
/* 
    public static void StartGame() {
        DeckOfCards deck1 = new DeckOfCards(1);
        deck1.populateDeck();
        Card[] hand = new Card[10];
        
        Player player1 = new Player(hand, 0, 0, "Ryan");
        Table table = new Table();

        table.add(new CirclePanel());

        table.drawTable();
        table.pack();
        table.setVisible(true);
    
    }
*/

    public static void test() {
        Table table = new Table();

        table.drawTable();
    }

}