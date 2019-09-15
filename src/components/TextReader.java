package components;

import java.io.*;
import java.util.Scanner;
// import components.Matriks;

public class TextReader {
    // Initialize text reader, could be scanner or FileReader
    // Store each value, delimited by space into a field in the array
    // Use looping lmoa

    // Save or export it into the matrix class, perhaps?

    // Implementation
    public static void main(String[] args) throws Exception {
        Matriks mat = new Matriks();
        // KAMUS LOKAL //
        String delimiter = " ";
        String[] tempArray;
        int iter;
        File directory = new File("./");
        Scanner sc;
        File file;

        System.out.println(directory.getAbsolutePath());
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
            System.out.println();
            iter += 1;
        }

        mat.tulismatriks(10, 10);

        sc.close();
    }
}