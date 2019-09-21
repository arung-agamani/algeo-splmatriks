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
                
              
    public Float DeterminanKofaktor(){
    //jika sudah 2x2
    if (md.col == 2 && md.row == 2){
        return (mat.Mat[0][0]*mat.Mat[1][1])-(mat.Mat[0][1]*mat.Mat[1][0]);
    }
      
    float det = 0;   
     det += mat.Mat[1][0] * this.MatriksKecil(md.col, md.row).DeterminanKofaktor();  //ini ga tau error kenape :()
     return det;
    
    }

}
    