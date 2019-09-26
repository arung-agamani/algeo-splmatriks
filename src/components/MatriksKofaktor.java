package components;

public class MatriksKofaktor {   

    //fungsi ambil determinan dari matriks kecil  
    public static void MatriksKecil(Matriks mat, Matriks kofak, int row, int col, int order){  
               
        int a = 0;  
        int b = 0;  
          
        for (int i = 0; i < order; i++) { 
                for (int j = 0; j < order; j++) {  
                    if (j != col && i != row) {  
                        kofak.Mat[a][b] = mat.Mat[i][j];
                        b++; 

                        if (b == order - 1) {
                            b = 0;
                            a++;
                        }
                    }  
                }  
              
        }    
    }  
                
              
    public static float DeterminanKofaktor(Matriks matriks,int order){
        //jika sudah 2x2
        if (order == 2){
            return (matriks.Mat[0][0]*matriks.Mat[1][1])-(matriks.Mat[0][1]*matriks.Mat[1][0]);
        } else {
            float res = 0;
            Matriks kofak = new Matriks(order, order);
            int tanda = 1;
            for (int i = 0; i < order; i++) {
                MatriksKecil(matriks, kofak, 0, i, order);
                res += tanda * matriks.Mat[0][i] * DeterminanKofaktor(kofak, order - 1);
                tanda = -tanda;
            }
            return res;
        }

            
        
    
    }



public static Matriks Invers(Matriks matriks, int order){
    float det = 1/DeterminanKofaktor(matriks, order, order);
        Matriks invers = new Matriks(order, order);
        matriks.transpose(order, order, matriks.Mat);       

    for (int i=0;i<order;i++){
        for (int j=0;j<order;j++){
            invers.Mat[i][j] = matriks.Mat[i][j]*det;
        }

    }
return invers;
}
}
