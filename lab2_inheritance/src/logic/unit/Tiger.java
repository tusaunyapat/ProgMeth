package logic.unit;

public class Tiger extends BaseCompetitor{
    public Tiger(String name){
        super(name, 7, 5);
    }
    public Tiger(String name, int hp, int power){
        super(name, hp, power);
    }
    public void train(int addPower){
        if (addPower < 0){
            addPower = 0;
        }
        this.setPower(this.getPower() + addPower);
    }
    public void attack(BaseCompetitor enemy){
        String type = enemy.getType();
        int damage = this.getPower();

        if (type.equals("ToughMan")){
            damage = damage / 2;
        }
        else if (type.equals("Tiger") || type.equals("BaseCompetitor")){
            damage = damage;
        }
        else {
            damage = damage *3 /2;
        }

        enemy.setHp(enemy.getHp() - damage);

    }
}
