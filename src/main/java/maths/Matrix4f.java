package maths;

public class Matrix4f {

    public static final short MATRIX_LEN = 4;
    private float[][] matrix;
    private float[] elements;

    public Matrix4f(float [][] matrix){
        this.matrix = matrix;
    }

    public Matrix4f(float [][] matrix, float [] elements){
        this.matrix = matrix;
        this.elements = elements;
    }

    public float[][] getMatrix(){
        return this.matrix;
    }

    public float getCellValue(int i, int j){
        return this.elements[j * MATRIX_LEN + i];
    }

    public float[] getElements() {
        return elements;
    }

    public void setMatrix(float[][] matrix){
        this.matrix = matrix;
    }

    public void setSeparateCell(int i, int j, float entry){
        this.elements[j * MATRIX_LEN + i] = entry;
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

    public void multiply(Matrix4f other){

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
    }


}
