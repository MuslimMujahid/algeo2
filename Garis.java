package algeo;
import java.util.Scanner;

import java.lang.Math;

public class Garis {
    // {** KONSTRUKTOR** }
	private Point[] P;
	private int NP;

	public Garis (int m) {
		this.P = new Point[m+1];
		this.NP = m;

		for ( int i = 0; i < this.NP+1; i++ ) {
			this.P[i] = new Point();
		}
	}

	public Point GetPoint(int i) {
		return this.P[i];
	}

	/*Membaca input Garis*/
	void BacaGaris() {
		Scanner Input = new Scanner(System.in);
		for ( int i = 1; i < this.NP+1; i++ ) {
			int x = Input.nextInt();
			int y = Input.nextInt();
			this.P[i].BacaPoint(x, y);
		}
	}


	void InterpolasiPolinom() {

		Scanner Input = new Scanner (System.in);
		int n = Input.nextInt();

		Matriks M = new Matriks(n+1,n+2);

		for ( int i = M.GetFirstIdxBrs(); i < M.GetLastIdxBrs()+1; i++ ) {
			double x = Input.nextDouble();
			double y = Input.nextDouble();
			for ( int j = M.GetFirstIdxKol(); j < M.GetLastIdxKol(); j++ ) {

				M.Indeks[i][j] = Math.pow(x,j-1);
			}
			M.Indeks[i][M.GetLastIdxKol()] = y;
		}

		M.TulisMatriks();
		M.GaussJordanElimination().TulisMatriks();
		
	}
}