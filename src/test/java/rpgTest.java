import org.junit.jupiter.api.Test;
import rpg.Character;
import rpg.exception.ActionException;

import static org.junit.jupiter.api.Assertions.*;

public class rpgTest {


    @Test
    void hpWhenCreatedIs1000(){

        //Given
        Character test = new Character(1000,1,true);
        //When

        //Then
        assertEquals(1000,test.getHp());
    }

    @Test
    void lvlWhenCreatedIs1(){

        //Given
        Character test = new Character(1000,1,true);
        //When

        //Then
        assertEquals(1,test.getLevel());
    }


    @Test
    void aliveWhenCreatedIsAlive(){

        //Given
        Character test = new Character(1000,1,true);
        //When

        //Then
        assertEquals(true,test.getAlive());
    }

    @Test
    void attackTestNoLvlDiff(){

        //Given
        Character attacker = new Character(1000,1,true);
        Character car = new Character(60,2,true);
        //When
        attacker.attack(50,car);

        //Then
        assertEquals(10,car.getHp());
    }

    @Test
    void attackTestLvlDiffDonw4(){

        //Given
        Character attacker = new Character(1000,6,true);
        Character car = new Character(60,1,true);
        //When
        attacker.attack(10,car);

        //Then
        assertEquals(45,car.getHp());
    }

    @Test
    void attackTestLvlDiffUp4(){

        //Given
        Character attacker = new Character(1000,1,true);
        Character car = new Character(60,6,true);
        //When
        attacker.attack(10,car);

        //Then
        assertEquals(55,car.getHp());
    }

    @Test
    void isChar2Alive(){

        //Given
         Character test = new Character(1000,1,true);
        Character test2 = new Character(50,1,true);
        //When
        test.attack(50,test2);

        //Then
        assertEquals(false,test2.getAlive());
    }

    @Test
    void damageWhenNotAlive(){
        //Given
        Character test = new Character(100,1,true);
        Character test2 = new Character(0,1,false);
        //When

        //Then
        assertThrows(ActionException.class,() ->   test.attack(50,test2));
    }

    @Test
    void damageToSelf(){
        //Given
        Character test2 = new Character(1000,1,true);
        //When

        //Then
        assertThrows(ActionException.class,() ->   test2.attack(50,test2));
    }

    @Test
    void healWhenAlive(){
        //Given

        Character test2 = new Character(10,1,true);
        //When
        test2.heal(50,test2);
        //Then
        assertEquals(60,test2.getHp());
        assertEquals(true,test2.getAlive());
    }

    @Test
    void healWhenAliveLimit1000(){
        //Given

        Character test2 = new Character(1000,1,true);
        //When
        test2.heal(50,test2);
        //Then
        assertEquals(1000,test2.getHp());
        assertEquals(true,test2.getAlive());
    }

    @Test
    void healWhenNotAlive(){
        //Given

        Character test2 = new Character(0,1,false);
        //When
        //Then
        assertThrows(ActionException.class,() -> test2.heal(50,test2));
    }

    @Test
    void healFromSomeoneelse(){
        //Given
        Character test = new Character(100,1,true);
        Character test2 = new Character(10,1,true);
        //When

        //Then
        assertThrows(ActionException.class,() -> test.heal(50,test2));
    }

    @Test
    void damageBasedOnLevelLevelBehing(){
        //Given
        Character test = new Character(100,1,true);
        Character test2 = new Character(10,1,true);
        //When

        //Then
        assertThrows(ActionException.class,() -> test.heal(50,test2));
    }


    @Test
    void damageBasedOnBonusLevelAhead(){
        //Given
        Character test = new Character(100,1,true);
        Character test2 = new Character(10,1,true);
        //When

        //Then
        assertThrows(ActionException.class,() -> test.heal(50,test2));
    }


}
