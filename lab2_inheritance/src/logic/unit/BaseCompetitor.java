package logic.unit;

public class BaseCompetitor {
    //-------- variable -----------------------------------------
    private String name;
    private int power;
    private int hp;

    //--------Method --------------------------------------------
    public BaseCompetitor(String name){
        this.setName(name);
        this.setPower(3);
        this.setHp(5);

    }

    public BaseCompetitor(String name, int hp, int power){
        this.setName(name);
        this.setPower(power);
        this.setHp(hp);
    }

    public void attack(BaseCompetitor enemy){
        enemy.setHp(enemy.getHp() - this.getPower());
    }

    public String getType(){

        if (this instanceof Sorcerer){
            return "Sorcerer";
        }
        if (this instanceof Tiger){
            return "Tiger";
        }
        if (this instanceof ToughMan){
            return "ToughMan";
        }
        return "BaseCompetitor";
    }
    //--------setter getter -------------------------------------

    public void setName(String name) {
        this.name = name;

    }
    public void setHp(int hp) {
        if (hp < 0){
            hp = 0;
        }
        this.hp = hp;
    }

    public void setPower(int power) {
        if (power < 1){
            power = 1;
        }
        this.power = power;
    }
    public String getName() {
        return name;
    }
    public int getHp() {
        return hp;
    }
    public int getPower() {
        return power;
    }

}
