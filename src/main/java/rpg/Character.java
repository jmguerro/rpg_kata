package rpg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rpg.exception.ActionException;

import java.util.logging.Logger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Character {

    private static final Logger logger = Logger.getLogger(Character.class.getName());

    public int hp;
    private int level;
    private Boolean alive;
    private Range range;


    public void attack(int dmg, Character who) {

        if (who.alive.equals(true) && this != who) {

            isInRange(dmg, who);
        } else {
            throw new ActionException("Cannot attack");
        }
    }

    public void heal(int heal, Character who) {
        if (alive && this == who) {
            hp = Math.min(hp + heal, 1000);
            who.setHp(hp);
        } else {
            throw new ActionException("Cannot heal.");
        }
    }

    public void isAlive(Character who) {
        if (getHp() <= 0) {
            who.setAlive(false);
        }
    }


    public void isInRange(int dmg , Character who) {
        int rangeDiff = getRange().ordinal() - who.getRange().ordinal();

       switch (rangeDiff){
           case 18,0,1 -> damageBasedOnLevel(dmg, who);
           default ->
               throw new ActionException("No estas en rango");
       }


    }




    public void damageBasedOnLevel(int dmg, Character who) {

        int levelDiff = getLevel() - who.getLevel();
        if (levelDiff >= -4 && levelDiff <= 4) {
            hp = Math.toIntExact(Math.round(who.getHp() - dmg));
            who.setHp(hp);
            isAlive(who);

        } else if (levelDiff > -4) {
            hp = Math.toIntExact(Math.round(who.getHp() - (dmg * 1.5)));
            who.setHp(hp);
            isAlive(who);
        } else if (levelDiff < -4) {
            hp = Math.toIntExact(Math.round(who.getHp() - (dmg * 0.5)));
            who.setHp(hp);
            isAlive(who);
        }


    }

}
