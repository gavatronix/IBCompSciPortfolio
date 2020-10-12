package Project2.ElementaryLogicGates;

public class Or {

    public boolean out;
    private Nand nand;
    private Not not1;
    private Not not2;

    public void compute(boolean a, boolean b){
        not1.compute(a);
        not1.compute(b);
        nand.compute(not1.out, not2.out);
        out = nand.out;
    }

}
