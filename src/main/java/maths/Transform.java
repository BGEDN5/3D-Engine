package maths;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Transform {

    private Vector3f translation = new Vector3f(0, 0, 0);
    private Vector3f rotation = new Vector3f(0, 0, 0);
    private Vector3f scale = new Vector3f(1, 1, 1);

    public Transform(Vector3f translation, Vector3f rotation, Vector3f scale) {
        this.translation = translation;
        this.rotation = rotation;
        this.scale = scale;
    }

    public  Transform(){

    }

    public Vector3f getTranslation() {
        return translation;
    }

    public Transform setTranslation(Vector3f other) {
        this.translation = other;
        return this;
    }

    public Vector3f getRotation() {
        return rotation;
    }

    public Transform setRotation(Vector3f other) {
        this.rotation = other;
        return this;
    }

    public Vector3f getScale() {
        return scale;
    }

    public Transform setScale(Vector3f other) {
        this.scale = other;
        return this;
    }

    public Transform setTranslation(float X, float Y, float Z) {
        translation.setX(X);
        translation.setY(Y);
        translation.setZ(Z);
        return this;
    }

    public Matrix4f getTransformation() {
        Matrix4f translationMatrix = getTranslationMatrix(this.translation.getX(), this.translation.getY(), this.translation.getZ());
        Matrix4f rotationMatrix = getRotationMatrix(this.translation.getX(), this.translation.getY(), this.translation.getZ());
        Matrix4f scaleMatrix = getScaleMatrix(this.scale.getX(), this.scale.getY(), this.scale.getZ());
        rotationMatrix.multiply(scaleMatrix);
        translationMatrix.multiply(rotationMatrix);
        return translationMatrix;
    }

    public static Matrix4f getTranslationMatrix(float x, float y, float z) {
        return new Matrix4f(
                new float[][]{ {1, 0, 0, 0}
                        , {0, (float) cos(x), (float) -sin(x), 0}
                        , {0, (float) sin(x), (float) cos(x), 0}
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