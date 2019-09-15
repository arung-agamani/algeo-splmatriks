/* kelas driver matriks */
class DriverMatriks {
    public static void main(String[] args) {
        angka X = new angka (); // x merupakan nama dari class angka 
        X. inputangka();
        
        // buat objek P1
        matriks Z = new matriks ();

        // mengisi matriks
        Z. isimatriks(X.M, X.N);

        // menulis matriks
        System.out.println("Isi matriksnya dong UWU : ");
        Z. tulismatriks(X.M, X.N);

        // membuat matriks transpose
        int[][] Z2;
        Z2 = new int[X.N][X.M];
        Z. transpose(X.M,X.N,Z2);

        // Tulis matriks transpose
        System.out.println("isi matriks transposenya ea : ");
        int i, j;
        for (i=0; i<X.N; i++) {
            for (j=0; j<X.M; j++) {
                System.out.print(Z2[i][j] + " ");
            }
            System.out.println();
        } 
    }
}