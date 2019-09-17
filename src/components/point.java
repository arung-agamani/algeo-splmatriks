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
        int PtEff;
    }

    public Points (int a){ //constructor:
        this.TonsOfPts = new Pt[a];
        for (int i=0;i<a;i++){
            this.TonsOfPts.Pt[i.x]=0;
            this.TonsOfPts.Pt[i.y]=0;
            this.TonsOfPts.PtEff = 0;
        }
    }


    public void isiPoints(int N) {
        //isi elemen x dan y untuk N buah titik
        int i;//STILL WIP
        for (i=0;i<N;i++)
        {
            this.TonsOfPts.Pt[i.x]=i;
            this.TonsOfPts.Pt[i.x]=i+1;
            this.TonsOfPts.PtEff += 1;
        }//random banget angkatnya
    }


    public void ConvertToMatrix (TonsOfPts points1,Matriks Mattbro) {
        //konversi kedalam bentuk a0 + a1*x + a2*x^2 +...+an*x^(n-1) = y
        // ITS ****ING WIP
        int Row,Col,i,j;
        Matriks(points1.PtEff-1,points1.PtEff)//augmented matriks
        Row = points1.PtEff-1;
        Col = points1.PtEff;
        for (i=0;i<=Row;i++)
        {
            for (j=0;j<=Col;j++)
            {
                if(j == Col)
                {
                    this.Mattbro[i][j] = points1.Pt[i.y];
                }
                else
                {
                    this.Mattbro[i][j] = 1 * points1.Pt[i.x]^(j);
                }
            }
        }

    }
}
    