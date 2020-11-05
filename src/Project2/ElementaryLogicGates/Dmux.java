package Project2.ElementaryLogicGates;

public class Dmux {

    public boolean a;
    public boolean b;
    private And and1 = new And();
    private Not not = new Not();
    private And and2 = new And();

    public void compute(boolean in, boolean sel){
        not.compute(sel);
        and1.compute(in,not.out);
        a=and1.out;
        and2.compute(in,sel);
        b=and2.out;
    }
}
