package entity.ingredient;

import entity.base.Cookable;
import entity.base.Ingredient;
import logic.StringUtil;

public class Egg extends Ingredient implements Cookable {
    private int cookedPercentage;
    public Egg(){
        super("Egg");
        this.setCookedPercentage(0);
    }

    public void setCookedPercentage(int cookedPercentage) {
        this.cookedPercentage = cookedPercentage;
    }

    public int getCookedPercentage() {
        return cookedPercentage;
    }
    @Override
    public void cook(){
        setCookedPercentage(this.getCookedPercentage() + 12);

        int x = this.getCookedPercentage();

        if(x > 0 && x <= 50){
            this.setName("Raw Egg");
            this.setEdible(false);
        }
        if(x > 50 && x<= 80){
            this.setName("Sunny Side Egg");
            this.setEdible(true);
        }

        if(x > 80 && x<= 100){
            this.setName("Fried Egg");
            this.setEdible(true);
        }

        if(x > 100){
            this.setName("Burnt Egg");
            this.setEdible(false);
        }

    }
    @Override
    public boolean isBurnt(){
        if(this.getCookedPercentage() > 100){
            return true;
        }
        return false;
    }

    public String toString(){
        return StringUtil.formatNamePercentage(this.getName(), this.getCookedPercentage());
    }


}
