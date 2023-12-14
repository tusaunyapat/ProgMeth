package entity.counter;

import entity.base.Container;
import entity.base.Ingredient;
import entity.base.Item;
import logic.Player;

public class Bin extends Counter{
    public Bin(){
        this.setName("Bin");
    }

    public void interact(Player p){
        if(p.isHandEmpty()){
            return;
        }

        Item t = p.getHoldingItem();
        if(t instanceof Ingredient){
           p.placeItem();
        }
        if(t instanceof Container){
            Container c = (Container) t;
            c.clearContent();
        }
    }
}
