package algeo;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

    public void BacaFILESPL(String file) {

        BufferedReader reader; 

        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            int i = 0;
            while (line != null) {
                i++;
                this.NPL += 1;
                this.PLs[i].BacaFILEPL(line);
                if ( this.PLs[i].Na > this.Nmax ) {
                    this.Nmax = this.PLs[i].Na;
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void BacaPersamaanInterpolasi(int n) {

        Scanner Input = new Scanner(System.in);

        Matriks M = new Matriks(n+1,n+2);
        this.NPL = n+1;
        this.Nmax = n+1;

        for ( int i = 1; i < this.GetNPL(); i++ ) {
            double x = Input.nextDouble();
            double y = Input.nextDouble();
            for ( int j = 1; j < this.GetNmax()+1; j++ ) {
                this.PLs[i].a[j] = Math.pow(x,j-1);
            }
            this.PLs[i].b = y;
        }
    }

    public void BacaPersamaanInterpolasiFILE(String file) {
        
        BufferedReader reader; 
        BufferedReader reader2; 

        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            this.NPL += 1;
            while (line != null) {
                this.NPL += 1;
                line = reader.readLine();
			}
			
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.Nmax = this.NPL;

        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            
            int i = 1;
            while (line != null) {
                i++;
				String[] Arr = line.split(" "); 
                double x = Double.parseDouble(Arr[0]);
                double y = Double.parseDouble(Arr[1]);
                for ( int j = 1; j <= this.GetNPL()+1; j++ ) {
                    this.PLs[i].a[j] = Math.pow(x,j-1);
                }
                this.PLs[i].b = y;
                line = reader.readLine();
			}
			
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
