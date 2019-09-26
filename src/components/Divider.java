package components;
public class Divider{

    public static Matriks MatriksBiasa(Matriks matriks, int row , int col){
        Matriks matbis = new Matriks(row,col-1);
        for (int i=0;i<col-1;i++){
            for (int j=0;j<row;j++){
                matbis.Mat[i][j] = matriks.Mat[i][j];                
            }
        }
        return matbis;
    }
    
    public static Matriks Nilai(Matriks matriks, int row , int col){
        Matriks matnil = new Matriks(row,1);
        for (int i=0;i<row;i++){
                matnil.Mat[col][i] = matriks.Mat[col][i];              
            }
            return matnil;
        }
}
