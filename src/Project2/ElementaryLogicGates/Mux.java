package Project2.ElementaryLogicGates;

public class Mux {

    public boolean out;
    private And and1 = new And();
    private Or or1 = new Or();
    private And and2 = new And();
    private Not not = new Not();


    public void compute(boolean a, boolean b, boolean sel){
        not.compute(sel);
        and1.compute(a,not.out);
        and2.compute(b,sel);
        or1.compute(and1.out,and2.out);
        out=or1.out;
    }
}
