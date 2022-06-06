package render;

import maths.Matrix4f;
import org.lwjgl.BufferUtils;

import static org.lwjgl.opengl.GL15.glGenBuffers;
import static org.lwjgl.opengl.GL20.*;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class Mesh {
    private final int vbo; // vertex buffer object
    private final int ibo; // index buffer object
    private int size;

    public Mesh() {
        this.vbo = glGenBuffers();
        this.ibo = glGenBuffers();
        this.size = 0;
    }

    public Mesh(Vertex[] vertices, int[] indices) {
        this.vbo = glGenBuffers();
        this.ibo = glGenBuffers();
        this.size = 0;
        addVertices(vertices, indices);
    }

    public void addVertices(Vertex[] vertices, int[] indices) {
        this.size += indices.length;

        glBindBuffer(GL_ARRAY_BUFFER, this.vbo);
        glBufferData(GL_ARRAY_BUFFER, createFlippedBuffer(vertices), GL_STATIC_DRAW);

        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, this.ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, createFlippedBuffer(indices), GL_STATIC_DRAW);
    }

    public void draw() {
        glEnableVertexAttribArray(0);

        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, Vertex.SIZE * 4, 0);

        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glDrawElements(GL_TRIANGLES, this.size, GL_UNSIGNED_INT, 0);

        glDisableVertexAttribArray(0);
    }

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

    public static FloatBuffer createFlippedBuffer(Matrix4f value) {
        FloatBuffer buffer = BufferUtils.createFloatBuffer(4 * 4);

        for(int i = 0; i < 4; i++)
            for(int j = 0; j < 4; j++)
                buffer.put(value.getCellValue(i, j));

        buffer.flip();

        return buffer;
    }

    public static IntBuffer createFlippedBuffer(int[] indices) {
        IntBuffer buffer = BufferUtils.createIntBuffer(indices.length);
        buffer.put(indices);
        buffer.flip();
        return buffer;
    }

    public int getVbo() {
        return vbo;
    }

    public int getIbo() {
        return ibo;
    }

    public int getSize() {
        return size;
    }
}