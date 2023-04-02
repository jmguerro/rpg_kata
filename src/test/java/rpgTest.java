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


}
