package components;

import java.lang.Math;
//import java.util.Arrays;

public class Point{
    public class Pt{ //inisiasi interpolarisasi
        float x;
        float y;
    }
    public class TonsOfPts{
        Pt[] Pt;
        int ptEff;
    }
    public TonsOfPts points;

    public Point (int a){ //constructor:
        this.points = new TonsOfPts();
        for (int i=0;i<a;i++){
            this.points.Pt[i].x=0;
            this.points.Pt[i].y=0;
            this.points.ptEff = a;
        }
    }


    public void isiPoints(int N) {
        //isi elemen x dan y untuk N buah titik
        int i;//STILL WIP
        for (i=0;i<N;i++)
        {
            this.points.Pt[i].x=i;
            this.points.Pt[i].y=i+1;
            this.points.ptEff += 1;
        }//random banget angkatnya
    }


    public static void Interpolasi (Point points1,Matriks anarray) {
        //konversi kedalam bentuk a0 + a1*x + a2*x^2 +...+an*x^(n-1) = y
        //LANGSUNG HAJAR KE ARRAY
        int i,j;
        MatrixDimension md = new MatrixDimension(points1.ptEff-1, points1.ptEff);
        //Sector 1 : convert ke matriks
        Matriks amatriks = new Matriks(md.row, md.col);
        anarray = new Matriks(1,md.col);
        for (i=0;i<=md.row;i++)
        {
            for (j=0;j<=md.col;j++)
            {
                if(j == md.col)
                {
                    amatriks.Mat[i][j] = points1.Pt[i].y;
                }
                else
                {
                    amatriks.Mat[i][j] = 1 * ((float)Math.pow(points1.Pt[i].x,j));
                }
            }
        }

        //Sector 2: its OBE time
        //ini diisi dengan OBE dengan Gauss-Jordan
        for (i=0;i<md.row;i++)
        {
            if (amatriks.Mat[i][i] != 1)
            {
                amatriks.SwitchRows(amatriks, amatriks.SearchForClosestToZero(amatriks, md, i + 1, i+1), i + 1); 
            }
            if (amatriks.Mat[i][i] != 1)
            {
                amatriks.ConstantMultRow(amatriks, i + 1 , amatriks.Mat[i][i], md);
            }
            for (int k = i - 1; k >= 0; k--)
            {
                while(amatriks.Mat[k][i] != 0)
                {
                    if (amatriks.Mat[k][i] > 0)
                    {
                        amatriks.AddOrSubstractRows(false, i+1, k+1, amatriks);
                    } 
                    else if (amatriks.Mat[k][i] < 0)
                    {
                        amatriks.AddOrSubstractRows(true, i+1, k+1, amatriks);
                    }
                }
            }
            if (!amatriks.CheckIfHasZeroRows(amatriks, md))
            {
                for (int k = i + 1; k < md.row; k++)
                {
                    while(amatriks.Mat[k][i] != 0)
                    {
                        if (amatriks.Mat[k][i] > 0)
                        {
                            amatriks.AddOrSubstractRows(false, i+1, k+1, amatriks);
                        } 
                        else if (amatriks.Mat[k][i] < 0)
                        {
                            amatriks.AddOrSubstractRows(true, i+1, k+1, amatriks);
                        }
                    }
                }
            }
        }
        //tolong dicek lagi gw cuma nyolong sendal dari suatu tempat
        //Sector 3: buat ke bentuk array    
        for (i=0;i<md.row;i++)
        {
            anarray.Mat[1][i] = amatriks.Mat[i][md.col];//mengisi polinom interpolasi dari hasil OBE
        }//ia gw mager bkin class baru cuma buat array, lagipula kan matriks itu array of array tapi pake 1 array baris
        //-Filbert

        
    }
}
    