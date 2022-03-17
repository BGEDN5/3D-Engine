public class Matrix_4x4 {

    private static final byte matrix_len_4 = 4;
    private float [][] matrix;

    public Matrix_4x4(float [][] matrix){
        this.matrix = matrix;
    }

    public float[][] getMatrix() {
        return matrix;
    }

    public float getSeparateCell(int i, int j){
        return matrix[i][j];
    }

    public void setMatrix(float[][] matrix) {
        this.matrix = matrix;
    }

    public void setSeparateCell(int i, int j, int entry){
        this.matrix[i][j] = entry;
    }

    public static int[][] identity(){
        int [][] matrix = new int[matrix_len_4][matrix_len_4];

        for (int i = 0; i < matrix_len_4; i++) {
            for (int j = 0; j < matrix_len_4; j++) {
                if(i == j)
                    matrix[i][j] = 1;
                else
                    matrix[i][j] = 0;
            }
        }
        return matrix;
    }

    public int[][] multiply_matrix(int [][] mat1, int [][] mat2){

        int [][] matrix1 = new int[matrix_len_4][matrix_len_4];

        for(int i = 0; i< matrix_len_4; i++) {
            for (int j = 0; j < matrix_len_4; j++) {
                matrix1[i][j] = 0;
                for (int k = 0; k < matrix_len_4; k++) {
                    matrix1[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        return matrix1;
    }


}
