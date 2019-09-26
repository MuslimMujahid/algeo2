package algeo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//ADT MATRIKS
import java.util.Scanner;


public class Matriks {
    // {** CONSTANT **}
    final int BrsMin = 1;
    final int BrsMax = 100;
    final int KolMin = 1;
    final int KolMax = 100;

    // {** KONSTRUKTOR** }
	public double[][] Indeks;
	public int NBrsEff; //jumlah baris yang terdefinisi
	public int NKolEff; //jumlah kolom yang terdefinisi

	public Matriks(int NB, int NK) {
		this.NBrsEff = NB;
		this.NKolEff = NK;
		this.Indeks = new double[this.BrsMax+1][this.KolMax+1];
	}
	/* Membentuk sebuah MATRIKS "kosong" yang siap diisi berukuran NB x NK di "ujung kiri" memori */
	/* I.S. NB dan NK adalah valid untuk memori matriks yang dibuat */
	/* F.S. Matriks M sesuai dengan definisi di atas terbentuk */

	/* *** Selektor: Untuk sebuah matriks M yang terdefinisi: *** */
	public int GetFirstIdxBrs () {
		return this.BrsMin;
	}
	/* Mengirimkan indeks baris terkecil M */
	public int GetFirstIdxKol () {
		return this.KolMin;
	}
	/*Mengirimkan indeks kolom terkecil M*/
	public int GetLastIdxBrs () {
		return this.NBrsEff;
	}
	/*Mengirimkan indeks baris terbesar M*/
	public int GetLastIdxKol () {
		return this.NKolEff;
	}
	/*Mengirimkan indeks kolom terbesar M*/
	public int NBElmt() {
		return this.NBrsEff*this.NKolEff;
	}
	
	/* *** Baca-Tulis: Untuk sebuah matriks M yang terdefinisi: *** */
	public void BacaMatriks() {
		int NB = this.GetLastIdxBrs();
		int NK = this.GetLastIdxKol();
		Scanner Input = new Scanner(System.in);
		for (int i = 1; i <= NB; i++) {
			String[] Arr = ("0 " + Input.nextLine()).split(" ");
			for (int j = 1; j <= NK; j++) {
				this.Indeks[i][j] = Double.parseDouble(Arr[j]);
			}
		}

		Input.close();
	}
	// I.S : Matriks sembarang
	// Membaca matriks perbaris dengan tiap elemen diantarai spasi
	// F.S : Elemen matriks terdefinisi

