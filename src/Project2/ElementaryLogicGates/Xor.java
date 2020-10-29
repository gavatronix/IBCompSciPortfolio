package Project2.ElementaryLogicGates;

public class Xor {
    public boolean out;
    private Or or = new Or();
    private Nand nand = new Nand();
    private And and = new And();

    public void compute(boolean a, boolean b){
        or.compute(a,b);
        nand.compute(a,b);
        and.compute(or.out,nand.out);
        out = and.out;
    }
}
