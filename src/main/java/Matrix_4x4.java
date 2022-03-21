public class Matrix4f {

    private static final short MATRIX_LEN = 4;
    private float[][] matrix;

    public Matrix_4x4(float [][] matrix){
        this.matrix = matrix;
    }

    public float[][] getMatrix() {
        return matrix;
    }

    public float getCellValue(int i, int j){
        return matrix[i][j];
    }

    public void setMatrix(float[][] matrix) {
        this.matrix = matrix;
    }

    public void setSeparateCell(int i, int j, int entry){
        this.matrix[i][j] = entry;
    }

    public static Matrix4f identity(){
        int [][] matrix = new int[matrix_len_4][matrix_len_4];

        for (int i = 0; i < matrix_len_4; i++) {
            for (int j = 0; j < matrix_len_4; j++) {
                matrix[i][j] = (i == j) ? 1 : 0;
            }
        }
        return matrix;
    }

    public void multiply(Matrix4f other){
              ....
    }


}
