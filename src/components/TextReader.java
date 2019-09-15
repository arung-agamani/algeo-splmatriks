package components;

import java.io.*;
import java.util.Scanner;
// import components.Matriks;


public class TextReader {
    /*
        USAGE

    */

    
    // Implementation
    public TextReader() {
        super();
    }

    public Matriks ReadFileToMatrix(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner sc = new Scanner(file);
        String delimiter, tempArray[];
        MatrixDimension md = this.CheckDataLength(path);
        Matriks result = new Matriks(md.row, md.col);
        int iter;
        delimiter = " ";

        iter = 0;
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            tempArray = line.split(delimiter);
            for (int i = 0; i < tempArray.length; i++) {
                result.Mat[iter][i] = Integer.parseInt(tempArray[i]);
            }
            iter += 1;
        }
        sc.close();

        return result;
    }

    public MatrixDimension CheckDataLength (String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner sc = new Scanner(file);
        String delimiter, tempArray[];
        int iter, countRow, countCol;
        delimiter = " ";

        iter = 0;
        countRow = countCol = 0;
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            tempArray = line.split(delimiter);
            if (tempArray.length + 1 >= countCol) {
                countCol = tempArray.length;
            }
            iter += 1;
        }
        countRow = iter;
        sc.close();
        
        MatrixDimension md = new MatrixDimension(countRow, countCol);
        return md;
    }
      
}