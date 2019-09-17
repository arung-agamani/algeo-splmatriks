package components;

import java.lang.Math;
import java.util.Arrays;

public class Point{
    public class Pt{ //inisiasi interpolarisasi
        float x;
        float y;
    }
    public Pt[] TonsOfPts;

    public Points (int a){ //constructor:
        this.TonsOfPts = new Pt[a];
        for (int i=0;i<a;i++){
            this.TonsOfPts[i.x]=0;
            this.TonsOfPts[i.y]=0;
        }
    }


    public void isiPoints(int N) {
        //isi elemen x dan y untuk N buah titik
        int i;//STILL WIP
    }


    public void ConvertToMatrix (TonsOfPts points1) {
        //konversi kedalam bentuk a0 + a1*x + a2*x^2 +...+an*x^n = y
        // ITS ****ING WIP
    }
}
    