package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

//You CAN modify the first line
public class SkipCard extends EffectCard {
    // TODO Implement here
    public SkipCard(CardColor color){
        super(color, CardSymbol.SKIP);
    }
    @Override
    public String toString(){
        return this.getColor().toString() + " " + this.getSymbol().toString();
    }

    @Override
    public boolean canPlay(){
        if(GameLogic.getInstance().getTopCard().getColor() == this.getColor())return true;
        if(GameLogic.getInstance().getTopCard().getSymbol() == this.getSymbol())return true;
        return false;
    }

    @Override
    public String performEffect(){
        GameLogic now = GameLogic.getInstance();
        now.goToNextPlayer();
        while(now.getCurrentPlayerHand().isEmpty()){
            now.goToNextPlayer();
        }
        return "Skipped player " + now.getCurrentPlayer();
    }




}
