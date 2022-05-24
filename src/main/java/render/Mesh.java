package render;

import maths.Matrix4f;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL20;

import java.nio.FloatBuffer;


public class Mesh {

    private int vbo; // vertex buffer object
    private int ibo; // index buffer object
    private int size;

    public Mesh() {
        this.vbo = GL20.glGenBuffers();
        this.ibo = GL20.glGenBuffers();
        this.size = 0;
    }

    public Mesh(Vertex[] vertices) {
        this.vbo = GL20.glGenBuffers();
        this.size = 0;
        addVertices(vertices);
    }


    public void addVertices(Vertex[] vertices) {
        this.size += vertices.length;
        GL20.glBindBuffer(GL20.GL_ARRAY_BUFFER, this.vbo);
        GL20.glBufferData(GL20.GL_ARRAY_BUFFER, createFlippedBuffer(vertices), GL20.GL_STATIC_DRAW);

        GL20.glBindBuffer(GL20.GL_ARRAY_BUFFER, this.ibo);
        GL20.glBufferData(GL20.GL_ARRAY_BUFFER, createFlippedBuffer(vertices), GL20.GL_STATIC_DRAW);
    }

    public void draw() {
        GL20.glEnableVertexAttribArray(0);

        GL20.glBindBuffer(GL20.GL_ARRAY_BUFFER, vbo);
        GL20.glVertexAttribPointer(0, 3, GL20.GL_FLOAT, false, Vertex.SIZE * 4, 0);

        GL20.glBindBuffer(GL20.GL_ELEMENT_ARRAY_BUFFER, ibo);
        GL20.glDrawElements(GL20.GL_TRIANGLES, this.size, GL20.GL_UNSIGNED_INT, 0);

        GL20.glDisableVertexAttribArray(0);
    }

    public static FloatBuffer createFlippedBuffer(Vertex[] vertices) {
        FloatBuffer buffer = BufferUtils.createFloatBuffer(vertices.length * Vertex.SIZE);

        for(int i = 0; i < vertices.length; i++) {
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

    public int getVbo() {
        return vbo;
    }

    public int getSize() {
        return size;
    }
}
