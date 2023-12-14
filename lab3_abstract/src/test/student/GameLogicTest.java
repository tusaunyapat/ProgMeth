package test.student;

import logic.card.BaseCard;
import logic.card.ChangeColorCard;
import logic.card.NumberCard;
import logic.card.SkipCard;
import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GameLogicTest {

    ArrayList<BaseCard> hand0;
    ArrayList<BaseCard> hand1;

    NumberCard c1;
    SkipCard c2;
    NumberCard c3;
    ChangeColorCard c4;

    @BeforeEach
    void setup() {
        c1 = new NumberCard(CardColor.YELLOW, CardSymbol.NINE);
        c2 = new SkipCard(CardColor.YELLOW);
        c3 = new NumberCard(CardColor.RED, CardSymbol.NINE);
        c4 = new ChangeColorCard();
    }

    @AfterEach
    void tearDown() {
        GameLogic.clearInstance();
    }

    @Test
    void testIsHandPlayableTrue() {
        // TODO Implement here
        GameLogic gameInstant = GameLogic.getInstance(2);

        ArrayList<BaseCard> zero = gameInstant.getPlayerHand(0);
        ArrayList<BaseCard> first = gameInstant.getPlayerHand(1);

        gameInstant.setTopCard(c3);

        zero.add(c1);
        zero.add(c2);
        zero.add(c3);

        first.add(c2);
        first.add(c4);

        assertTrue(gameInstant.isHandPlayable(0));
        assertTrue(gameInstant.isHandPlayable(1));


    }

    @Test
    void testIsHandPlayableFalse() {
        // TODO Implement here
        GameLogic gameInstant = GameLogic.getInstance(2);

        ArrayList<BaseCard> zero = gameInstant.getPlayerHand(0);
        ArrayList<BaseCard> first = gameInstant.getPlayerHand(1);

        gameInstant.setTopCard(new NumberCard(CardColor.BLUE, CardSymbol.ONE) {
        });


        zero.add(c3);
        first.add(c2);

        assertFalse(gameInstant.isHandPlayable(1));
    }

    @Test
    void testDrawLessThanDeck() {
        // TODO Implement here
        GameLogic gameInstant = GameLogic.getInstance(1);
        for(int i=0;i<10;i++){
            gameInstant.getDeck().add(new NumberCard(CardColor.randomColor(), CardSymbol.randomSymbol()));
        }

        assertEquals(5, gameInstant.draw(5).size());

    }

    @Test
    void testDrawMoreThanDeck() {
        // TODO Implement here
        GameLogic gameInstant = GameLogic.getInstance(1);
        for(int i=0;i<10;i++){
            gameInstant.getDeck().add(new NumberCard(CardColor.randomColor(), CardSymbol.randomSymbol()));
        }

        assertEquals(10, gameInstant.draw(20).size());

    }

}
