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
        /* System.out.println();
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
        mat.tulisMatriks(md.row, md.col); */
        
        // mat.AddOrSubstractRows(false, 1,2, mat);

        // Algoritma Gauss-Jordan elimination
        for (int i  = 0; i < md.row; i++) {
                System.out.println();
                mat.tulisMatriks(md.row, md.col);
                if (mat.Mat[i][i] != 1) {
                    mat.SwitchRows(mat, mat.SearchForClosestToZero(mat, md, i + 1, i+1), i + 1);
                    System.out.println("switched + ");
                    mat.tulisMatriks(md.row, md.col);
                    System.out.println();
                }
                if (mat.Mat[i][i] != 1) {
                    mat.ConstantMultRow(mat, i + 1 , mat.Mat[i][i], md);
                    mat.tulisMatriks(md.row, md.col);
                    System.out.println();
                }
                if (i == md.row - 1 && md.row == md.col - 1) {
                    if (mat.Mat[i][i] == 1) {
                        if (mat.Mat[i][i + 1] > 0) {
                            System.out.println("Ada solusi!");
                            break;
                        } else if (mat.Mat[i][i + 1] == 0) {
                            System.out.println("Solusi banyak!");
                            break;
                        } else {
                            System.out.println("tidak ada solusi");
                            break;
                        }
                    }
                }
                
                for (int k = i + 1; k < md.row; k++) {
                    while(mat.Mat[k][i] != 0) {
                        if (mat.Mat[k][i] > 0) {
                            mat.AddOrSubstractRows(false, i+1, k+1, mat);
                        } else if (mat.Mat[k][i] < 0) {
                            mat.AddOrSubstractRows(true, i+1, k+1, mat);
                        }
                        mat.tulisMatriks(md.row, md.col);
                        System.out.println();
                        
                    }
                    if (mat.CheckIfHasZeroRows(mat, md)) {
                        System.out.println("Solusi banyak!");
                        i = md.row;
                        break;
                    }
                }
                if (!mat.CheckIfHasZeroRows(mat, md)) {
                    for (int k = i - 1; k >= 0; k--) {
                        while(mat.Mat[k][i] != 0) {
                            if (mat.Mat[k][i] > 0) {
                                mat.AddOrSubstractRows(false, i+1, k+1, mat);
                            } else if (mat.Mat[k][i] < 0) {
                                mat.AddOrSubstractRows(true, i+1, k+1, mat);
                            }
                            mat.tulisMatriks(md.row, md.col);
                            System.out.println();
                        }
                        if (mat.CheckIfHasZeroRows(mat, md)) {
                            System.out.println("Solusi banyak!");
                            i = md.row;
                            break;
                        }
                    }
                }
                
                if (i == md.row - 1 && md.row <= md.col - 1) {
                    if (mat.Mat[i][i] == 1) {
                            System.out.println("Solusi banyak!");
                            i = md.row;
                            break;
                    }
                }
                
            
        }
    }
}