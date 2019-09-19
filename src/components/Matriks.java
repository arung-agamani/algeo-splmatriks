package components;

import java.lang.Math;

public class Matriks {
    //atribut
    public float[][] Mat;
    //method

    public Matriks(int a, int b) { //konstruktor:
        this.Mat = new float[a][b];
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

    public void transpose(int N, int M, float Matt[][]) {
        //membuat matriks transpose
        int i, j;
        float temp;

        for (i=0; i<N; i++) {
            for (j=i; j<M; j++) {
                temp = Matt[j][i];
                Matt[j][i] = this.Mat[i][j];
                this.Mat[i][j]=temp;
            }
        }
    }

    public static float round2(float number, int scale) {
        int pow = 10;
        for (int i = 1; i < scale; i++)
            pow *= 10;
        float tmp = number * pow;
        return ( (float) ( (int) ((tmp - (int) tmp) >= 0.5f ? tmp + 1 : tmp) ) ) / pow;
    }

    public void AddOrSubstractRows(boolean isAdd, int sourceRow, int targetRow, Matriks targetMatriks) {
        // Belum jadi
        // to do : add/substract from source to target based on the boolean isAdd
        float firstRow[] = targetMatriks.Mat[sourceRow-1];
        int mult;
        if (isAdd) {
            mult = 1;
        } else {
            mult = -1;
        }
        for (int i = 0; i < firstRow.length; i++) {
            targetMatriks.Mat[targetRow-1][i] += targetMatriks.Mat[sourceRow-1][i]*mult;
        }
    }

    public int SearchForClosestToZero(Matriks targetMatriks, MatrixDimension md, int column, int startRow) {
        float delta = 9999;
        int src = 0;
        
        for (int i = startRow - 1; i < md.row; i++) {
            if (Math.abs(targetMatriks.Mat[i][column-1]) <= delta && targetMatriks.Mat[i][column-1] != 0) {
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
        float temp[] = targetMatriks.Mat[sourceRow-1];
        targetMatriks.Mat[sourceRow-1] = targetMatriks.Mat[targetRow-1];
        targetMatriks.Mat[targetRow-1] = temp;
    }

    public void ConstantMultRow(Matriks targetMatriks, int targetRow, float mult, MatrixDimension md) {
        for (int i = 0; i < md.col; i++) {
            targetMatriks.Mat[targetRow-1][i] = Math.round(targetMatriks.Mat[targetRow-1][i] * (1/mult)) ;
        }
    }

    public Boolean CheckIfHasZeroRows(Matriks targetMatriks, MatrixDimension md) {
        boolean isTrue = false;
        for (int i = 0; i < md.row; i++) {
            boolean rowClear;
            rowClear = true;
                for (int j = 0; j < md.col; j++) {
                    if (targetMatriks.Mat[i][j] != 0) {
                        rowClear = false;
                        break;
                    }
                }
            if (rowClear) {
                isTrue = true;
                break;
            }
        }
        return isTrue;
    }

    public Boolean CheckIfNotZeroUpperCol(Matriks targetMatriks, MatrixDimension md, int col) {
        boolean isTrue = true;
        for (int i = 0; i < md.row; i++) {
            if (targetMatriks.Mat[i][col] != 0) {
                isTrue = false;
            }
        }
        return isTrue;
    }

    public float Determinan(Matriks Mber,MatrixDimension md)
    /* Prekondisi: PERSEGI*/
    {
        float det=1;
        float ratio=1;
        int m,i,j,k,temp;
        for(k=1;k<=md.row;k++)
        {
            m=k;//marker
            for(i=k;i<=md.row;k++)
            {
                if (abs(Mber.mat[i][k]) > (Mber.mat[m][k])
                {
                    m = i;//set new marker
                }
                if (m != k)
                {
                    for (j=k;j<=GetLastIdxKol(Mvic);j++) // tukar baris
                    {
                        temp = Mber.mat[k][j];
                        Mber.mat[k][j]=Mber.mat[m][j];
                        Mber.mat[m][j]=temp;
                    };
                    det *= -1;
                }
                if (Mber.mat[k][k]==0)
                {
                    break;//jika diagonal ada yang 0
                }
                for (i=k+1;i<=md.row;i++)
                {
                    ratio = Mber.mat[i][k]/(float)Mber.mat[k][k];
                    for (j=k;j<=md.col;j++)
                    {
                        Mber.mat[i][j] -= (ratio*Mber.mat[k][j]);
                    }
                }
            }
            det *= Mber.mat[k][k];
        }
        if det==0 det = 0;
        return det;
    }
}
