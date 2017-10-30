import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by serena on 30/10/2017.
 */
public class MainTest {

    /**
     * Test that a 2x2 box resembles this:
     *  ┌ ┐
     *  └ ┘
     */
    @Test
    public void makesquare() {
        String[][] box = Main.makebox(2,2);
        String[] col0 = {Character.toString('\u250C') +" ", Character.toString('\u2514') + " "}; // topleft, bottomleft
        String[] col1 = {Character.toString('\u2510') + " ", Character.toString('\u2518') + " "}; //topright, bottomright

        assertArrayEquals(col0, box[0]);
        assertArrayEquals(col1, box[1]);
    }

    /**
     * Test that a 3x4 box resembles this:
     *  ┌ ─ ─ ┐
     *  ╵     ╵
     *  └ ─ ─ ┘
     */
    @Test
    public void makerectangle() {
        String[][] box = Main.makebox(3,4);
        String[] col0 = {Character.toString('\u250C') +" ", Character.toString('\u2575') + " ", Character.toString('\u2514') + " "}; // topleft, pipe, bottomleft
        String[] col1 = {Character.toString('\u2500') + " ", "  ", Character.toString('\u2500') + " "}; //dash, whitespace, dash
        String[] col2 = {Character.toString('\u2500') + " ",  "  ", Character.toString('\u2500') + " "}; //dash, whitespace, dash
        String[] col3 = {Character.toString('\u2510') + " ", Character.toString('\u2575') + " ", Character.toString('\u2518') + " "}; //topright pipe, bottomright

        assertArrayEquals(col0, box[0]);
        assertArrayEquals(col1, box[1]);
        assertArrayEquals(col2, box[2]);
        assertArrayEquals(col3, box[3]);
    }



}