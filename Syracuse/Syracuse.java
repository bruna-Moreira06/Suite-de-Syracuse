import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Syracuse {
    public static void main(String[] args){
        String n = args[0];
        int b = Integer.parseInt(n);
        try{
            FileWriter fw=new FileWriter("f" + b + ".dat");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("n Un");
            bw.newLine();
            syracuse(0,b,bw);
            bw.newLine();
            temps_de_vol(b,bw);
            bw.close();
        }catch (Exception e) {
            System.out.println("Erreur " + e);
        }
    }
//    -----Écrire une fonction Collatz calculant la valeur de la fonction f(x) sur son argument x.
    public static int collatz(int x) {
        if (x % 2 == 0) {
            return x / 2;
        } else {
            return 3 * x + 1;
        }
    }
    //    Écrire une procédure (un fonction ne renvoyant pas de résultat) récursive Syracuse qui
//calcule les itérations successives de la fonction de Collatz sur un entier donné en argument,
//jusqu’à trouver 1.
    public static boolean syracuse(int n,int y, BufferedWriter bw) throws IOException {
        bw.write(Integer.toString(n)+ " " + Integer.toString(y));
        while (y != 1) {
            n++;
            bw.newLine();
            y = collatz(y);
            bw.write(Integer.toString(n) + " "+ Integer.toString(y));
        }
        return false;
    }
    public static boolean temps_de_vol(int n, BufferedWriter bw) throws IOException {
        int cpt =0;
        int v=0;
        while(n!=1){
            cpt ++;
            n=collatz(n);
            if(v<(n)){
                v=n;
            }
        }
        bw.newLine();
        bw.write("altimax:"+ v);
        bw.newLine();
        bw.write("dureevol:" + cpt);
        return false;
    }
}

