package components;

public class Kramer{

    public static void cramer(Matriks mat,Matriks nilai,int order){
        float detcram = 0;
        for (int i=0;i< order;i++ ){
            detcram = MatriksKofaktor.DeterminanKofaktor(Cramerbagian(mat,nilai, order, i), order)/MatriksKofaktor.DeterminanKofaktor(mat, order);  
            System.out.println("x"+(i + 1)+" = "+detcram);
        }
    }

    public static Matriks Cramerbagian(Matriks mat, int order, int replacedcol){
        Matriks cram = new Matriks(order,order);
        for (int i=0;i<order;i++){
            for(int j=0;j<order;j++){
                 if (j!=replacedcol){
                    cram.Mat[i][j] = mat.Mat[i][j];
                }
                else{
                    cram.Mat[i][replacedcol]= nilai.Mat[i][0];
                }
            }
        }
        return cram;
    }
}
