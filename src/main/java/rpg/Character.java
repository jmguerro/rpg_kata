package rpg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rpg.exception.ActionException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Character {

    public int hp;
    private int level;
    private Boolean alive;

    public void attack(int dmg, Character who) {

        if (who.alive.equals(true) && this != who) {
            hp = who.getHp() - dmg;
            who.setHp(hp);
            isAlive(who);
        } else {
            throw new ActionException("Cannot attack");
        }
    }

    public void heal(int heal, Character who) {
        if (who.alive.equals(true) && this == who) {
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

}
