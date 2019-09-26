package components;

public class Kramer{

    public static float cramer(Matriks mat,Matriks nilai,int order){
        
        float detcram = 0;
        for (int i=0;i< order;i++ ){
        detcram += MatriksKofaktor.DeterminanKofaktor(mat, order) + MatriksKofaktor.DeterminanKofaktor(Cramerbagian(mat, order, i), order);  
        }
        return detcram;
        }
    


public static Matriks Cramerbagian(Matriks mat, int order, int replacedcol){
    Matriks cram = new Matriks(order,order);
    for (int i=0;i<order;i++){
        for(int j=0;j<order;j++){
            if (i==replacedcol){
                cram.Mat[replacedcol][j] = mat.Mat[replacedcol][j];
            }
            else {
                cram.Mat[i][j]= mat.Mat[i][j];
            }
        }
    } return cram;    


}
}