package ca.bcit.comp2522.labs.lab01;

/**
 * Tortoise.
 *
 * @author Ben Jones
 * @version 1
 *
 *  represents a tortoise.
 *  used by Driver via Race class
 *  Contains: move, setPos, getPos
 *
 */

import java.util.Random;

public class Tortoise {
    /** Tortoises position in the race**/
    public int pos = 0;

    /**
     * move.
     *
     * @return pos
     *
     * randomly generates number and uses it to determine the
     * behavior of the tortoise during that turn
     */
    public int move() {
        Random rand = new Random();
        int num = rand.nextInt(10 - 1 + 1) + 1;
        if (num <= 5) {
            pos += 3;
        } else if (num > 5 && num <= 7) {
            pos -= 6;
        } else {
            pos += 1;
        }
        return pos;
    }

    public int getPos() {
        return this.pos;
    }

    public void setPos(int num) {
        this.pos = num;
    }

}
