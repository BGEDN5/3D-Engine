package maths;

public class Matrix4f {

    public static final short MATRIX_LEN = 4;
    private float[][] matrix;

    public Matrix4f(float [][] matrix){
        this.matrix = matrix;
    }

    public float[][] getMatrix(){
        return this.matrix;
    }

    public float getCellValue(int i, int j){
        return this.matrix[i][j];
    }

    public Matrix4f setMatrix(float[][] matrix){
        this.matrix = matrix;
        return this;
    }

    public Matrix4f setSeparateCell(int i, int j, float entry){
        this.matrix[i][j] = entry;
        return this;
    }

    public static Matrix4f identity(){
        float[][] idMat = new float[MATRIX_LEN][MATRIX_LEN];

        for(int i = 0; i < MATRIX_LEN; i++){
            for(int j = 0; j < MATRIX_LEN; j++){
                idMat[i][j] = (i == j) ? 1 : 0;
            }
        }
        return new Matrix4f(idMat);
    }

    public Matrix4f multiply(Matrix4f other){

        float[][] tempMat = new float[MATRIX_LEN][MATRIX_LEN];

        for(int i = 0; i< MATRIX_LEN; i++){
            for(int j = 0; j < MATRIX_LEN; j++){
                tempMat[i][j] = 0;
                for(int k = 0; k < MATRIX_LEN; k++){
                    tempMat[i][j] += getMatrix()[i][k] * other.getMatrix()[k][j];
                }
            }
        }
        setMatrix(tempMat);
        return this;
    }


}
