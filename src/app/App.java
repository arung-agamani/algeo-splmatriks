package app;

import components.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    static Scanner sc;
    public static void main(String[] args) throws Exception {
        boolean isDone;
        sc = new Scanner(System.in);
        

        // MULAI
        isDone = false;
        do {
            
            String choice;
            PrintMenu();
            System.out.print(">> ");
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                PrintSPLMenu();
                BacaSPLMenu();
                break;

                case "2":
                PrintDeterminanMenu();
                BacaDeterminanMenu();
                break;

                case "3":
                PrintInversMenu();
                BacaInversMenu();
                break;

                case "4":
                Matriks res = BacaMatriks();
                MatrixDimension md = BacaUkuranMatriks();
                Matriks kofakRes = MatriksKofaktor.MakeKofaktor(res, md.col);
                kofakRes.tulisMatriks(md.col, md.col);
                break;

                case "5":
                Matriks res2 = BacaMatriks();
                MatrixDimension md2 = BacaUkuranMatriks();
                Matriks adj = MatriksKofaktor.MakeKofaktor(res2, md2.col);
                adj.transpose(md2.col, md2.col, adj.Mat);
                adj.tulisMatriks(md2.col, md2.col);
                break;

                case "6":
                Point inter = BacaPoint();
                MatrixDimension md3 = BacaUkuranPoint();
                
                PrintSPLMenu();
                break;

                case "7":
                isDone = true;
                break;
            
                default:
                System.out.println("Masukan anda tidak valid.");
                    break;
            }

        } while (!isDone);
    }

    public static void PrintMenu() {
        System.out.println("MENU");
        System.out.println("1. Sistem Persamaan Linier");
        System.out.println("2. Determinan");
        System.out.println("3. Matriks Balikan");
        System.out.println("4. Matriks Kofaktor");
        System.out.println("5. Adjoin");
        System.out.println("6. Interpolasi Polinom");
        System.out.println("7. Keluar");
    }

    public static void PrintSPLMenu() {
        System.out.println("1. Metode Eliminasi Gauss");
        System.out.println("2. Metode Eliminasi Gauss-Jordan");
        System.out.println("3. Metode Matriks Balikan");
        System.out.println("4. Kaidah Kramer");
    }

    public static void PrintDeterminanMenu() {
        System.out.println("1. Metode Eliminasi Gauss");
        System.out.println("2. Metode Eliminasi Gauss-Jordan");
        System.out.println("3. Metode Kofaktor");
    }

    public static void PrintInversMenu() {
        System.out.println("1. Metode Eliminasi Gauss-Jordan");
        System.out.println("2. Metode Adjoint");
    }

    public static void BacaSPLMenu() throws FileNotFoundException {
        System.out.print(">> ");
        Scanner sc = new Scanner(System.in);        
        String choice = sc.nextLine();
        switch (choice) {
            case "1":
                
            break;

            case "2":
            PerformGaussJordan();
            break;

            case "3":
            
            break;

            case "4":
            
            break;
        
            default:
            System.out.println("Masukan anda tidak valid.");
                break;
        }
    }

    public static void BacaDeterminanMenu() throws FileNotFoundException {
        System.out.print(">> ");
        Scanner sc = new Scanner(System.in);        
        String choice = sc.nextLine();
        switch (choice) {
            case "1":
            Matriks loc0 = BacaMatriks();
            MatrixDimension md0 = BacaUkuranMatriks();
            GaussJordan.GaussJordanDet(loc0, md0);
            float det0 = 1;
            for (int i = 0; i < md0.row; i++) {
                det0 *= loc0.Mat[i][i];
            }
            System.out.println("Determinan : " + det0);
            break;

            case "2":
            Matriks loc1 = BacaMatriks();
            MatrixDimension md1 = BacaUkuranMatriks();
            GaussJordan.GaussJordanDet(loc1, md1);
            float det1 = 1;
            for (int i = 0; i < md1.row; i++) {
                det1 *= loc1.Mat[i][i];
            }
            System.out.println("Determinan : " + det1);
            break;

            case "3":
            Matriks loc = BacaMatriks();
            MatrixDimension md = BacaUkuranMatriks();
            float det = MatriksKofaktor.DeterminanKofaktor(loc, md.col);
            System.out.print("Determinan matriks ialah : ");
            System.out.println(det);
            break;
        
            default:
            System.out.println("Masukan anda tidak valid.");
                break;
        }
    }

    public static void BacaInversMenu() throws FileNotFoundException {
        System.out.print(">> ");
        Scanner sc = new Scanner(System.in);        
        String choice = sc.nextLine();
        switch (choice) {
            case "1":
            Matriks loc0 = BacaMatriks();
            MatrixDimension md0 = BacaUkuranMatriks();
            Matriks inv = GaussJordan.InverseJordan(loc0, md0);
            inv.tulisMatriks(md0.row, md0.col);
            break;

            case "2":
            Matriks loc = BacaMatriks();
            MatrixDimension md = BacaUkuranMatriks();
            Matriks adj = MatriksKofaktor.Invers(loc, md.col);
            adj.tulisMatriks(md.col, md.col);
            break;
        
            default:
            System.out.println("Masukan anda tidak valid.");
                break;
        }
    }

    public static void PerformGaussJordan() throws FileNotFoundException {
        TextReader tRead = new TextReader();
        Matriks localMat;
        MatrixDimension md;
        int flag, res;
        
        localMat = tRead.ReadFileToMatrix("./src/components/data.txt");
        md = tRead.CheckDataLength("./src/components/data.txt");
        flag = GaussJordan.GaussJordanElimination(localMat, md);
        res = GaussJordan.CheckIfHasSolution(localMat, md, flag);
        localMat.tulisMatriks(md.row, md.col);
        GaussJordanResult(localMat, md);
    }

    public static Matriks BacaMatriks() throws FileNotFoundException {
        TextReader tRead = new TextReader();
        Matriks localMat;
        localMat = tRead.ReadFileToMatrix("./src/components/data.txt");
        return localMat;
    }

    public static MatrixDimension BacaUkuranMatriks() throws FileNotFoundException {
        TextReader tRead = new TextReader();
        MatrixDimension md;
        md = tRead.CheckDataLength("./src/components/data.txt");
        return md;
    }

    public static Point BacaPoint() throws FileNotFoundException {
        TextReader tRead = new TextReader();
        Point pointa;
        pointa = tRead.ReadFileToPoints("./src/components/data2.txt");
        return pointa;
    }

    public static MatrixDimension BacaUkuranPoint() throws FileNotFoundException {
        TextReader tRead = new TextReader();
        MatrixDimension md;
        md = tRead.CheckDataLength("./src/components/data2.txt");
        return md;
    }//ini tester

    public static void GaussJordanResult(Matriks mat, MatrixDimension md) {
        int i, j;
        float sum = 0;
        int countSol;
        countSol = 0;
        for (j = 0; j < md.col; j++) {
            sum = 0;
            for (i = 0; i < md.row; i++) {                
                sum += mat.Mat[i][j];
            }
            if (sum == 0 || sum == 1) {
                countSol +=1;
            } 
            /* if (sum == 1) {
                System.out.print("x");
                System.out.print(j + 1);
                System.out.print(" memiliki solusi : ");
                System.out.println(mat.Mat[j][md.col-1]);
            } else if (sum == 0) {
                System.out.print("x");
                System.out.print(j+1);
                System.out.println(" memiliki solusi parametrik");                
            } */
            
        }
        if (countSol == md.col - 1){
            for (j = 0; j < md.col; j++) {
                sum = 0;
                for (i = 0; i < md.row; i++) {                
                    sum += mat.Mat[i][j];
                }
                if (sum == 1) {
                    System.out.print("x");
                    System.out.print(j + 1);
                    System.out.print(" memiliki solusi : ");
                    System.out.println(mat.Mat[j][md.col-1]);
                } else if (sum == 0) {
                    System.out.print("x");
                    System.out.print(j+1);
                    System.out.println(" memiliki solusi parametrik");                
                }
                
            }
        } else {
            if (mat.Mat[md.col - 2][md.col - 1] != 0) {
                System.out.println("SPL tidak memiliki solusi");
            } else {
                System.out.println("SPL memiliki solusi infinit");
            }
            
        }
    }
}