package maths;

public class Quaternion {

    private float a;
    private float b;
    private float c;
    private float d;

    private float length = -1;

    public Quaternion(float a, float b, float c, float d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public float getLength() {
        if (length < 0) {
            length = (float) Math.sqrt(a * a + b * b + c * c + d * d);
        }
        return length;
    }

    public void normalize() {
        a = a / getLength();
        b = b / getLength();
        c = c / getLength();
        d = d / getLength();
        length = -1;
    }

    public void conjugate() {
        b = -b;
        c = -c;
        d = -d;
    }

    public void mult(Quaternion other) {
        a = a * other.a - b * other.b - c * other.c - d * other.d;
        b = a * other.b + b * other.a + c * other.d - d * other.c;
        c = a * other.c - b * other.d + c * other.a + d * other.b;
        d = a * other.d + b * other.c - c * other.b + d * other.a;
    }

    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public float getC() {
        return c;
    }

    public void setC(float c) {
        this.c = c;
    }

    public float getD() {
        return d;
    }

    public void setD(float d) {
        this.d = d;
    }
}
