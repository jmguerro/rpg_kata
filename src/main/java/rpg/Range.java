package rpg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public enum Range {

    MEELE(2),
    RANGE(20);

    private int range;
    private Range(int i){
        range = i;
    }

    public int getRange() {
        return range;
    }
}
