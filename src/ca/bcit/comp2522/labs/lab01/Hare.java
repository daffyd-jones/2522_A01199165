package ca.bcit.comp2522.labs.lab01;

/**
 * Hare.
 *
 * @author Ben Jones
 * @version 1
 *
 *  used by Driver via Race
 *  Contains: move, getPos and setPos
 */

import java.util.Random;

public class Hare {

    /** hares position**/
    public int pos = 0;

    /**
     * move.
     *
     *  uses random number to determine the hares behavior
     */
    public void move(){
        Random rand = new Random();
        int num = rand.nextInt(10 - 1 + 1) + 1;
        if (num < 3) {
            pos += 0;
        } else if (num == 3) {
            pos += 9;
        } else if (num == 4) {
            pos -= 12;
        } else if (num >= 5 && num <= 7) {
            pos += 1;
        } else if(num <= 8) {
            pos -= 2;
        }


    }

    /**
     * getPos.
     *
     * @return pos
     */
    public int getPos(){
        return this.pos;
    }

    /**
     * setPos.
     *
     * @param num
     */
    public void setPos(int num){
        this.pos = num;
    }




}
