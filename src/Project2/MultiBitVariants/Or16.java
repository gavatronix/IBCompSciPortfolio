package Project2.MultiBitVariants;
import Project2.ElementaryLogicGates.Or;

public class Or16 {
    public boolean[] out = new boolean[16];
    private Or[] ors = new Or[16];

    public Or16() {
        for (int i = 0; i < ors.length; i++) {
            ors[i] = new Or();
        }
    }

    public void compute(boolean[] a,boolean[] b){
        for (int i = 0; i < a.length; i++) {
            ors[i].compute(a[i],b[i]);
            out[i] = ors[i].out;
            System.out.println(a);
        }
    }
}
