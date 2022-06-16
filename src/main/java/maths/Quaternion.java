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

    public Quaternion normalize() {
        a = a / getLength();
        b = b / getLength();
        c = c / getLength();
        d = d / getLength();
        length = -1;
        return this;
    }

    public Quaternion conjugate() {
        b = -b;
        c = -c;
        d = -d;
        return this;
    }

    public Quaternion mult(Quaternion other) {
        a = a * other.a - b * other.b - c * other.c - d * other.d;
        b = a * other.b + b * other.a + c * other.d - d * other.c;
        c = a * other.c - b * other.d + c * other.a + d * other.b;
        d = a * other.d + b * other.c - c * other.b + d * other.a;
        return this;
    }

    public Quaternion mult(Vector3f r) {
        float w_ = -a * r.getX() - b * r.getY() - c * r.getZ();
        float x_ =  d * r.getX() + b * r.getZ() - c * r.getY();
        float y_ =  d * r.getY() + c * r.getX() - a * r.getZ();
        float z_ =  d * r.getZ() + a * r.getY() - b * r.getX();
        return this;
    }

    public float getA() {
        return a;
    }

    public Quaternion setA(float a) {
        this.a = a;
        return this;
    }

    public float getB() {
        return b;
    }

    public Quaternion setB(float b) {
        this.b = b;
        return this;
    }

    public float getC() {
        return c;
    }

    public Quaternion setC(float c) {
        this.c = c;
        return this;
    }

    public float getD() {
        return d;
    }

    public Quaternion setD(float d) {
        this.d = d;
        return this;
    }
}
