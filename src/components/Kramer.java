package components;

public class Kramer{

    public static void cramer(Matriks mat,Matriks nilai,int order){
        float detcram = 0;
        for (int i=0;i< order;i++ ){
            detcram = MatriksKofaktor.DeterminanKofaktor(Cramerbagian(mat, order, i), order)/MatriksKofaktor.DeterminanKofaktor(mat, order);  
            System.out.print("x"+i+" ="+detcram);
        }
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
        }
        return cram;
    }
}
