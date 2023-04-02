import org.junit.jupiter.api.Test;
import rpg.Character;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void attackTest(){

        //Given
        Character test = new Character(1000,1,true);
        Character test2 = new Character(60,1,true);
        //When
        test.attack(50,test2);

        //Then
        assertEquals(10,test2.getHp());
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




}
