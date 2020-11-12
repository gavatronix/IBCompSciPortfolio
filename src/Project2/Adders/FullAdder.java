package Project2.Adders;

import Project2.ElementaryLogicGates.And;
import Project2.ElementaryLogicGates.Or;
import Project2.ElementaryLogicGates.Xor;

public class FullAdder {

    public boolean sum;
    public boolean carry;
    private Xor[] xors = new Xor[2];
    private And[] ands = new And[2];
    private Or or = new Or();

    public FullAdder() {
        for (int i = 0; i < xors.length; i++) {
            xors[i] = new Xor();
            ands[i] = new And();
        }
    }

    public void compute(boolean a, boolean b, boolean c){
        xors[0].compute(a,b);
        xors[1].compute(xors[0].out,c);
        sum = xors[1].out;
        ands[0].compute(xors[0].out,c);
        ands[1].compute(a,b);
        or.compute(ands[0].out,ands[1].out);
        carry = or.out;

    }
}
