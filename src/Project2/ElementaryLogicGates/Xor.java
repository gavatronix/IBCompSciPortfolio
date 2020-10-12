package Project2.ElementaryLogicGates;

public class Xor {
    public boolean out;
    private Or or;
    private Nand nand;
    private And and;

    public void compute(boolean a, boolean b){
        or.compute(a,b);
        nand.compute(a,b);
        and.compute(or.out,nand.out);
        out = and.out;
    }
}
