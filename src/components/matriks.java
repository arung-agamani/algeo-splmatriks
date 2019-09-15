package components;

public class Matriks {
    //atribut
    int[][] Mat = new int[10][10];
    //method

    Matriks() { //konstruktor:
        int i, j;
        for (i=1; i<10; i++) {
            for (j=1; j<10; j++) {
            this.Mat[i][j] = 0;
            }
        }
    }


    public void isimatriks(int N, int M) {
        //mengisi elemen matriks M[i,j] dengan nilai i+ij
        int i, j;
        for (i=0; i<N; i++) {
            for (j=0; j<M; j++) {
                this.Mat[i][j] = i+j;
            }
        }
    }

    public void tulismatriks(int N, int M) {
        // Mencetak elemen-elemen matriks
        int i, j;

        for (i=0; i<N; i++) {
            for (j=0; j<M; j++) {
                System.out.print(this.Mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    void transpose(int N, int M, int Matt[][]) {
        //membuat matriks transpose
        int i, j, temp;

        for (i=0; i<N; i++) {
            for (j=i; j<M; j++) {
                temp = Matt[j][i];
                Matt[j][i] = this.Mat[i][j];
                this.Mat[i][j]=temp;
            }
        }
    }
}