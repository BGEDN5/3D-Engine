public class Matrix4f {

    private static final short MATRIX_LEN = 4;
    private float[][] matrix;

    public Matrix4f(float [][] matrix){
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

    public void setSeparateCell(int i, int j, float entry){
        this.matrix[i][j] = entry;
    }

    public static Matrix4f identity(){
        float[][] id_mat = new float[MATRIX_LEN][MATRIX_LEN];

        for (int i = 0; i < MATRIX_LEN; i++) {
            for (int j = 0; j < MATRIX_LEN; j++) {
                id_mat[i][j] = (i == j) ? 1 : 0;
            }
        }
        return new Matrix4f(id_mat);
    }

    public void multiply(Matrix4f other){

        float[][] temp_mat = new float[MATRIX_LEN][MATRIX_LEN];

        for(int i = 0; i< MATRIX_LEN; i++) {
            for (int j = 0; j < MATRIX_LEN; j++) {
                temp_mat[i][j] = 0;
                for (int k = 0; k < MATRIX_LEN; k++) {
                    temp_mat[i][j] += getMatrix()[i][k] * other.getMatrix()[k][j];
                }
            }
        }
        setMatrix(temp_mat);
    }


}
