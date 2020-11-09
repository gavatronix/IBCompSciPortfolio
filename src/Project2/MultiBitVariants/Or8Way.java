package Project2.MultiBitVariants;


import Project2.ElementaryLogicGates.Or;

public class Or8Way {
    public boolean out;
    private Or[] ors = new Or[7];

    public Or8Way(){
        for (int i = 0; i < ors.length; i++) {
            ors[i] = new Or();
        }
    }

    public void compute(boolean[] in){
        ors[0].compute(in[0],in[1]);
        ors[1].compute(in[2],in[3]);
        ors[2].compute(in[4],in[5]);
        ors[3].compute(in[6],in[7]);
        ors[4].compute(ors[0].out,ors[1].out);
        ors[5].compute(ors[2].out,ors[3].out);
        ors[6].compute(ors[4].out,ors[5].out);
        out = ors[6].out;
    }

}
