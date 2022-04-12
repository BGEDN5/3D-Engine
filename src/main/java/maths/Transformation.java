package maths;


import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Transformation {

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










