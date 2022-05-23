package maths;

public class Vector2f {

    private float x, y;

    public Vector2f(){
        this.x = 0F;
        this.y = 0F;
    }

    public Vector2f(float x1, float y1) {
        this.x = x1;
        this.y = y1;
    }

    public float length() {
        return (float) Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public float dot(Vector2f other) {
        return other.x * this.x + other.y * this.y;
    }

    public Vector2f cross(Vector2f other) {
        return null;
    }

    public Vector2f normalize() {
        float l = this.length();
        if (l == 0) {
            throw new IllegalArgumentException("Argument 'divisor' is 0");
        }
        this.x = this.x / l;
        this.y = this.y / l;
        return this;
    }

    public Vector2f rotate(float angle) {
        float cos = (float) Math.cos(angle);
        float sin = (float) Math.sin(angle);
        this.x = (cos * x - sin * y);
        this.y = (sin * x + cos * y);
        return this;
    }

    public Vector2f add(Vector2f other) {
        this.x = this.x + other.x;
        this.y = this.y + other.y;
        return this;
    }

    public Vector2f sub(Vector2f other) {
        this.x = this.x - other.x;
        this.y = this.y - other.y;
        return this;
    }

    public Vector2f mult(Vector2f other) {
        this.x = this.x * other.x;
        this.y = this.y * other.y;
        return this;
    }

    public Vector2f div(Vector2f other) {
        if (other.x != 0 && other.y != 0) {
            this.x = this.x / other.x;
            this.y = this.y / other.y;
            return this;
        }
        throw new IllegalArgumentException("Argument 'divisor' is 0");
    }

    public Vector2f setX(float x1){
        this.x = x1;
        return this;
    }
    public Vector2f setY(float y1){
        this.y = y1;
        return this;
    }
    public Vector2f set(float x1, float y1){
        this.x = x1;
        this.y = y1;
        return this;
    }

    public float getX(){
        return this.x;
    }
    public float getY(){
        return this.y;
    }

}
