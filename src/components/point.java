package components;

import java.lang.Math;
import java.util.Arrays;

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

    public point (int a){ //constructor:
        this.points = new points.Pt[a];
        for (int i=0;i<a;i++){
            this.points.Pt[i.x]=0;
            this.points.Pt[i.y]=0;
            this.points.ptEff = a;
        }
    }


    public void isiPoints(int N) {
        //isi elemen x dan y untuk N buah titik
        int i;//STILL WIP
        for (i=0;i<N;i++)
        {
            this.points.Pt[i.x]=i;
            this.points.Pt[i.x]=i+1;
            this.points.ptEff += 1;
        }//random banget angkatnya
    }


    public void ConvertToMatrix (TonsOfPts points1,Matriks Matout,MatrixDimension md) {
        //konversi kedalam bentuk a0 + a1*x + a2*x^2 +...+an*x^(n-1) = y
        int i,j;
        Matriks(points1.ptEff-1,points1.ptEff)//augmented matriks
        md.row = points1.ptEff-1;
        md.col = points1.ptEff;
        for (i=0;i<=md.row;i++)
        {
            for (j=0;j<=md.col;j++)
            {
                if(j == md.col)
                {
                    this.Matout[i][j] = points1.Pt[i.y];
                }
                else
                {
                    this.Matout[i][j] = 1 * points1.Pt[i.x]^(j);
                }
            }
        }

    }
}
    