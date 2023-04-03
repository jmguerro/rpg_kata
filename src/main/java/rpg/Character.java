package rpg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rpg.exception.ActionException;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
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
    private List<Faction> factionsList;



    public void attack(int dmg, Character who) {

        if (who.alive.equals(true) && this != who && !sameFaction(who)) {

            isInRange(dmg, who);
        } else {
            throw new ActionException("Cannot attack");
        }
    }

    public void heal(int heal, Character who) {
        if (alive && this == who || sameFaction(who)) {
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

        int rangeDiff = getRange().getRange() - who.getRange().getRange();
       switch (rangeDiff){
           case 18,0 -> damageBasedOnLevel(dmg, who);
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

    private void joinFaction(Character who,Faction faction){

        switch (faction){
            case OGRES -> who.setFactionsList(Collections.singletonList(Faction.OGRES));
            case HUMANS -> who.setFactionsList(Collections.singletonList(Faction.HUMANS));
            case UNDEAD -> who.setFactionsList(Collections.singletonList(Faction.UNDEAD));
            case ELFS -> who.setFactionsList(Collections.singletonList(Faction.ELFS));
            default ->
                throw new ActionException("No faction found.");
        }

    }

    private void leaveFaction(Character who,Faction faction){

        if (who.getFactionsList() != null){
        switch (faction){
            case OGRES, UNDEAD, HUMANS, ELFS -> who.setFactionsList(null);
            default ->
                    throw new ActionException("No faction found.");
        }}

    }

    private boolean sameFaction(Character who){
        if (getFactionsList().stream().anyMatch((Predicate<? super Faction>) who.getFactionsList())){
            return true;
        }
        return false;
    }


}
