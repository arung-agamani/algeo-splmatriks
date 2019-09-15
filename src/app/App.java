package app;

import components.*;

public class App {
    public static void main(String[] args) throws Exception {
        TextReader tr = new TextReader();
        MatrixDimension md;
        Matriks mat;
        System.out.println("Hello Java");
        System.out.println("This is a boilerplate project for Tubes Algeo 1. Have fun!");
        System.out.println("And good luck...");
        md = tr.CheckDataLength("./src/components/data.txt");
        mat = tr.ReadFileToMatrix("./src/components/data.txt");
        mat.tulisMatriks(md.row, md.col);
        //System.out.println("The data length is : \nRow : " + md.row + "\nCol : " + md.col);
        System.out.println();
        System.out.print("Row which the first element closest to 0 is : ");
        System.out.print(mat.SearchForClosestToZero(mat, md, 1, 1));
        System.out.println();
        if (mat.Mat[mat.SearchForClosestToZero(mat, md, 1, 1)-1][0] < 0) {
            mat.InvertRowSign(mat, md, 1);
            mat.tulisMatriks(md.row, md.col);
        } else {
            mat.tulisMatriks(md.row, md.col);
        }
        System.out.println();
        mat.SwitchRows(mat, 2, 3);
        mat.tulisMatriks(md.row, md.col);
        
        // mat.AddOrSubstractRows(false, 1,2, mat);
    }
}