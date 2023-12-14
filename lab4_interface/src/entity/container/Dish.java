package entity.container;

import entity.base.Container;
import entity.base.Ingredient;
import logic.StringUtil;

public class Dish extends Container {
    private int dirty;
    public Dish(){
        super("Dish", 4);
        this.setDirty(0);
    }

    public Dish(int dirty){
        super("Dish", 4);
        this.setDirty(dirty);
    }

    public void setDirty(int dirty) {
        if(dirty < 0){
            dirty = 0;
        }
        this.dirty = dirty;
        if(dirty > 0){
            this.setName("Dirty Dish");
        }
        else {
            this.setName("Dish");
        }
    }

    public int getDirty() {
        return dirty;
    }

    public boolean isDirty(){
        return this.getDirty() > 0;
    }

    public boolean verifyContent(Ingredient i){
        return this.getDirty() == 0 && i.isEdible();
    }

    public void clean(int amount){
        this.setDirty(this.getDirty() - amount);
    }

    public String toString(){
        if(isDirty()){
            return StringUtil.formatNamePercentage(this.getName(), this.getDirty());
        }
        return super.toString();
    }



}
