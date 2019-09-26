package algeo;
import java.util.Scanner;

public class run {

    public static void println(String str) {
        System.out.println(str);
    }
    public static void print(String str) {
        System.out.print(str);
    }

    public static void Run_SPLEliminasiGauss() {
        Scanner Input = new Scanner(System.in);
        
        String[] arr = Input.nextLine().split(" ");
        int m = Integer.parseInt(arr[0]);
        int n = Integer.parseInt(arr[1]);
        // Membaca n : banyaknya variabel persamaan

        SPL SP = new SPL();
        Matriks MSP = new Matriks(m,n+1);
        
        SP.BacaSPL(m, n);
        // Membaca m persamaan dengan n variabel

        MSP.SPLtoMatriks(SP);
        // Mengubah dari bentuk persamaan linier ke matriks

        MSP.SPLGauss(SP);
        // Menghitung dan menampilkan hasil dengan menggunakan-
        // kaidah Cramer

        Input.close();
    }

    public static void Run_SPLEliminasiGaussJordan() {
        Scanner Input = new Scanner(System.in);
        
        String[] arr = Input.nextLine().split(" ");
        int m = Integer.parseInt(arr[0]);
        int n = Integer.parseInt(arr[1]);
        // Membaca n : banyaknya variabel persamaan

        SPL SP = new SPL();
        Matriks MSP = new Matriks(m,n+1);
        
        SP.BacaSPL(m, n);
        // Membaca m persamaan dengan n variabel

        MSP.SPLtoMatriks(SP);
        // Mengubah dari bentuk persamaan linier ke matriks

        MSP.SPLGaussJordan(SP);
        // Menghitung dan menampilkan hasil dengan menggunakan-
        // kaidah Cramer

        Input.close();
    }

    public static void Run_SPLMatriksBalikan() {

        Scanner Input = new Scanner(System.in);
        
        String[] arr = Input.nextLine().split(" ");
        int m = Integer.parseInt(arr[0]);
        int n = Integer.parseInt(arr[1]);
        // Membaca n : banyaknya variabel persamaan

        SPL SP = new SPL();
        Matriks MSP = new Matriks(m,n+1);
        
        SP.BacaSPL(m, n);
        // Membaca m persamaan dengan n variabel

        MSP.SPLtoMatriks(SP);
        // Mengubah dari bentuk persamaan linier ke matriks

        MSP.SPLInverse(SP);
        // Menghitung dan menampilkan hasil dengan menggunakan-
        // metode inverse
    }

    public static void Run_SPLCramer() {
        Scanner Input = new Scanner(System.in);
        
        String[] arr = Input.nextLine().split(" ");
        int m = Integer.parseInt(arr[0]);
        int n = Integer.parseInt(arr[1]);
        // Membaca n : banyaknya variabel persamaan

        SPL SP = new SPL();
        Matriks MSP = new Matriks(m,n+1);
        
        SP.BacaSPL(m, n);
        // Membaca m persamaan dengan n variabel

        MSP.SPLtoMatriks(SP);
        // Mengubah dari bentuk persamaan linier ke matriks

        MSP.SPLCramer(SP);
        // Menghitung dan menampilkan hasil dengan menggunakan-
        // kaidah Cramer

        Input.close();
    }

    public static void Run_DeterminanKofaktor() {
        Scanner Input = new Scanner(System.in);

        int N = Input.nextInt();

        Matriks M = new Matriks(N,N);
        M.BacaMatriks();

        System.out.printf("Determinan : %.2f\n",M.DeterminanKofaktor());

        Input.close();
    }

    public static void Run_DeterminanGauss() {
        Scanner Input = new Scanner(System.in);

        int N = Input.nextInt();

        Matriks M = new Matriks(N,N);
        M.BacaMatriks();

        System.out.printf("Determinan : %.2f\n",M.DeterminanGauss());

        Input.close();
    }

