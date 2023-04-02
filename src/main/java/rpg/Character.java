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

    public void attack(int dmg , Character who){

        hp = who.getHp() - dmg;
        who.setHp(hp);
        isAlive(who);
    }

    public void isAlive(Character who){
        if(getHp() <= 0){
            who.setAlive(false);
        }
    }

}
