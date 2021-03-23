package POTW2;

public class Main {
    public static void main(String args[]){
        //B
        char[] S = {'P','S','E','U','D','O','C','O','D','E'};
        System.out.println(S.length);

        //C
        char[] UPPERCASELETTERS = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','W','X','Y','Z'};
        int n = 5;

        char[] SUBSTITUTE = new char[UPPERCASELETTERS.length];
        for (int i = 0; i < UPPERCASELETTERS.length; i++) {
            if (n<UPPERCASELETTERS.length){
                SUBSTITUTE[i] = UPPERCASELETTERS[n];
            } else {
                SUBSTITUTE[i] = UPPERCASELETTERS[UPPERCASELETTERS.length-n];
            }
            n++;
        }
        for (int i = 0; i < SUBSTITUTE.length; i++) {
            System.out.println(SUBSTITUTE[i]);
        }
    }
}
