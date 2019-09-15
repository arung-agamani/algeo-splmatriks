package components;

import java.lang.Math;

public class Matriks {
    //atribut
    public int[][] Mat;
    //method

    public Matriks(int a, int b) { //konstruktor:
        this.Mat = new int[a][b];
        for (int i=0; i<a; i++) {
            for (int j=0; j<b; j++) {
            this.Mat[i][j] = 0;
            }
        }
    }


    public void isiMatriks(int N, int M) {
        //mengisi elemen matriks M[i,j] dengan nilai i+ij
        int i, j;
        for (i=0; i<N; i++) {
            for (j=0; j<M; j++) {
                this.Mat[i][j] = i+j;
            }
        }
    }

    public void tulisMatriks(int N, int M) {
        // Mencetak elemen-elemen matriks
        int i, j;

        for (i=0; i<N; i++) {
            for (j=0; j<M; j++) {
                System.out.print(this.Mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void transpose(int N, int M, int Matt[][]) {
        //membuat matriks transpose
        int i, j, temp;

        for (i=0; i<N; i++) {
            for (j=i; j<M; j++) {
                temp = Matt[j][i];
                Matt[j][i] = this.Mat[i][j];
                this.Mat[i][j]=temp;
            }
        }
    }

    public void AddOrSubstractRows(boolean isAdd, int sourceRow, int targetRow, Matriks targetMatriks) {
        // Belum jadi
        // to do : add/substract from source to target based on the boolean isAdd
        int firstRow[] = targetMatriks.Mat[sourceRow-1];
        int secondRow[] = targetMatriks.Mat[targetRow-1];
        for (int i = 0; i < firstRow.length; i++) {
            System.out.print(firstRow[i]);
            System.out.print(" ");
        }
        System.out.println();
        for (int i = 0; i < secondRow.length; i++) {
            System.out.print(secondRow[i]);
            System.out.print(" ");
        }
    }

    public int SearchForClosestToZero(Matriks targetMatriks, MatrixDimension md, int column, int startRow) {
        int delta = 9999;
        int src = 0;
        
        for (int i = startRow - 1; i < md.row; i++) {
            if (Math.abs(targetMatriks.Mat[i][column-1]) >= delta) {
                delta = Math.abs(targetMatriks.Mat[i][column-1]);
                src = i;
            }
        }

        return src + 1;
    }

    public void InvertRowSign(Matriks targetMatriks, MatrixDimension md, int row) {
        for (int i = 0; i < md.col; i++) {
            targetMatriks.Mat[row-1][i] *= -1;
        }
    }

    public void SwitchRows(Matriks targetMatriks, int sourceRow, int targetRow) {
        int temp[] = targetMatriks.Mat[sourceRow-1];
        targetMatriks.Mat[sourceRow-1] = targetMatriks.Mat[targetRow-1];
        targetMatriks.Mat[targetRow-1] = temp;
    }
}