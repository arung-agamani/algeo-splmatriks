package components;

import java.lang.Math;

import components.Point.TonsOfPts;

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
                System.out.print(round2(this.Mat[i][j], 2) + " ");
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
            targetMatriks.Mat[targetRow-1][i] = round2(targetMatriks.Mat[targetRow-1][i] * (1/mult), 2) ;
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
        int m,i,j,k;
        float temp;
        for(k=0;k<md.row;k++)
        {
            m=k;//marker
            for(i=k;i<md.row;k++)
            {
                if (Math.abs(Mber.Mat[i][k]) > (Mber.Mat[m][k]))
                {
                    m = i;//set new marker
                }
                if (m != k)
                {
                    for (j=k;j<md.col;j++) // tukar baris
                    {
                        temp = Mber.Mat[k][j];
                        Mber.Mat[k][j]=Mber.Mat[m][j];
                        Mber.Mat[m][j]=temp;
                    };
                    det *= -1;
                }
                if (Mber.Mat[k][k]==0)
                {
                    break;//jika diagonal ada yang 0
                }
                for (i=k+1;i<md.row;i++)
                {
                    ratio = Mber.Mat[i][k]/(float)Mber.Mat[k][k];
                    for (j=k;j<md.col;j++)
                    {
                        Mber.Mat[i][j] -= (ratio*Mber.Mat[k][j]);
                    }
                }
            }
            det *= Mber.Mat[k][k];
        }
        if (det==0) det = 0;
        return det;
    }

    public void interpolasi (Matriks matin, MatrixDimension md, Matriks matout){
        //membentuk matriks eschelon tereduksi dengan Gauss-Jordan elemination
        //lalu hasil dari metode dipindah ke dalam "array" (padahal pake matriks 1xn )
        int i,j;

        //ini diisi dengan OBE dengan Gauss-Jordan
        for (i=0;i<md.row;i++)
        {
            if (matin.Mat[i][i] != 1)
            {
                matin.SwitchRows(matin, matin.SearchForClosestToZero(matin, md, i + 1, i+1), i + 1); 
            }
            if (matin.Mat[i][i] != 1)
            {
                matin.ConstantMultRow(matin, i + 1 , matin.Mat[i][i], md);
            }
            for (int k = i - 1; k >= 0; k--)
            {
                while(matin.Mat[k][i] != 0)
                {
                    if (matin.Mat[k][i] > 0)
                    {
                        matin.AddOrSubstractRows(false, i+1, k+1, matin);
                    } 
                    else if (matin.Mat[k][i] < 0)
                    {
                        matin.AddOrSubstractRows(true, i+1, k+1, matin);
                    }
                }
            }
            if (!matin.CheckIfHasZeroRows(matin, md))
            {
                for (int k = i + 1; k < md.row; k++)
                {
                    while(matin.Mat[k][i] != 0)
                    {
                        if (matin.Mat[k][i] > 0)
                        {
                            matin.AddOrSubstractRows(false, i+1, k+1, matin);
                        } 
                        else if (matin.Mat[k][i] < 0)
                        {
                            matin.AddOrSubstractRows(true, i+1, k+1, matin);
                        }
                    }
                }
            }
        }
        //tolong dicek lagi gw cuma nyolong sendal dari App.java

        for (i=0;i<md.row;i++)
        {
            matout.Mat[1][i] = matin.Mat[i][md.col];//mengisi polinom interpolasi dari hasil OBE
        }//ia gw mager bkin class baru cuma buat array, lagipula kan matriks itu array of array tapi pake 1 array baris
        //-Filbert
    }
    public float HasilInterpolasi(float x,Matriks mat,MatrixDimension md)
    //md dari ukuran array interpolasi
    {
        float hasil=0;
        for (int i=0;i<=md.col;i++)
        {
            hasil += mat.Mat[1][i]*(Math.pow(x, i));
        }
        return hasil;
    }
}

