package components;

import java.io.*;
import java.util.Scanner;
// import components.Matriks;

public class TextReader {
    /*
        USAGE

    */


    // Implementation

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