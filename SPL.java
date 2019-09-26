package algeo;
import java.util.Arrays;
import java.util.Scanner;

public class SPL {

    // CONSTANT
    private final int IdxMin = 1;
    private final int IdxMax = 100;

    protected int NPL;
    protected int Nmax;
    protected PL[] PLs;

    // KONSTRUKTOR
    public SPL() {
        this.NPL = 0;
        this.Nmax = 0;
        this.PLs = new PL[this.IdxMax+1];

        for ( int i = this.IdxMin; i < this.IdxMax + 1; i++ ) {
            this.PLs[i] = new PL();
        }
    }

    // SELEKTOR
    public int GetFirstIdx() {
        return this.IdxMin;
    }
    // Mengembalikan index tekecil

    public int GetLastIdx() {
        return this.NPL;
    }
    // Mengembalikan indeks efektif terbesar

    public int GetNPL() {
        return this.NPL;
    }
    // Mengembalikan banyaknya persamaan dalam sistem

    public int GetNmax() {

        if ( this.Nmax  == 0 ) {
            for ( int i = this.IdxMin; i < this.NPL + 1; i++ ) {
                if ( this.PLs[i].Na > this.Nmax ) {
                    this.Nmax = this.PLs[i].Na;
                }
            }
        }
        return this.Nmax;
    }
    // Untuk tiap variabel x1,x2,...,xn mengembalikan n dengan nilai tertinggi

    public PL[] GetPLs() {
        return this.PLs;
    }
    // Mengembalikan array persamaan linear sistem

    public PL GetPLn(int n) {
        return this.PLs[n];
    }
    // Mengembalikan persamaan linier ke-n dalam sistem

    // BACA DAN TULIS
    public void BacaSPL(int m, int n) {

        for ( int i = this.GetFirstIdx(); i < m + 1; i++ ) {
            this.PLs[i].BacaPL(n);
        }
        this.NPL = m;
        this.Nmax = n;
    }
    // Membaca m persamaan dengan n variabel
}
