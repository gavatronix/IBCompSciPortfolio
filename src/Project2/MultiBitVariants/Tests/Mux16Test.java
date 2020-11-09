package Project2.MultiBitVariants.Tests;

import Project2.MultiBitVariants.Mux16;
import Project2.Tools.BMath;
import org.junit.Test;

import static org.junit.Assert.*;

public class Mux16Test {

    @Test
    public void compute() {
        Mux16 mux16 = new Mux16();

        boolean[] a = BMath.stringToBooleanArray("1111111111111111");
        boolean[] b = BMath.stringToBooleanArray("0000000000000000");
        boolean[] sel = BMath.stringToBooleanArray("1111111110000000");

        mux16.compute(a,b,sel);
        boolean[] expected = BMath.stringToBooleanArray("0000000001111111");
        assertArrayEquals(expected,mux16.out);

    }
}