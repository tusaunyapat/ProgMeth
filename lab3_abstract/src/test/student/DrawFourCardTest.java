package test.student;

import logic.card.*;
import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrawFourCardTest {
    DrawFourCard c1;
    NumberCard c2;

    DrawTwoCard c3;
    DrawFourCard c4;
    DrawFourCard c5;

    NumberCard c6;

    @BeforeEach
    void setup() {
        c1 = new DrawFourCard();
        c2 = new NumberCard(CardColor.YELLOW, CardSymbol.ZERO);
        c3 = new DrawTwoCard(CardColor.GREEN);
        c4 = new DrawFourCard();
        c5 = new DrawFourCard();
        c6 = new NumberCard(CardColor.BLUE, CardSymbol.ONE);
    }

    @AfterEach
    void tearDown() {
        GameLogic.clearInstance();
    }

    @Test
    void testConstructor() {
        assertNull(c1.getColor());
        assertEquals(CardSymbol.DRAW_FOUR, c1.getSymbol());
    }

    @Test
    void testToString() {
        assertEquals("DRAW FOUR", c1.toString());
        c1.setColor(CardColor.YELLOW);
        assertEquals("DRAW FOUR (YELLOW color selected)", c1.toString());
    }

    @Test
    void testCanPlay() {
        GameLogic gameInstance = GameLogic.getInstance(1);

        gameInstance.setTopCard(c2);
        assertTrue(c1.canPlay());

        gameInstance.setTopCard(c3);
        assertTrue(c1.canPlay());

        gameInstance.setTopCard(c4);
        assertTrue(c1.canPlay());
    }

    @Test
    void testPerformEffect1() {
        // Next player hand non empty, has +4 / player 0 first card is yellow, player 1 first card is green
        GameLogic gameInstance = GameLogic.getInstance(2);
        for (int i=0; i<8; i++)
            gameInstance.getDeck().add(new NumberCard(CardColor.randomColor(), CardSymbol.randomSymbol()));
        gameInstance.getPlayerHand(0).add(c2);
        gameInstance.getPlayerHand(1).add(c4);
        gameInstance.getPlayerHand(1).add(c3);

        String message = c1.performEffect();

        assertEquals(0, gameInstance.getDrawAmount());
        assertEquals("Set color to YELLOW\n" +
                "Player 1 played DRAW FOUR. 1 cards remaining.\n" +
                "Set color to GREEN\n" +
                "Player 0 drew 8 cards. 9 cards remaining.", message);
    }

    @Test
    void testPerformEffect2() {
        // Next player hand empty, skip to the player after, has +4 / player 0 first card has no color, player 1 has no cards left
        ChangeColorCard c6 = new ChangeColorCard();

        GameLogic gameInstance = GameLogic.getInstance(3);
        for (int i=0; i<8; i++)
            gameInstance.getDeck().add(new NumberCard(CardColor.randomColor(), CardSymbol.randomSymbol()));
        gameInstance.getPlayerHand(0).add(c6);
        gameInstance.getPlayerHand(0).add(c2);
        gameInstance.getPlayerHand(2).add(c4);

        String message = c1.performEffect();

        assertEquals(0, gameInstance.getDrawAmount());
        assertEquals("Set color to RED\n" + 
                "Player 2 played DRAW FOUR. 0 cards remaining.\n" +
                "Set color to RED\n" +
                "Player 0 drew 8 cards. 10 cards remaining.", message);
    }

    @Test
    void testPerformEffect3() {
        // Next player hand doesn't have +4
        GameLogic gameInstance = GameLogic.getInstance(2);
        for (int i=0; i<4; i++)
            gameInstance.getDeck().add(new NumberCard(CardColor.randomColor(), CardSymbol.randomSymbol()));
        gameInstance.getPlayerHand(0).add(c2);
        gameInstance.getPlayerHand(1).add(c3);

        String message = c1.performEffect();

        assertEquals(0, gameInstance.getDrawAmount());
        assertEquals("Set color to YELLOW\nPlayer 1 drew 4 cards. 5 cards remaining.", message);
    }

    @Test
    void testPlay() {
        // +4 +4 +4 +4
        // TODO Implement here
        String message = "";
        GameLogic now = GameLogic.getInstance(4);
        for (int i=0; i<16; i++)
            now.getDeck().add(new NumberCard(CardColor.randomColor(), CardSymbol.randomSymbol()));
        ArrayList<BaseCard> first = now.getPlayerHand(0);
        ArrayList<BaseCard> second = now.getPlayerHand(1);
        ArrayList<BaseCard> third = now.getPlayerHand(2);
        ArrayList<BaseCard> fourth = now.getPlayerHand(3);
        first.add(c1);
        first.add(c2);
        second.add(c1);
        second.add(c3);
        third.add(c1);
        third.add(new NumberCard(CardColor.BLUE, CardSymbol.ZERO));
        fourth.add(c1);
        message = now.getCurrentPlayerHand().get(0).play();



        assertEquals("Set color to YELLOW\n" +
                "Player 1 played DRAW FOUR. 1 cards remaining.\n" +
                "Set color to GREEN\n" +
                "Player 2 played DRAW FOUR. 1 cards remaining.\n" +
                "Set color to BLUE\n" +
                "Player 3 played DRAW FOUR. 0 cards remaining.\n" +
                "Set color to RED\n" +
                "Player 0 drew 16 cards. 17 cards remaining.", message);
    }
}
