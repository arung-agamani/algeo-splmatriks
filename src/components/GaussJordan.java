package components;

public class GaussJordan {
    public static int GaussJordanElimination(Matriks mat, MatrixDimension md) {
        int i, j, k = 0;
        int c, flag = 0;
        // int m = 0;
        // float pro = 0;

        for (i = 0; i < md.row; i++) {
            if (mat.Mat[i][i] == 0) {
                c = 1;
                while ((i + c) < md.row && mat.Mat[i + c][i] == 0)
                    c++;
                if ((i + c) == md.row) {
                    flag = 1;
                    break;
                }
                for (j = i, k = 0; k < md.col; k++) {
                    float temp = mat.Mat[j][k];
                    mat.Mat[j][k] = mat.Mat[j + c][k];
                    mat.Mat[j + c][k] = temp;
                }
            }
            for (j = 0; j < md.row; j++) {
                if (i != j) {
                    float p = mat.Mat[j][i] / mat.Mat[i][i];
                    for (k = 0; k < md.col; k++) {
                        mat.Mat[j][k] = mat.Mat[j][k] - (mat.Mat[i][k]) * p;
                    }
                }
            }
        }
        Normalize(mat, md);
        return flag;

        
    }

    public void GaussElimination(Matriks mat, MatrixDimension md) {
        int i,j,k,n;
        for (j = 0; j < md.row; j++) {
            for (i = 0; i < md.row; i++) {
                if (i > j) {
                    float ratio = mat.Mat[i][j]/ mat.Mat[j][j];
                    for (k = 0; k < md.col; k++) {
                        mat.Mat[i][k] = mat.Mat[i][k] - (ratio * mat.Mat[j][k]);
                    }
                }
            }
        }
    }

    public static void GaussJordanDet(Matriks mat, MatrixDimension md) {
        int i, j, k = 0;
        int c, flag = 0;
        // int m = 0;
        // float pro = 0;

        for (i = 0; i < md.row; i++) {
            if (mat.Mat[i][i] == 0) {
                c = 1;
                while ((i + c) < md.row && mat.Mat[i + c][i] == 0)
                    c++;
                if ((i + c) == md.row) {
                    flag = 1;
                    break;
                }
                for (j = i, k = 0; k < md.col; k++) {
                    float temp = mat.Mat[j][k];
                    mat.Mat[j][k] = mat.Mat[j + c][k];
                    mat.Mat[j + c][k] = temp;
                }
            }
            for (j = 0; j < md.row; j++) {
                if (i != j) {
                    float p = mat.Mat[j][i] / mat.Mat[i][i];
                    for (k = 0; k < md.col; k++) {
                        mat.Mat[j][k] = mat.Mat[j][k] - (mat.Mat[i][k]) * p;
                    }
                }
            }
        }
    }

    public static int CheckIfHasSolution(Matriks mat, MatrixDimension md, int flag) {
        int i, j;
        float sum;
        flag = 3;
        for (i = 0; i < md.row; i++) {
            sum = 0;
            
            for (j = 0; j < md.col - 1; j++) {
                sum += mat.Mat[i][j];
            }
            if (sum == mat.Mat[i][j]) {
                flag = 2;
            }
        }
        return flag;
    }

    public static void Normalize(Matriks mat, MatrixDimension md){
        int i, j;
        for (i = 0; i < md.row; i++) {
            for (j = 0; j< md.col; j++) {
                if (mat.Mat[i][j] != 0) {
                    mat.ConstantMultRow(mat, i + 1, mat.Mat[i][j], md);
                    break;
                }
            }
        }
    }

    public static Matriks InverseJordan(Matriks mat, MatrixDimension md) {
        Matriks augmented = new Matriks(md.row, md.col * 2);
        Matriks res = new Matriks(md.row, md.row);
        int i, j, k = 0;
        int c, flag = 0;
        // fill
        for (i = 0; i < md.row; i++) {
            for (j = 0; j < md.col; j++) {
                augmented.Mat[i][j] = mat.Mat[i][j];
                if (i == j) {
                    augmented.Mat[i][j + md.col] = 1;
                } else {
                    augmented.Mat[i][j + md.col] = 0;
                }
            }
        }

        // algh
        for (i = 0; i < md.row; i++) {
            if (augmented.Mat[i][i] == 0) {
                c = 1;
                while ((i + c) < md.row && augmented.Mat[i + c][i] == 0)
                    c++;
                if ((i + c) == md.row) {
                    flag = 1;
                    break;
                }
                for (j = i, k = 0; k < md.col*2; k++) {
                    float temp = augmented.Mat[j][k];
                    augmented.Mat[j][k] = augmented.Mat[j + c][k];
                    augmented.Mat[j + c][k] = temp;
                }
            }
            for (j = 0; j < md.row; j++) {
                if (i != j) {
                    float p = augmented.Mat[j][i] / augmented.Mat[i][i];
                    for (k = 0; k < md.col*2; k++) {
                        augmented.Mat[j][k] = augmented.Mat[j][k] - (augmented.Mat[i][k]) * p;
                    }
                }
            }
        }
        Normalize(augmented, md);

        for (i = 0; i < md.row; i++) {
            for (j = 0; j < md.col; j++) {
                res.Mat[i][j] = augmented.Mat[i][j + md.col];
            }
        }
        
        return res;
    }

}
