package rpg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Character {

    public int hp;
    private int level;
    private Boolean alive;

    public void attack(int dmg, Character who) {

        if (who.alive.equals(true)) {
            hp = who.getHp() - dmg;
            who.setHp(hp);
            isAlive(who);
        } else {

        }
    }

    public void heal(int heal, Character who) {
        if (who.alive.equals(true)) {
            hp = who.getHp() + heal;
            who.setHp(hp);
        } else {

        }
    }

    public void isAlive(Character who) {
        if (getHp() <= 0) {
            who.setAlive(false);
        }
    }

}
