package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

import java.util.ArrayList;

//You CAN modify the first line
public class DrawTwoCard extends EffectCard {
    // TODO Implement here
    public DrawTwoCard(CardColor color){
        super(color, CardSymbol.DRAW_TWO);
    }

    public String toString(){
        return this.getColor().toString() + " " + this.getSymbol().toString();
    }


    public boolean canPlay() {
        if(this.getColor() == GameLogic.getInstance().getTopCard().getColor())return true;
        if(this.getSymbol() == GameLogic.getInstance().getTopCard().getSymbol())return true;
        return false;
    }

    @Override
    public String performEffect() {
        String message = "";
        GameLogic now = GameLogic.getInstance();
        now.incrementDrawAmount(2);
        now.goToNextPlayer();
        while(now.getCurrentPlayerHand().isEmpty())now.goToNextPlayer();
        boolean play = true;

        for(BaseCard currentCard : now.getCurrentPlayerHand()){
            if(currentCard.getSymbol() == CardSymbol.DRAW_TWO || currentCard.getSymbol() == CardSymbol.DRAW_FOUR ){
                int hand = now.getCurrentPlayerHand().size() -1;
                message = "Player " + now.getCurrentPlayer() + " played " + currentCard.toString() +". " + hand + " cards remaining.";
                message += "\n" + currentCard.play();
                play = false;
                break;
            }
        }
        if(play){
            now.draw(now.getDrawAmount());
            message = "Player " + now.getCurrentPlayer() + " drew " + now.getDrawAmount() + " cards. " + now.getCurrentPlayerHand().size() + " cards remaining.";
            now.setDrawAmount(0);
        }

        return message;
    }
}
