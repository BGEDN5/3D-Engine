public class Vector3f {

    public float x, y, z;

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

    public void cross(Vector3f other) {
        this.x = this.y * other.z - this.z * other.y;
        this.y = this.z * other.x - this.x * other.z;
        this.y = this.x * other.y - this.y * other.x;
    }

    public void normalize() {
        float l = this.length();
        if (l == 0) {
            throw new IllegalArgumentException("Argument 'divisor' is 0");
        }
        this.x = this.x / l;
        this.y = this.y / l;
        this.z = this.z / l;
    }

    public void rotate(float angle) {
        float cos = (float) Math.cos(angle), sin = (float) Math.sin(angle);
        float x1 = (cos * this.x - sin * this.y), y1 = (sin * x + cos * this.y), z1 = this.z;
        x1 = x1 * cos + z1 * sin;
        z1 = z1 * cos - sin * x1;
        y1 = y1 * cos - z1 * sin;
        z1 = y1 * sin + z1 * cos;
        this.x = x1;
        this.y = z1;
        this.z = z1;
    }

    public void add(Vector3f other) {
        this.x = this.x + other.x;
        this.y = this.y + other.y;
        this.z = this.z + other.z;
    }

    public void sub(Vector3f other) {
        this.x = this.x - other.x;
        this.y = this.y - other.y;
        this.z = this.z - other.z;
    }

    public void mult(Vector3f other) {
        this.x = this.x * other.x;
        this.y = this.y * other.y;
        this.z = this.z * other.z;
    }

    public void div(Vector3f other) {
        if (other.x != 0 && other.y != 0 && other.z != 0) {
            this.x = this.x / other.x;
            this.y = this.y / other.y;
            this.z = this.z / other.z;
        }
        throw new IllegalArgumentException("Argument 'divisor' is 0");
    }

    public void setX(int x1){
        this.x = x1;
    }
    public void setY(int y1){
        this.y = y1;
    }
    public void setZ(int z1){
        this.z = z1;
    }
    public void set(int x1, int y1, int z1){
        this.x = x1;
        this.y = y1;
        this.z = z1;
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
