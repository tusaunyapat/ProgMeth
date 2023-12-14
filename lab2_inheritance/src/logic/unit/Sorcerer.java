package logic.unit;

public class Sorcerer extends BaseCompetitor{
    public Sorcerer(String name){
        super(name, 4, 2);
    }

    public Sorcerer(String name, int hp, int power){
        super(name, hp, power);
    }

    public void lowerPower(BaseCompetitor enemy, int powerDown){
        if (powerDown < 0){
            powerDown = 0;
        }

        enemy.setPower(enemy.getPower() - powerDown);

        if (enemy.getPower() < 1){
            enemy.setPower(1);
        }
    }

    public void attack(BaseCompetitor enemy){
        String type = enemy.getType();
        int damage = this.getPower();

        if (type.equals("Tiger")){
            damage = damage / 2;
        }
        else if (type.equals("Sorcerer") || type.equals("BaseCompetitor")){
            damage = damage;
        }
        else {
            damage = damage * 3 / 2;
        }

        enemy.setHp(enemy.getHp() - damage);
    }




}
