package Project2.Adders;

import Project2.ElementaryLogicGates.And;
import Project2.ElementaryLogicGates.Xor;

public class HalfAdder {
    public boolean sum;
    public boolean carry;
    private Xor xor = new Xor();
    private And and = new And();

    public void compute(boolean a, boolean b){
        xor.compute(a,b);
        and.compute(a,b);
        sum = xor.out;
        carry = and.out;
    }

}
