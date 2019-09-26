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
                PrintSPLMenu();
                break;

                case "5":
                PrintSPLMenu();
                break;

                case "6":
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
                
            break;

            case "2":
            
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
                
            break;

            case "2":
            
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