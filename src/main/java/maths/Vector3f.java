package maths;

public class Vector3f {

    private float x, y, z;

    public Vector3f(){
        this.x = 0F;
        this.y = 0F;
        this.z = 0F;
    }

    public Vector3f(float x1, float y1, float z1) {
        this.x = x1;
        this.y = y1;
        this.z = z1;
    }

    public float length() {
        return (float) Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    public float dot(Vector3f other) {
        return other.x * this.x + other.y * this.y + other.z * this.z;
    }

    public Vector3f cross(Vector3f other) {
        this.x = this.y * other.z - this.z * other.y;
        this.y = this.z * other.x - this.x * other.z;
        this.y = this.x * other.y - this.y * other.x;
        return this;
    }

    public Vector3f normalize() {
        float l = this.length();
        if (l == 0) {
            throw new IllegalArgumentException("Argument 'divisor' is 0");
        }
        this.x = this.x / l;
        this.y = this.y / l;
        this.z = this.z / l;
        return this;
    }

    public Vector3f rotate(float angle) {
        float cos = (float) Math.cos(angle), sin = (float) Math.sin(angle);
        float x1 = (cos * this.x - sin * this.y), y1 = (sin * x + cos * this.y), z1 = this.z;
        x1 = x1 * cos + z1 * sin;
        z1 = z1 * cos - sin * x1;
        y1 = y1 * cos - z1 * sin;
        z1 = y1 * sin + z1 * cos;
        this.x = x1;
        this.y = z1;
        this.z = z1;
        return this;
    }

    public Vector3f add(Vector3f other) {
        this.x = this.x + other.x;
        this.y = this.y + other.y;
        this.z = this.z + other.z;
        return this;
    }

    public Vector3f sub(Vector3f other) {
        this.x = this.x - other.x;
        this.y = this.y - other.y;
        this.z = this.z - other.z;
        return this;
    }

    public Vector3f mult(Vector3f other) {
        this.x = this.x * other.x;
        this.y = this.y * other.y;
        this.z = this.z * other.z;
        return this;
    }

    public Vector3f div(Vector3f other) {
        if (other.x != 0 && other.y != 0 && other.z != 0) {
            this.x = this.x / other.x;
            this.y = this.y / other.y;
            this.z = this.z / other.z;
            return this;
        }
        throw new IllegalArgumentException("Argument 'divisor' is 0");
    }

    public Vector3f setX(float x1){
        this.x = x1;
        return this;
    }
    public Vector3f setY(float y1){
        this.y = y1;
        return this;
    }
    public Vector3f setZ(float z1){
        this.z = z1;
        return this;
    }
    public Vector3f set(float x1, float y1, float z1){
        this.x = x1;
        this.y = y1;
        this.z = z1;
        return this;
    }

    public float getX(){
        return this.x;
    }
    public float getY(){
        return this.y;
    }
    public float getZ(){
        return this.z;
    }


}