	public void BacaFILEMatriks(String file) {
		BufferedReader reader; 

        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
			int i = 0;
			String[] Arr;
            while (line != null) {
				i++;
				this.NBrsEff += 1;
                Arr = ("0 " + line).split(" ");
				for (int j = 1; j <= Arr.length-1; j++) {
					this.Indeks[i][j] = Double.parseDouble(Arr[j]);
				}
				line = reader.readLine();
				this.NKolEff = Arr.length-1;
			}
			
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public static double roundAvoid(double value, int places) {
		double scale = Math.pow(10, places);
		return Math.round(value * scale) / scale;
	}

	public void TulisMatriks() {
		int NB = this.GetLastIdxBrs();
		int NK = this.GetLastIdxKol();
		for (int i = 1; i <= NB; i++) {
			System.out.print("| ");
			for (int j = 1; j <= NK; j++) {   
				System.out.printf("%.2f ",this.Indeks[i][j]);

			}
			System.out.printf(" |\n"); //membuat baris yang baru di akhir kolom matriks.
		}
	}
	public void CopyMatriks(Matriks M) {
	/* Menghasilkan keluaran berupa matriks dengan elemen, jumlah baris, dan jumlah kolom yang sama dengan matriks M */
		this.NBrsEff = M.NBrsEff;
		this.NKolEff = M.NKolEff;

		for ( int i = this.GetFirstIdxBrs(); i < this.GetLastIdxBrs() + 1; i++ ) {
			for ( int j = this.GetFirstIdxBrs(); j < this.GetLastIdxKol() + 1; j++ ) {
				this.Indeks[i][j] = M.Indeks[i][j];
			}
		}
	}
	// I.S : Matriks sembarang
	// F.S : Elemen matriks sama dengan elemen matriks M

	public static Matriks TambahMatriks (Matriks M1, Matriks M2) {
		int NB = M1.GetLastIdxBrs();
		int NK = M2.GetLastIdxKol();

		Matriks M = new Matriks(M1.NBrsEff,M1.NKolEff);
		for (int i = 1; i <= NB; i++) {
			for (int j = 1; j <= NK; j++) {
				M.Indeks[i][j] = roundAvoid(M1.Indeks[i][j] + M1.Indeks[i][j], 4);

			}
		}
		return M;
	}
	
	public static Matriks KurangMatriks (Matriks M1, Matriks M2) {
	/* Prekondisi : M berukuran sama dengan M */
	/* Mengirim hasil pengurangan matriks: salinan M1 – M2 */
		int NB = M1.GetLastIdxBrs();
		int NK = M1.GetLastIdxKol();

		Matriks M = new Matriks(NB,NK);
		for (int i = 1; i <= NB; i++) {
			for (int j = 1; j <= NK; j++) {
				M.Indeks[i][j] = roundAvoid(M1.Indeks[i][j] - M1.Indeks[i][j], 4);
			}
		}
		return M;
	}

	public double[] KurangRow (double[] R1, double[] R2) {

		for ( int i = 1; i < this.GetLastIdxKol() + 1; i++ ) {
			R1[i] = roundAvoid(R1[i] - R2[i], 4);
		}

		return R1;
	}

	public double[] TambahRow (double[] R1, double[] R2) {

		for ( int i = 1; i < this.GetLastIdxKol() + 1; i++ ) {
			R1[i] = roundAvoid(R1[i] - R2[i], 4);
		}

		return R1;
	}

	public static Matriks KaliMatriks(Matriks M1, Matriks M2) {
		Matriks M = new Matriks(M1.GetLastIdxBrs(), M1.GetLastIdxKol());
		double X = 0; /*sebagai counter untuk menjumlahkan hasil perkalian tiap elemen*/
		for (int i=M1.GetFirstIdxBrs();i<=M1.GetLastIdxBrs();i++) {
			for (int j=M2.GetFirstIdxKol();j<=M2.GetLastIdxKol();j++) {
				X=0;
				for (int k=M1.GetFirstIdxKol();k<=M1.GetLastIdxKol();k++) {
					X=roundAvoid(X+M1.Indeks[i][k]*M2.Indeks[k][j], 4); /*perkalian baris dengan kolom*/
				}
				M.Indeks[i][j] = X;
			}
		}
		return M;
	}
	// Mengembalikan hasil perkalian matriks M1 dan M2

	public Matriks Transpose () {

		Matriks T = this;
		double tmp = 0;
	
		for ( int i = T.GetFirstIdxBrs(); i < T.GetLastIdxBrs(); i++ ) {
			for ( int j = i + 1; j < T.GetLastIdxKol() + 1; j++ ) {
				tmp = T.Indeks[i][j];
				T.Indeks[i][j] = T.Indeks[j][i];  /* Pertukaran baris dengan kolom */
				T.Indeks[j][i] = tmp;
			}        
		}

		return T;
	}
	// Mengembalikan transpose dari matriks

	public Matriks MatriksMinor(int i, int j) {
		Matriks Mij = new Matriks(this.NBrsEff-1, this.NKolEff-1);

		int k = 1;
		int l = 1;
		for ( int m = this.GetFirstIdxBrs(); m < this.GetLastIdxBrs() + 1; m++ ) {
			for ( int n = this.GetFirstIdxKol(); n < this.GetLastIdxKol() + 1; n++ ) {
				if ( m != i && n != j ) {
					if ( l > Mij.GetLastIdxKol() ) {
						l = 1;
						k++;
					}
					Mij.Indeks[k][l] = this.Indeks[m][n];
					l++;
				}
			}
		}
		return Mij;
	}
	// Prekondisi : i dan j terdefinisi
	// Mengembalikan Matriks Minor baris i dan kolom j

	public Matriks UpTriangle() {

		Matriks M = new Matriks(this.NBrsEff,this.NKolEff);
		M.CopyMatriks(this);

		// Cek perkolom
		for ( int j = M.GetFirstIdxBrs(); j < M.GetLastIdxBrs() + 1; j++ ) {

			if ( M.Indeks[j][j] == 0 ) {

				for ( int a = j+1; a < M.GetLastIdxBrs()+1; a++ ) {
					if ( M.Indeks[a][j] != 0 ) {
						M.Indeks[j] = M.KurangRow(M.Indeks[j], M.Indeks[a]);
						break;
					}
				}
			}
			// Memastikan indeks j,j tidak bernilai 0

			// Cek perbaris
			for ( int i = j+1; i < M.GetLastIdxBrs() + 1; i++ ) {

				if ( M.Indeks[i][j] == 0 ) {
					continue;
				}

				double dvdr = M.Indeks[i][j]/M.Indeks[j][j];
				double[] RowDistract = new double[M.GetLastIdxKol()+1];
				for ( int k = M.GetFirstIdxBrs(); k < M.GetLastIdxBrs()+1; k++ ) {
					RowDistract[k] = M.Indeks[j][k] * dvdr;
				}
				M.Indeks[i] = M.KurangRow(M.Indeks[i], RowDistract);
			}
			// Operasi baris elementer
		}

		return M;
	}

	public double DeterminanGauss() {

		double det = 1;
		
		Matriks M = new Matriks(this.NBrsEff,this.NKolEff);
		M.CopyMatriks(this);
		M.CopyMatriks(M.UpTriangle());

		for ( int i = M.GetFirstIdxBrs(); i < M.GetLastIdxBrs() + 1; i++ ) {
			det *= M.Indeks[i][i];
		}

		return det;
	}

	public double DeterminanKofaktor() {

		if ( this.NBElmt() == 1) {
			return this.Indeks[1][1];
		} else if ( this.NBrsEff == 2 && this.NKolEff == 2 ) {
			return this.Indeks[1][1]*this.Indeks[2][2] - this.Indeks[1][2]*this.Indeks[2][1];
		} else {
			double det = 0;
			for ( int j = this.GetFirstIdxKol(); j < this.GetLastIdxKol() + 1; j++ ) {
				det += Math.pow(-1,1+j) * this.Indeks[1][j] * this.MatriksMinor(1,j).DeterminanKofaktor();
			}
			return det;
		}

	}
	// Prekondisi : Matriks terdefinisi dan persegi
	// proses : mencari determinan dengan menggunakan kofaktor
	// Mengembalikan nilai determinan dari matriks


	public Matriks MatriksKofaktor() {

		Matriks C = new Matriks(this.NBrsEff,this.NKolEff);

		for ( int i = this.GetFirstIdxBrs(); i < this.GetLastIdxBrs() + 1; i++ ) {
			for ( int j = this.GetFirstIdxKol(); j < this.GetLastIdxKol() + 1; j++ ) {
				// C.Indeks[i][j] = this.MatriksMinor(1,1).DeterminanKofaktor();
				C.Indeks[i][j] = (int)Math.pow(-1,i+j)* this.MatriksMinor(i,j).DeterminanKofaktor();
			}
		}

		return C;
	}
	// Prekondisi : Matriks terdefinisi
	// Mengembalikan matriks kofaktor dari matriks

	public Matriks Adjoin() {
		return this.MatriksKofaktor().Transpose();
	}
	// Prekondisi : Matriks terdefinisi
	// Mengembaikan adjoin dari matriks

	public Matriks InverseAdjoin() {

		double det = this.DeterminanKofaktor();
		Matriks Adj = this.Adjoin();
		Matriks Ai = new Matriks(this.NBrsEff,this.NKolEff);

		for ( int i = Ai.GetFirstIdxBrs(); i < Ai.GetLastIdxBrs() + 1; i++ ) {
			for ( int j = Ai.GetFirstIdxKol(); j < Ai.GetLastIdxKol() + 1; j++ ) {
				Ai.Indeks[i][j] = (1/det)*Adj.Indeks[i][j];
			}
		}

		return Ai;
	}
	// Prekondisi : Matriks terdefinisi
	// Mengembaikan inverse dari matriks

	public Matriks InverseGauss() {

		Matriks M = new Matriks(this.NBrsEff,this.NKolEff);
		M.CopyMatriks(this);

		// Membuat matriks identitas
		Matriks Inv = new Matriks(this.NBrsEff,this.NKolEff);
		for ( int i = Inv.GetFirstIdxBrs(); i < Inv.GetLastIdxBrs()+1; i++ ) {
			Inv.Indeks[i][i] = 1;
		}

		// Cek perkolom
		for ( int j = M.GetFirstIdxBrs(); j < M.GetLastIdxBrs(); j++ ) {

			if ( M.Indeks[j][j] == 0 ) {

				for ( int a = j+1; a < M.GetLastIdxBrs()+1; a++ ) {
					if ( M.Indeks[a][j] != 0 ) {
						M.Indeks[j] = M.KurangRow(M.Indeks[j], M.Indeks[a]);
						Inv.Indeks[j] = Inv.KurangRow(Inv.Indeks[j], Inv.Indeks[a]);
						break;
					}
				}
			}
			// Memastikan indeks j,j tidak bernilai 0

			// Cek perbaris
			for ( int i = j+1; i < M.GetLastIdxBrs() + 1; i++ ) {

				if ( M.Indeks[i][j] == 0 ) {
					continue;
				}

				double dvdr = M.Indeks[i][j]/M.Indeks[j][j];
				double[] RowDistract = new double[M.GetLastIdxKol()+1];
				double[] RowDistract2 = new double[M.GetLastIdxKol()+1];
				for ( int k = M.GetFirstIdxBrs(); k < M.GetLastIdxBrs()+1; k++ ) {
					RowDistract[k] = M.Indeks[j][k] * dvdr;
				}
				for ( int k = M.GetFirstIdxBrs(); k < M.GetLastIdxBrs()+1; k++ ) {
					RowDistract2[k] = Inv.Indeks[j][k] * dvdr;
				}
				M.Indeks[i] = M.KurangRow(M.Indeks[i], RowDistract);
				Inv.Indeks[i] = Inv.KurangRow(Inv.Indeks[i], RowDistract2);
			}
			// Operasi baris elementer
		}

		// Cek perkolom
		for ( int j = M.GetLastIdxBrs(); j > M.GetFirstIdxBrs(); j-- ) {

			if ( M.Indeks[j][j] == 0 ) {

				for ( int a = j-1; a > M.GetFirstIdxBrs()-1; a-- ) {
					if ( M.Indeks[a][j] != 0 ) {
						M.Indeks[j] = M.KurangRow(M.Indeks[j], M.Indeks[a]);
						Inv.Indeks[j] = Inv.KurangRow(Inv.Indeks[j], Inv.Indeks[a]);
						break;
					}
				}
			}
			// Memastikan indeks j,j tidak bernilai 0

			// Cek perbaris
			for ( int i = j-1; i > M.GetFirstIdxBrs() - 1; i-- ) {

				if ( M.Indeks[i][j] == 0 ) {
					continue;
				}

				double dvdr = M.Indeks[i][j]/M.Indeks[j][j];
				double[] RowDistract = new double[M.GetLastIdxKol()+1];
				double[] RowDistract2 = new double[M.GetLastIdxKol()+1];
				for ( int k = M.GetFirstIdxBrs(); k < M.GetLastIdxBrs()+1; k++ ) {
					RowDistract[k] = M.Indeks[j][k] * dvdr;
				}
				for ( int k = M.GetFirstIdxBrs(); k < M.GetLastIdxBrs()+1; k++ ) {
					RowDistract2[k] = Inv.Indeks[j][k] * dvdr;
				}
				M.Indeks[i] = M.KurangRow(M.Indeks[i], RowDistract);
				Inv.Indeks[i] = Inv.KurangRow(Inv.Indeks[i], RowDistract2);
			}
			// Operasi baris elementer
		}

		for ( int i = Inv.GetFirstIdxBrs(); i < Inv.GetLastIdxBrs()+1; i++ ) {
			for ( int j = Inv.GetFirstIdxKol(); j < Inv.GetLastIdxKol()+1; j++ ) {
				Inv.Indeks[i][j] = Inv.Indeks[i][j]/M.Indeks[i][i];
			}
		}

		return Inv;
		
	}

	public Matriks MatriksA() {

		Matriks MA = new Matriks(this.NBrsEff, this.NKolEff-1);
		for ( int i = MA.GetFirstIdxBrs(); i < MA.GetLastIdxBrs() + 1; i++ ) {
			for (int j = MA.GetFirstIdxKol(); j < MA.GetLastIdxKol() + 1; j++ ) {
				MA.Indeks[i][j] = this.Indeks[i][j];
			}
		}

		return MA;
	}
	// Prekondisi : Matriks terdefinisi merepresentasikan matriks [A | B]
	// Mengembalikan nilai matriks A 

	public Matriks MatriksB() {

		Matriks MB = new Matriks(this.NBrsEff, 1);
		for ( int i = MB.GetFirstIdxBrs(); i < MB.GetLastIdxBrs() + 1; i++ ) {
			MB.Indeks[i][1] = this.Indeks[i][this.GetLastIdxBrs()+1];
		}
		return MB;
	}
	// Prekondisi : Matriks terdefinisi merepresentasikan matriks [A | B]
	// Mengembalikan nilai matriks B

	public void SPLtoMatriks(SPL SP) {

        for ( int i = SP.GetFirstIdx(); i < SP.NPL + 1; i++ ) {
            for ( int j = SP.GetFirstIdx(); j < SP.GetNmax() + 1; j++ ) {
                this.Indeks[i][j] = SP.GetPLn(i).GetAn(j);
			}
            this.Indeks[i][SP.GetNmax()+1] = SP.GetPLn(i).GetB();			
		}
	}
	// Mengembalikan Sistem Persamaan Linier SP dalam bentuk matriks

	// ***** Penyelesaian SPL dengan Eliminasi Gauss ******
	public Matriks GaussElimination() {

		Matriks M = new Matriks(this.NBrsEff,this.NKolEff);
		M.CopyMatriks(this);

		int b = 0;
		// Cek perkolom
		for ( int j = M.GetFirstIdxKol(); j-b < M.GetLastIdxBrs()-1; j++ ) {

			if ( M.Indeks[j-b][j] == 0 ) {

				for ( int a = j+1-b; a < M.GetLastIdxBrs()+1; a++ ) {
					if ( M.Indeks[a][j] != 0 ) {
						M.Indeks[j] = M.KurangRow(M.Indeks[j], M.Indeks[a]);
						break;
					}
				}

				if ( M.Indeks[j-b][j] == 0 ) {
					b++;
					continue;
				}
			}
			// Memastikan indeks j,j tidak bernilai 0

			// Cek perbaris
			for ( int i = j+1-b; i < M.GetLastIdxBrs() + 1; i++ ) {

				if ( M.Indeks[i][j] != 0 ) {
					double dvdr = M.Indeks[i][j]/M.Indeks[j-b][j];
					double[] RowDistract = new double[M.GetLastIdxKol()+1];
					for ( int k = M.GetFirstIdxKol(); k < M.GetLastIdxKol()+1; k++ ) {
						RowDistract[k] = M.Indeks[j-b][k] * dvdr;
					}
					M.Indeks[i] = M.KurangRow(M.Indeks[i], RowDistract);
				}
			}
			// Operasi baris elementer
		}

		double dvdr;
		for ( int i = M.GetFirstIdxBrs(); i < M.GetLastIdxBrs() + 1; i++ ) {
			for ( int j = M.GetFirstIdxKol(); j < M.GetLastIdxKol() + 1; j++ ) {
				if ( M.Indeks[i][j] != 0 ) {
					dvdr = M.Indeks[i][j];

					for ( int k = j; k < M.GetLastIdxKol() + 1; k++ ) {
						M.Indeks[i][k] = roundAvoid(M.Indeks[i][k]/dvdr, 4);
					}

					break;
				}
			}
		}

		return M;

	}

	public Matriks GaussJordanElimination() {
		Matriks M = new Matriks(this.NBrsEff,this.NKolEff);
		M.CopyMatriks(this.GaussElimination()); 

		for ( int i = M.GetLastIdxBrs(); i > M.GetFirstIdxBrs(); i-- ) {
			for ( int j = M.GetFirstIdxKol(); j < M.GetLastIdxKol() + 1; j++ ) {
				if ( M.Indeks[i][j] != 0 ) {
					for ( int k = i-1; k > M.GetFirstIdxBrs()-1; k-- ) {
						if ( M.Indeks[k][j] != 0 ) {
							double dvdr = roundAvoid(M.Indeks[k][j]/M.Indeks[i][j], 4);
							double[] RowDistract = new double[M.GetLastIdxKol()+1];
							for ( int l = M.GetFirstIdxKol(); l < M.GetLastIdxKol()+1; l++ ) {
								RowDistract[l] = roundAvoid(M.Indeks[i][l] * dvdr, 4);
							}
							M.Indeks[k] = M.KurangRow(M.Indeks[k], RowDistract);
						}
					}
					break;
				}
			}
		}

		double dvdr;
		for ( int i = M.GetFirstIdxBrs(); i < M.GetLastIdxBrs() + 1; i++ ) {
			for ( int j = M.GetFirstIdxKol(); j < M.GetLastIdxKol() + 1; j++ ) {
				if ( M.Indeks[i][j] != 0 ) {
					dvdr = M.Indeks[i][j];

					for ( int k = j; k < M.GetLastIdxKol() + 1; k++ ) {
						M.Indeks[i][k] = roundAvoid(M.Indeks[i][k]/dvdr, 4);
					}

					break;
				}
			}
		}

		return M;
	}

	// ***** Penyelesaian SPL dengan Eliminasi Gauss ******
	public void SPLGauss(SPL SP) {

		Matriks M = new Matriks(SP.GetNPL(),SP.GetNmax()+1);
		M.SPLtoMatriks(SP);
		M = M.GaussElimination();

		double[] result = new double[SP.GetNmax()+1];

		if ( SP.GetNPL() > SP.GetNmax() ) {
			for ( int i = SP.GetNmax(); i < SP.GetNPL()+1; i++ ) {
				M.Indeks[SP.GetNmax()] = M.TambahRow(M.Indeks[SP.GetNmax()], M.Indeks[i]); 
				M.NBrsEff -= 1;
			}
		}

		if ( M.DeterminanGauss() != 0 && M.NBrsEff == M.NKolEff-1) {

			for ( int i = M.GetLastIdxBrs(); i > M.GetFirstIdxBrs()-1; i-- ) {
				result[i] = M.Indeks[i][SP.GetNmax()+1];
				for ( int j = M.GetLastIdxKol()-1; j > M.GetFirstIdxKol()-1; j-- ) {
					if ( j != i ) {
						result[i] -= M.Indeks[i][j]*result[j];
					}
				}
			}

			for ( int i = M.GetFirstIdxBrs(); i < M.GetLastIdxBrs()+1; i++ ) {
				System.out.printf("x%d : %.2f\n",i,result[i]);
			}

		} else {

			System.out.println("Sistem tidak memiliki solusi");

		}
	}

	public boolean IsIdentitas() {
		int i = GetFirstIdxBrs()-1;
		int j = GetFirstIdxKol()-1;

		do {
			j = GetFirstIdxKol()-1;
			do {
				j++;
			} while ( (i == j && this.Indeks[i][j] == 1) || (i != j && this.Indeks[i][j] == 0) && j < this.GetLastIdxKol()+1);
			i++;
		} while ( (i == j && this.Indeks[i][j] == 1) || (i != j && this.Indeks[i][j] == 0) && i < this.GetLastIdxBrs()+1);

		return ( (i == j && this.Indeks[i][j] == 1) || (i != j && this.Indeks[i][j] == 0) );
	}

	public boolean IsRowZero(int i) {
		int j = GetFirstIdxKol()-1;

		do {
			j++;
		} while ( this.Indeks[i][j] == 0 && j < this.GetLastIdxKol()+1 );

		return ( this.Indeks[i][j] == 0 );
	}

	// ***** Penyelesaian SPL dengan Eliminasi Gauss-Jordan ******
	public void SPLGaussJordan(SPL SP) {

		Matriks M = new Matriks(SP.GetNPL(),SP.GetNmax()+1);
		M.SPLtoMatriks(SP);
		M = M.GaussJordanElimination();
		char[] FreeVar = new char[SP.GetNmax()+1];
		for ( int i = 0; i < SP.GetNmax()+1; i++ ) {
			FreeVar[i] = 'a';
		}
		char[] ch = {'s','t','u','v','w','x','y','z'};

		if ( SP.GetNPL() > SP.GetNmax() ) {
			for ( int i = SP.GetNmax(); i < SP.GetNPL()+1; i++ ) {
				M.Indeks[SP.GetNmax()] = M.TambahRow(M.Indeks[SP.GetNmax()], M.Indeks[i]); 
				M.NBrsEff -= 1;
			}
		}

		if ( (M.NBrsEff != M.NKolEff) || (M.NBrsEff == M.NKolEff && M.DeterminanGauss() != 0) ) {
			int a = 1;
			int c = 0;
			for ( int j = M.GetFirstIdxKol(); j < M.GetLastIdxKol(); j++ ) {
				if ( M.Indeks[a][j] != 1 ) {
					FreeVar[j] = ch[c];
					c++;
				} else {
					a++;
				}
			}

			for ( int i = M.GetFirstIdxBrs(); i < M.GetLastIdxBrs()+1; i++ ) {
				if (!M.IsRowZero(i)) {
					for ( int j = M.GetFirstIdxKol(); j < M.GetLastIdxKol(); j++ ) {
						if ( M.Indeks[i][j] == 1 ) {
							System.out.printf("x%d = ",j);
							if ( M.Indeks[i][M.GetLastIdxKol()] != 0 ) {
								System.out.printf("%.2f",M.Indeks[i][M.GetLastIdxKol()]);
							}
							for ( int k = j+1; k < M.GetLastIdxKol(); k++ ) {
								if ( M.Indeks[i][k] != 0 ) {
									if ( M.Indeks[i][k] < 0 ) {
										if ( M.Indeks[i][M.GetLastIdxKol()] != 0 ) {
											System.out.printf("+%.2f%c",M.Indeks[i][k],FreeVar[k]);
										} else {
											System.out.printf("%.2f%c",M.Indeks[i][k],FreeVar[k]);
										}
										c++;
									} else {
										System.out.printf("%.2f%c",M.Indeks[i][k],FreeVar[k]);
										c++;
									}
								}
							}
							System.out.println();
							break;
						}
					}
				}
			}
		} else {
			System.out.println("Sistem tidak memiliki solusi");
		}

	}

    // ***** Penyelesaian SPL dengan inverse ******
	public void SPLInverse(SPL SP) {
		
		if ( this.MatriksA().NBrsEff == this.MatriksA().NKolEff && this.MatriksA().DeterminanGauss() != 0 ) {
			Matriks MatriksX = new Matriks(SP.GetNPL(),1);
			MatriksX = KaliMatriks(this.MatriksA().InverseAdjoin(), this.MatriksB());
			for ( int i = MatriksX.GetFirstIdxBrs(); i < MatriksX.GetLastIdxBrs() + 1; i++ ) {
				System.out.printf("x%d : %.2f\n",i,MatriksX.Indeks[i][1]);
			}
		} else {
			System.out.println("Sistem tidak memiliki solusi");
		}

		
	}
	// Menyelesaikan Sistem Persamaaan Linier dengan menggunakan metode inverse
	// dan menampilkan hasilnya dalam format x<n> : <hasil>

	// ***** Penyelesaian SPL dengan kaidah cramer ******
	public double Cramer(int kolom, Matriks persamaan, Matriks hasil) {
		Matriks copy = new Matriks(persamaan.NBrsEff,persamaan.NKolEff);
		copy.CopyMatriks(persamaan);
		int NB = persamaan.GetLastIdxBrs();
    	for (int i = 1; i <= NB; i++) {
				copy.Indeks[i][kolom] = hasil.Indeks[i][1];
		}
		return (copy.DeterminanKofaktor()/persamaan.DeterminanKofaktor());
	}
	// Mengembalikan hasil dari x<kolom>

	public void SPLCramer(SPL SP) {
		Matriks M = new Matriks(SP.GetNPL(),SP.GetNmax()+1);
		M.SPLtoMatriks(SP);

		if ( M.NBrsEff == M.NKolEff && M.DeterminanGauss() != 0 ) {
			for ( int j = M.GetFirstIdxKol(); j < M.GetLastIdxKol(); j++ ) {
				System.out.printf("x%d : %.2f\n",j,Cramer(j, M.MatriksA(), M.MatriksB()));
			}
		} else {
			System.out.println("Sistem tidak memiliki solusi");
		}
		
	}
	// Menyelesaikan Sistem Persamaaan Linier dengan menggunakan kaidah cramer
	// dan menampilkan hasilnya dalam format x<n> : <hasil>

	public void InterPolasiPolinom(SPL SP) {
		Matriks M = new Matriks(SP.GetNPL(),SP.GetNmax()+1);
		M.SPLtoMatriks(SP);
		M.GaussJordanElimination().TulisMatriks();
	}
}
