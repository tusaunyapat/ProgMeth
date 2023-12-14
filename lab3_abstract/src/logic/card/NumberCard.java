package logic.card;

import logic.game.CardSymbol;
import logic.game.CardColor;
import logic.game.GameLogic;

//You CAN modify the first line
public class NumberCard extends BaseCard {
    // TODO Implement here
    public NumberCard(CardColor color, CardSymbol symbol){
        super(color, symbol);
    }

    public String toString(){
        return this.getColor().toString() + " " + this.getSymbol().toString();
    }

    public boolean canPlay(){
        GameLogic now = GameLogic.getInstance();
        BaseCard top = now.getTopCard();
        if(top.getColor() == this.getColor())return true;
        if(top.getSymbol() == this.getSymbol())return true;
        return false;
    }

    public String play(){
        GameLogic now = GameLogic.getInstance();
        now.setTopCard(this);
        now.getCurrentPlayerHand().remove(this);
        return null;
    }


}
