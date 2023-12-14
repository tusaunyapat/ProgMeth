package logic;

import exception.NameBlankException;

public class ItemCounter {
    // FIELD
    private Item item;
    private int count;

    // constructors
    public ItemCounter(Item item) {
        this.setItem(item);
       setCount(1);
    }

    public ItemCounter(Item item, int count){
        this.setItem(item);
        if (count < 1){
            count = 1;
        }

        this.setCount(count);

    }


    //methods
    public String toString(){
        return this.getItem() + " x" + this.getCount();
    }

    //setter & getter
    public Item getItem() {
        return this.item;
    }

    public void setItem(Item item){
        this.item = item;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        if(count < 0){
            count = 0;
        }
        this.count = count;
    }
}
