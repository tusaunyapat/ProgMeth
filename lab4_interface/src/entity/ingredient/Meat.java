package entity.ingredient;

import entity.base.Choppable;
import entity.base.Cookable;
import entity.base.Ingredient;
import logic.StringUtil;

public class Meat extends Ingredient implements Choppable, Cookable {
    private boolean chopState;
    private int cookedPercentage;
    public Meat(){
        super("Meat");
        this.setChopState(false);
        this.setCookedPercentage(0);
    }

    public void setChopState(boolean chopState) {
        this.chopState = chopState;
    }

    public int getCookedPercentage() {
        return cookedPercentage;
    }

    public void setCookedPercentage(int cookedPercentage) {
        this.cookedPercentage = cookedPercentage;
    }

    public void chop(){
        if(!(isChopped() || (this.getCookedPercentage() > 0))){
            this.setChopState(true);
            this.setName("Minced Meat");
        }
    }

    @Override
    public boolean isChopped() {
        return chopState;
    }


    @Override
    public void cook() {
        if(!isChopped()){
            this.setCookedPercentage(this.getCookedPercentage() + 10);

            int x = this.getCookedPercentage();
            if(x <= 50){
                this.setName("Raw Meat");
                this.setEdible(false);
            }
            else if(x <= 80){
                this.setName("Medium Rare Steak");
                this.setEdible(true);
            }
            else if(x <= 100){
                this.setName("Well Done Steak");
                this.setEdible(true);
            }
            else {
                this.setName("Burnt Steak");
                this.setEdible(false);
            }

        }

        else {
            this.setCookedPercentage(this.getCookedPercentage() + 15);

            int x = this.getCookedPercentage();

            if(x <= 80){
                this.setName("Raw Burger");
                this.setEdible(false);
            }
            else if(x <= 100){
                this.setName("Cooked Burger");
                this.setEdible(true);
            }
            else {
                this.setName("Burnt Burger");
                this.setEdible(false);
            }

        }
    }

    @Override
    public boolean isBurnt() {
        return this.getCookedPercentage() > 100;
    }

    public String toString(){
        return StringUtil.formatNamePercentage(this.getName(), this.getCookedPercentage());
    }
}
