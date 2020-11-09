package Project2.MultiBitVariants;
import Project2.ElementaryLogicGates.Mux;

public class Mux16 {
    public boolean[] out = new boolean[16];
    private Mux[] muxs = new Mux[16];

    public Mux16() {
        for (int i = 0; i < out.length; i++) {
            muxs[i] = new Mux();
        }
    }

    public void compute(boolean[] a,boolean[] b,boolean[] sel){
        for (int i = 0; i < a.length; i++) {
            muxs[i].compute(a[i],b[i],sel[i]);
            out[i] = muxs[i].out;
        }
    }
}

