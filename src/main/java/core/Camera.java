package core;

import maths.Vector3f;


public class Camera {
    public static final Vector3f yAxis = new Vector3f(0, 1, 0);

    private Vector3f position;
    private Vector3f forward;
    private Vector3f up;

    public Camera() {
        this(new Vector3f(0, 0, 0), new Vector3f(0, 0, 1), new Vector3f(0, 1, 0));
    }

    public Camera(Vector3f position, Vector3f forward, Vector3f up) {
        this.position = position;
        this.forward = forward;
        this.up = up;

        forward.normalize();
        up.normalize();
    }

    public void move(Vector3f direction, float amount) {
        Vector3f vector = new Vector3f(direction.getX() * amount, direction.getY() * amount, direction.getZ() * amount);
        position.add(vector);
    }

    public Vector3f getLeft() {
        return up.cross(forward).normalize();
    }

    public Vector3f getRight() {
        return forward.cross(up).normalize();
    }

    public void rotateX(float angle) {
        Vector3f horizontalAxis = yAxis.cross(forward).normalize();
        forward.rotate(angle, horizontalAxis).normalize();
        up = forward.cross(horizontalAxis).normalize();
    }

    public void rotateY(float angle) {
        Vector3f horizontalAxis = yAxis.cross(forward).normalize();
        forward.rotate(angle, yAxis).normalize();
        up = forward.cross(horizontalAxis).normalize();
    }

    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(Vector3f position) {
        this.position = position;
    }

    public Vector3f getForward() {
        return forward;
    }

    public void setForward(Vector3f forward) {
        this.forward = forward;
    }

    public Vector3f getUp() {
        return up;
    }

    public void setUp(Vector3f up) {
        this.up = up;
    }
}
