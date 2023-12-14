package logic.unit;

public class ToughMan extends BaseCompetitor{
    private int maxHp;

    public ToughMan(String name){
        super(name, 8, 4);
        this.setMaxHp(8);
    }

    public ToughMan(String name, int hp, int power){
        super(name, hp, power);
        this.setMaxHp(hp);
    }

    public void heal(int healHp){
        if (healHp < 0){
            healHp = 0;
        }
        int newHp = this.getHp() + healHp;

        if (newHp > this.getMaxHp()){
            newHp = this.getMaxHp();
        }
        this.setHp(newHp);
    }

    public void attack(BaseCompetitor enemy){
        String type = enemy.getType();
        int damage = this.getPower();

        if(type.equals("Sorcerer")){
            damage = damage / 2;
        }
        else if(type.equals("ToughMan") || type.equals("BaseCompetitor")){
            damage = damage;
        }
        else {
            damage = damage * 3 / 2;
        }

        enemy.setHp(enemy.getHp() - damage);

    }







    public void setMaxHp(int maxHp) {
        if(maxHp < 0){
            maxHp = 0;
        }
        if (maxHp < this.getHp()){
            this.setHp(maxHp);
        }
        this.maxHp = maxHp;
    }

    public int getMaxHp() {
        return maxHp;
    }
}
