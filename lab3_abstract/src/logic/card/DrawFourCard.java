package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

import java.sql.SQLOutput;
import java.util.ArrayList;

//You CAN modify the first line
public class DrawFourCard extends EffectCard{
    // TODO Implement here
    public DrawFourCard(){
        super(null, CardSymbol.DRAW_FOUR);
    }

    public String toString(){
        if(this.getColor() == null) return this.getSymbol().toString();
        else return this.getSymbol().toString() + " (" + this.getColor() + " color selected)";
    }

    public boolean canPlay() {
        return true;
    }


    @Override
    public String performEffect() {
        String message = "";
        ArrayList<BaseCard> currentHand= GameLogic.getInstance().getCurrentPlayerHand();
        if(currentHand.isEmpty()) {
            this.setColor(CardColor.RED);
        }
        else {
            this.setColor(currentHand.get(0).getColor());
            if(this.getColor()==null)
                this.setColor(CardColor.RED);
        }
        message += "Set color to " + this.getColor() + "\n";

        GameLogic.getInstance().incrementDrawAmount(4);

        GameLogic.getInstance().goToNextPlayer();
        while(GameLogic.getInstance().getCurrentPlayerHand().isEmpty()){
            GameLogic.getInstance().goToNextPlayer();
        }

        boolean play = true;
        for(BaseCard current : GameLogic.getInstance().getCurrentPlayerHand()){
            if(current.getSymbol() == CardSymbol.DRAW_FOUR){
                int handSize = GameLogic.getInstance().getCurrentPlayerHand().size()-1;
                message += "Player " + GameLogic.getInstance().getCurrentPlayer() + " played " + this.getSymbol().toString() + ". " + handSize + " cards remaining.";
                message += "\n" + current.play();
                play = false;
                break;
            }

        }

        if(play){
            GameLogic.getInstance().draw(GameLogic.getInstance().getDrawAmount());
            message += "Player " + GameLogic.getInstance().getCurrentPlayer() + " drew " + GameLogic.getInstance().getDrawAmount() + " cards. " + GameLogic.getInstance().getCurrentPlayerHand().size() + " cards remaining.";
            GameLogic.getInstance().setDrawAmount(0);
        }

        return message;

    }
}
