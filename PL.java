package algeo;
import java.math.BigDecimal;
import java.util.Scanner;

public class PL {

    // CONSTANT
    private final int IdxMin = 1;
    private final int IdxMax = 100;

    public int Na;
    public BigDecimal[] a;
    public BigDecimal b;

    // Konstruktor
    public PL() {
        this.Na = 0;
        this.b = BigDecimal.ZERO;
        this.a = new BigDecimal[this.IdxMax+1];
    }

    // Selektor
    private int GetFirstIdx() {
        return this.IdxMin;
    }

    private int GetLastIdx() {
        return this.Na;
    }

    public BigDecimal GetB() {
        return this.b;
    }

    public BigDecimal[] GetA() {
        return this.a;
    }

    public BigDecimal GetAn(int num) {
        return this.a[num];
    }

    public int GetNa() {
        return this.Na;
    }

    public void BacaPL(int n) {

        Scanner Input = new Scanner(System.in);

        String[] StrPL = ("0 " + Input.nextLine()).split(" ");

        for ( int i = this.GetFirstIdx(); i < n + 1; i++ ) {
            this.a[i] = new BigDecimal(StrPL[i]);
        }
        this.b = new BigDecimal(StrPL[n+1]);
        this.Na = n;
    }
    // Membaca sebuah persamaan dengan n variabel dengan nilai koefisien diantarai spasi dan b(hasil)
    // pada input terakhir
    // contoh : untuk 3x1+4x3-5x4 = 10 maka inputnya menjadi 3 0 4 -5 10

    public void BacaFILEPL(String StrPL) {
        String[] Arr = ("0 " + StrPL).split(" ");
        int n = Arr.length-2;
        for ( int i = this.GetFirstIdx(); i < n+1; i++ ) {
            this.a[i] = new BigDecimal(Arr[i]);
        }
        this.b = new BigDecimal(Arr[n+1]);
        this.Na = n;
    }
}