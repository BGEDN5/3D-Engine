package maths;

/**
 * Math class Vector2f.java for simple mathematical operation on 2-dimensional vector
 */
public class Vector2f {

    private float x, y;

    /**
     * initializes two-dimensional vector at origin
     */
    public Vector2f(){
        this.x = 0F;
        this.y = 0F;
    }

    /**
     * initializes two-dimensional vector at given coordinates
     * @param x1 value of x-axis
     * @param y1 value of x-axis
     */
    public Vector2f(float x1, float y1) {
        this.x = x1;
        this.y = y1;
    }

    /**
     * Returns length of this object using Pythagoras's theorem
     * @return length/magnitude of this vector
     */
    public float length() {
        return (float) Math.sqrt(this.x * this.x + this.y * this.y);
    }

    /**
     * Returns dot product of this and argument vectors
     * @param other other two-dimensional vector
     * @return dot product
     */
    public float dot(Vector2f other) {
        return other.x * this.x + other.y * this.y;
    }

    /**
     * null
     * @param other vector to cross product this with
     * @return null
     */
    public Vector2f cross(Vector2f other) {
        return null;
    }

    /**
     * Normalizes this vector. Divides all the point by length of vector
     * @return this object
     * @throws IllegalArgumentException if length of this vector is zero
     */
    public Vector2f normalize() {
        float l = this.length();
        if (l == 0) {
            throw new IllegalArgumentException("Argument 'divisor' is 0");
        }
        this.x = this.x / l;
        this.y = this.y / l;
        return this;
    }

    /**
     * Rotates this vector by angle in degrees.
     * @param angle angle in witch vector will be rotated
     * @return this object
     */
    public Vector2f rotate(float angle) {
        float cos = (float) Math.cos(angle);
        float sin = (float) Math.sin(angle);
        this.x = (cos * x - sin * y);
        this.y = (sin * x + cos * y);
        return this;
    }

    /**
     * Adds argument vector to this vector. Increment every coordinate with argument vectors respective coordinate.
     * @param other vector value to increment this by
     * @return this object
     */
    public Vector2f add(Vector2f other) {
        this.x = this.x + other.x;
        this.y = this.y + other.y;
        return this;
    }

    /**
     * Subtracts argument vector to this vector. Decrement every coordinate with argument vectors respective coordinate.
     * @param other vector value to decrement this by
     * @return this object
     */
    public Vector2f sub(Vector2f other) {
        this.x = this.x - other.x;
        this.y = this.y - other.y;
        return this;
    }

    /**
     * Multiples this vector by argument Vector. Multiples every coordinate of this vector by argument vectors respective coordinate.
     * @param other vector value to multiply this by
     * @return this object
     */
    public Vector2f mult(Vector2f other) {
        this.x = this.x * other.x;
        this.y = this.y * other.y;
        return this;
    }

    /**
     * Divides this vector by argument Vector. Divides every coordinate of this vector by argument vectors respective coordinate.
     * @param other vector value to divide this by
     * @return this object
     * @throws IllegalArgumentException  if divisor has zero parameter
     */
    public Vector2f div(Vector2f other) {
        if (other.x != 0 && other.y != 0) {
            this.x = this.x / other.x;
            this.y = this.y / other.y;
            return this;
        }
        throw new IllegalArgumentException("Argument 'divisor' is 0");
    }

    /**
     * sets x parameter for this object
     * @param x1 value to be set
     * @return this object
     */
    public Vector2f setX(float x1){
        this.x = x1;
        return this;
    }
    /**
     * sets y parameter for this object
     * @param y1 value to be set
     * @return this object
     */
    public Vector2f setY(float y1){
        this.y = y1;
        return this;
    }

    /**
     * sets both parameters ot this object
     * @param x1 value to be set to x
     * @param y1 value to be set to y
     * @return this object
     */
    public Vector2f set(float x1, float y1){
        this.x = x1;
        this.y = y1;
        return this;
    }

    /**
     * @return x of this object
     */
    public float getX(){
        return this.x;
    }
    /**
     * @return y of this object
     */
    public float getY(){
        return this.y;
    }

}
