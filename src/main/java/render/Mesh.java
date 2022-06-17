package render;

import maths.Matrix4f;
import org.lwjgl.BufferUtils;
import static org.lwjgl.opengl.GL15.glGenBuffers;
import static org.lwjgl.opengl.GL20.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL20.GL_ELEMENT_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL20.GL_FLOAT;
import static org.lwjgl.opengl.GL20.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL20.GL_TRIANGLES;
import static org.lwjgl.opengl.GL20.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL20.glBindBuffer;
import static org.lwjgl.opengl.GL20.glBufferData;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glDrawElements;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

/**
 * Mesh class Mesh.java to 3D geometric surface
 */
public class Mesh {
    private final int vbo; // vertex buffer object
    private final int ibo; // index buffer object
    private int size;

    /**
     * Constructor of mesh
     */
    public Mesh() {
        this.vbo = glGenBuffers();
        this.ibo = glGenBuffers();
        this.size = 0;
    }

    /**
     * Second constructor of mesh for vertices and indices
     */
    public Mesh(Vertex[] vertices, int[] indices) {
        this.vbo = glGenBuffers();
        this.ibo = glGenBuffers();
        this.size = 0;
        addVertices(vertices, indices);
    }

    /**
     * This function adds data from vertices to vertex buffer object and data from indices to index buffer object
     * @param vertices array of vertex
     * @param indices array of indices
     */
    public void addVertices(Vertex[] vertices, int[] indices) {
        this.size += indices.length;

        glBindBuffer(GL_ARRAY_BUFFER, this.vbo);
        glBufferData(GL_ARRAY_BUFFER, createFlippedBuffer(vertices), GL_STATIC_DRAW);

        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, this.ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, createFlippedBuffer(indices), GL_STATIC_DRAW);
    }

    /**
     * This method uses gl to draw mesh
     */
    public void draw() {
        glEnableVertexAttribArray(0);

        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, Vertex.SIZE * 4, 0);

        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glDrawElements(GL_TRIANGLES, this.size, GL_UNSIGNED_INT, 0);

        glDisableVertexAttribArray(0);
    }

    /**
     * This function returns buffer for vertices
     * @param vertices value of vertices
     * @return buffer value of vertices
     */
    public static FloatBuffer createFlippedBuffer(Vertex[] vertices) {
        FloatBuffer buffer = BufferUtils.createFloatBuffer(vertices.length * Vertex.SIZE);

        for (int i = 0; i < vertices.length; i++) {
            buffer.put(vertices[i].get().getX());
            buffer.put(vertices[i].get().getY());
            buffer.put(vertices[i].get().getZ());
        }

        buffer.flip();

        return buffer;
    }

    /**
     * This function return buffer for matrix
     * @param value value of 4x4 matrix
     * @return buffer value of matrix
     */
    public static FloatBuffer createFlippedBuffer(Matrix4f value) {
        FloatBuffer buffer = BufferUtils.createFloatBuffer(4 * 4);

        for(int i = 0; i < 4; i++)
            for(int j = 0; j < 4; j++)
                buffer.put(value.getCellValue(i, j));

        buffer.flip();

        return buffer;
    }

    /**
     * This function returns buffer for indices
     * @param indices value of indices
     * @return buffer value of indices
     */
    public static IntBuffer createFlippedBuffer(int[] indices) {
        IntBuffer buffer = BufferUtils.createIntBuffer(indices.length);
        buffer.put(indices);
        buffer.flip();
        return buffer;
    }

    /**
     * Getter for vertex buffer object
     * @return vertex buffer object
     */
    public int getVbo() {
        return vbo;
    }

    /**
     * Getter for index buffer object
     * @return index buffer object
     */
    public int getIbo() {
        return ibo;
    }

    /**
     * Getter for mesh size
     * @return size of mesh
     */
    public int getSize() {
        return size;
    }
}