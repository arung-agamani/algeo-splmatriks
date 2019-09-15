package components;

import java.io.*;
import java.util.Scanner;
// import components.Matriks;

public class TextReader {
    /*
        USAGE

    */


    // Implementation
    public static void main(String[] args) throws Exception {
        Matriks mat = new Matriks();
        // KAMUS LOKAL //
        String delimiter = " ";
        String[] tempArray;
        int iter;
        Scanner sc;
        File file;
        file = new File("./src/components/data.txt");
        sc = new Scanner(file);
        iter = 0;
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            tempArray = line.split(delimiter);
            for (int i = 0; i < tempArray.length; i++) {
                // System.out.print(tempArray[i]);
                // System.out.print(" ");
                mat.Mat[iter][i] = Integer.parseInt(tempArray[i]);
            }
            iter += 1;
        }

        mat.tulismatriks(10, 10);

        System.out.println("Transposed matrix be like : ");
        mat.transpose(10, 10, mat.Mat);
        mat.tulismatriks(10, 10);

        sc.close();
    }

    public static Matriks ReadFileToMatrix(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner sc = new Scanner(file);
        String delimiter, tempArray[];
        Matriks result = new Matriks();
        int iter;
        delimiter = " ";

        iter = 0;
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            tempArray = line.split(delimiter);
            for (int i = 0; i < tempArray.length; i++) {
                // System.out.print(tempArray[i]);
                // System.out.print(" ");
                result.Mat[iter][i] = Integer.parseInt(tempArray[i]);
            }
            iter += 1;
        }
        sc.close();

        return result;
    }
}