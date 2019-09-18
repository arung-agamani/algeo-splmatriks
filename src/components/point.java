package components;

import java.lang.Math;
import java.util.Arrays;

public class point{
    public class Pt{ //inisiasi interpolarisasi
        float x;
        float y;
    }
    public class tonsOfPts{
        Pt[] Pt;
        int ptEff;
    }

    public point (int a){ //constructor:
        this.tonsOfPts = new tonsOfPts.Pt[a];
        for (int i=0;i<a;i++){
            this.tonsOfPts.Pt[i.x]=0;
            this.tonsOfPts.Pt[i.y]=0;
            this.tonsOfPts.ptEff = a;
        }
    }


    public void isiPoints(int N) {
        //isi elemen x dan y untuk N buah titik
        int i;//STILL WIP
        for (i=0;i<N;i++)
        {
            this.tonsOfPts.Pt[i.x]=i;
            this.tonsOfPts.Pt[i.x]=i+1;
            this.tonsOfPts.ptEff += 1;
        }//random banget angkatnya
    }


    public void ConvertToMatrix (tonsOfPts points1,Matriks Mattbro) {
        //konversi kedalam bentuk a0 + a1*x + a2*x^2 +...+an*x^(n-1) = y
        // ITS ****ING WIP
        int Row,Col,i,j;
        Matriks(points1.ptEff-1,points1.ptEff)//augmented matriks
        Row = points1.ptEff-1;
        Col = points1.ptEff;
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


    public void interpolasi (Matriks Mattbro, float X){
        //membentuk matriks eschelon tereduksi dengan Gauss-Jordan elemination
        //lalu hasil dari metode dipindah ke dalam array
        float tempArray[]
    }
}
    