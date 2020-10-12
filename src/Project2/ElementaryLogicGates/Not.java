package Project2.ElementaryLogicGates;

public class Not {
    public boolean out;
    private Nand nand1;

    public void compute(boolean in){
        nand1.compute(in,in);
        out = nand1.out;
    }

}