    public static void Run_MatriksBalikanAdjoin() {
        Scanner Input = new Scanner(System.in);

        int N = Input.nextInt();

        Matriks M = new Matriks(N,N);
        M.BacaMatriks();

        M.InverseAdjoin().TulisMatriks();

        Input.close();
    }

    public static void Run_MatriksKofaktor() {
        Scanner Input = new Scanner(System.in);
        int N = Input.nextInt();

        Matriks M = new Matriks(N,N);
        M.BacaMatriks();

        M.MatriksKofaktor().TulisMatriks();

        Input.close();
    }

    public static void Run_Adjoin() {
        Scanner Input = new Scanner(System.in);
        int N = Input.nextInt();

        Matriks M = new Matriks(N,N);
        M.BacaMatriks();

        M.Adjoin().TulisMatriks();

        Input.close();
    }

    public static void Run_MatriksBalikanGauss() {
        Scanner Input = new Scanner(System.in);

        int N = Input.nextInt();

        Matriks M = new Matriks(N,N);
        M.BacaMatriks();

        M.InverseGauss().TulisMatriks();

        Input.close();
    }

    public static void ClearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {

        while (true) {

            ClearScreen();
            Scanner Input = new Scanner(System.in);
            int op,subop;
            println("================ MENU ================");
            println("1. Sistem Persamaan Linier");
            println("2. Determinan");
            println("3. Matriks Balikan");
            println("4. matriks Kofaktor");
            println("5. Adjoin");
            println("6. Interpolasi Polinom");
            println("7. Keluar");
            println("======================================");
            print("Pilih menu : "); op = Input.nextInt();

            switch(op) {
                case 1:
                    ClearScreen();
                    // Menu 1 Sistem Persamaan Linier
                    println("================ Sistem Persamaan Linear ================");
                    println("1. Metode eliminasi Gauss");
                    println("2. Metode eliminasi Gauss-Jordan");
                    println("3. Metode matriks balikan");
                    println("4. Kaidah Cramer");
                    println("5. Kembali");
                    println("==========================================================");
                    print("Pilih menu : "); subop = Input.nextInt();

                    switch(subop) {
                        case 1: Run_SPLEliminasiGauss(); break;
                        case 2: Run_SPLEliminasiGaussJordan(); break;
                        case 3: Run_SPLMatriksBalikan(); break;
                        case 4: Run_SPLCramer(); break;
                        case 5: continue;
                        default: break;
                    }

                    break;
                case 2:
                    ClearScreen();
                    // Menu 2 Determinan
                    println("================ Determinan ================");
                    println("1. Metode eliminasi Gauss");
                    println("2. Metode kofaktor");
                    println("3. Kembali");
                    println("============================================");
                    print("Pilih menu : "); subop = Input.nextInt();
                    switch(subop) {
                        case 1: Run_DeterminanGauss(); break;
                        case 2: Run_DeterminanKofaktor();break;
                        case 3: continue;
                        default: break;
                    } 
                    break;
                case 3:
                    ClearScreen();
                    // Menu 3 matriks balikan
                    println("================ Matriks Balikan ================");
                    println("1. Metode Eliminasi Gauss");
                    println("2. Metode Adjoin");
                    println("3. Kembali");
                    print("Pilih menu : "); subop = Input.nextInt();
                    println("=================================================");
                    switch(subop) {
                        case 1: Run_MatriksBalikanGauss(); break;
                        case 2: Run_MatriksBalikanAdjoin(); break;
                        case 3: continue;
                        default: break;
                    } 
                    break;
                // Menu 4 matriks kofaktor
                case 4: Run_MatriksKofaktor(); break;
                // Menu 5 adjoin
                case 5: Run_Adjoin(); break;
                // Menu 6 interpolasi polinom
                case 6: break;
                // keluar
                case 7: System.exit(0);;
                default: break;
            }

            Input.close();
        }
    }
}