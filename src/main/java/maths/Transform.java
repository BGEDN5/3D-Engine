package maths;


import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Transform {

    private Vector3f translation = new Vector3f(0,0,0);
    private Vector3f rotation = new Vector3f(0,0,0);
    private Vector3f scale = new Vector3f(1,1,1);

    public Transform(Vector3f translation, Vector3f rotation, Vector3f scale) {
        this.translation = translation;
        this.rotation = rotation;
        this.scale = scale;
    }

    public Vector3f getTranslation(){
        return translation;
    }
    public void setTranslation(Vector3f otherTranslation){
        this.translation = otherTranslation;
    }
    public void setTranslation(float otherX,float otherY,float otherZ){
        translation.setX(otherX);
        translation.setY(otherY);
        translation.setZ(otherZ);
    }

    public Matrix4f getTransformation() {
        Matrix4f translationMatrix = getTranslationMatrix(this.translation);
        Matrix4f rotationMatrix = getRotationMatrix(this.rotation);
        Matrix4f scaleMatrix = getScaleMatrix(this.scale);
        rotationMatrix.multiply(scaleMatrix);
        translationMatrix.multiply(rotationMatrix);
        return translationMatrix;
    }


    public static Matrix4f getTranslationMatrix(float x, float y, float z) {
        return new Matrix4f(
                new float[][]{
                        {1, 0, 0, x}
                        , {0, 1, 0, y}
                        , {0, 0, 1, z}
                        , {0, 0, 0, 1}});
    }

    public static Matrix4f getRotationMatrix(float x, float y, float z) {
        x = (float) Math.toRadians(x);
        y = (float) Math.toRadians(y);
        z = (float) Math.toRadians(z);

        Matrix4f rz = new Matrix4f(
                new float[][]{

                        {(float) cos(z), (float) -sin(z), 0, 0}
                        , {(float) sin(z), (float) cos(z), 0, 0}
                        , {0, 0, 1, 0}
                        , {0, 0, 0, 1}});

        Matrix4f rx = new Matrix4f(
                new float[][]{
                        {1, 0, 0, 0}
                        , {0, (float) cos(x), (float) -sin(x), 0}
                        , {0, (float) sin(x), (float) cos(x), 0}
                        , {0, 0, 0, 1}});


        Matrix4f ry =
                new Matrix4f(
                        new float[][]{

                                {(float) cos(y), (float) -sin(y), 0, 0}
                                , {0, 1, 0, 0}
                                , {(float) sin(y), (float) cos(y), 1, 0}
                                , {0, 0, 0, 1}});


        ry.multiply(rx);
        rz.multiply(ry);
        return rz;

    }

    public static Matrix4f getScaleMatrix(float x, float y, float z) {
        return new Matrix4f(
                new float[][]{
                        {x, 0, 0, 0},
                        {0, y, 0, 0},
                        {0, 0, z, 0},
                        {0, 0, 0, 1}});
    }

}










