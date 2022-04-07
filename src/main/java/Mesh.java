import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL20;

import java.nio.FloatBuffer;

public class Mesh {
    private int vbo; // vertex buffer object
    private int size;

    public Mesh() {
        this.vbo = GL20.glGenBuffers();
        this.size = 0;
    }

    public Mesh(Vertex[] vertices) {
        this.vbo = GL20.glGenBuffers();
        this.size = 0;
        addVertices(vertices);
    }

    private void addVertices(Vertex[] vertices) {
        this.size += vertices.length;
        GL20.glBindBuffer(GL20.GL_ARRAY_BUFFER, this.vbo);
        GL20.glBufferData(GL20.GL_ARRAY_BUFFER, createFlippedBuffer(vertices), GL20.GL_STATIC_DRAW);
    }

    public void draw() {
        GL20.glEnableVertexAttribArray(0);

        GL20.glBindBuffer(GL20.GL_ARRAY_BUFFER, vbo);
        GL20.glVertexAttribPointer(0, 3, GL20.GL_FLOAT, false, Vertex.SIZE * 4, 0);

        GL20.glDrawArrays(GL20.GL_TRIANGLES, 0, size);

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

}
