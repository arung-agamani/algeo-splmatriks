package components;

public class MatriksKofaktor {
    Matriks mat, temp, kofak;
    TextReader tr = new TextReader();
    MatrixDimension md;
    

    //fungsi ambil determinan dari matriks kecil  
    public Matriks MatriksKecil(int row, int col ){  
               
        int a = 0;  
        int b = 0;  
          
        Matriks LittleMatriks = new Matriks(row-1, col-1);  
          
        for (int i = 0; i < row; i++) {  
         if (i != row) {  
          for (int j = 0; j < col; j++) {  
           if (j != col) {  
            LittleMatriks.Mat[a][b] = mat.Mat[i][j];b++;  
           }  
          }  
          a++;  
          b = 0;  
         }  
        }  
        
        return LittleMatriks;  
       }  
                
              
        public Float DeterminanKofaktor(Matriks matriks,int col, int row){
    //jika sudah 2x2
    if (col == 2 && row == 2){
        return (matriks.Mat[0][0]*matriks.Mat[1][1])-(matriks.Mat[0][1]*matriks.Mat[1][0]);
    }
        
    float detkof =0; 
    for (int i=0; i<col; i++) { 
        detkof += (i % 2 == 0 ? 1 : -1) * mat.Mat[0][i] * DeterminanKofaktor(MatriksKecil(matriks.Mat, 0, i)); //error
        }
        return detkof;

    
    
    }



public Matriks Invers(Matriks matriks, int col, int row){
    float det = 1/DeterminanKofaktor(matriks, col, row);
        Matriks invers = new Matriks(row,col);
        matriks.transpose(row, col, matriks.Mat);       

    for (int i=0;i<col;i++){
        for (int j=0;j<row;j++){
            invers.Mat[i][j] = matriks.Mat[i][j]*det;
        }

    }
return invers;
}
}
