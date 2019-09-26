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

        /* for (int i  = 0; i < md.row; i++) {
            // System.out.println();
            // mat.tulisMatriks(md.row, md.col);
            if (mat.Mat[i][i] != 1) {
                mat.SwitchRows(mat, mat.SearchForClosestToZero(mat, md, i + 1, i+1), i + 1);
                // System.out.println("switched + ");
                // mat.tulisMatriks(md.row, md.col);
                // System.out.println();
            }
            if (mat.Mat[i][i] != 1) {
                mat.ConstantMultRow(mat, i + 1 , mat.Mat[i][i], md);
                // mat.tulisMatriks(md.row, md.col);
                // System.out.println();
            }
            if (i == md.row - 1 && md.row == md.col - 1) {
                System.out.println("INVOKED");
                if (mat.Mat[i][i] == 1) {
                    if (mat.Mat[i][i + 1] > 0) {
                        mat.tulisMatriks(md.row, md.col);
                        System.out.println("Ada solusi!");
                        break;
                    } else if (mat.Mat[i][i + 1] == 0) {
                        mat.tulisMatriks(md.row, md.col);
                        System.out.println("Ada solusi!");
                        break;
                    } else {
                        mat.tulisMatriks(md.row, md.col);
                        System.out.println("tidak ada solusi");
                        break;
                    }
                }
            }
            for (int k = i - 1; k >= 0; k--) {
                    while(mat.Mat[k][i] != 0) {
                        if (mat.Mat[k][i] > 0) {
                            mat.AddOrSubstractRows(false, i+1, k+1, mat);
                        } else if (mat.Mat[k][i] < 0) {
                            mat.AddOrSubstractRows(true, i+1, k+1, mat);
                        }
                        mat.tulisMatriks(md.row, md.col);
                        System.out.println();
                    }
                    if (mat.CheckIfHasZeroRows(mat, md)) {
                        mat.tulisMatriks(md.row, md.col);
                        System.out.println("Solusi banyak!");
                        i = md.row;
                        break;
                    }
                }
            
            if (!mat.CheckIfHasZeroRows(mat, md)) {
                for (int k = i + 1; k < md.row; k++) {
                    while(mat.Mat[k][i] != 0) {
                        if (mat.Mat[k][i] > 0) {
                            mat.AddOrSubstractRows(false, i+1, k+1, mat);
                        } else if (mat.Mat[k][i] < 0) {
                            mat.AddOrSubstractRows(true, i+1, k+1, mat);
                        }
                        // mat.tulisMatriks(md.row, md.col);
                        // System.out.println();
                        
                    }
                    if (mat.CheckIfHasZeroRows(mat, md)) {
                        mat.tulisMatriks(md.row, md.col);
                        System.out.println("Solusi banyak!");
                        i = md.row;
                        break;
                    }
                }
            }
            
            if (i == md.row - 1 && md.row <= md.col - 1) {
                if (mat.Mat[i][i] == 1) {
                    mat.tulisMatriks(md.row, md.col);
                        System.out.println("Solusi banyak!");
                        i = md.row;
                        break;
                }
            }
            
         */
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

}
