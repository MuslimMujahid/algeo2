package algeo;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);

        // int m = Input.nextInt();
        // int n = Input.nextInt();

        // SPL SP = new SPL();
        // Matriks MSP = new Matriks(m,n+1);
        
        // SP.BacaSPL(m, n);
 
        // MSP.SPLtoMatriks(SP);

        // MSP.GaussJordanElimination().TulisMatriks();;

        Garis G = new Garis(0);
        G.InterpolasiPolinom();

    }
    
}