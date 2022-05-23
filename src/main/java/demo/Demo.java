package demo;

import core.Game;
import core.Input;
import maths.Matrix4f;
import maths.Transform;
import maths.Vector3f;
import render.Mesh;
import render.Shader;
import render.Vertex;
import utils.Utils;

import java.io.IOException;
import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;

public class Demo implements Game {
    private Mesh m;
    private Shader sh;

    public Demo() {

    }

    public void init() {


        Transform transform = new Transform();

        Vertex starterVertex = new Vertex(-1.1f, 1.1f, 1f);
        Vertex starterVertex2 = new Vertex(1.1f, 1.1f, 1f);
        Vertex starterVertex3 = new Vertex();

        Matrix4f scaleMatrix = transform.getRotationMatrix(0,0,-90);

        Vertex newVertex = matrixVectorMult(starterVertex,scaleMatrix);
        Vertex newVertex2 = matrixVectorMult(starterVertex2,scaleMatrix);
        Vertex newVertex3 = matrixVectorMult(starterVertex3,scaleMatrix);

        m = new Mesh();
        m.addVertices(new Vertex[]{newVertex, newVertex2, newVertex3 });

        sh = new Shader();



        try {
            sh.addProgram(Utils.loadResource("src/main/resources/shaders/v1/myVShader.glsl"), GL_VERTEX_SHADER);
            sh.addProgram(Utils.loadResource("src/main/resources/shaders/v1/myFShader.glsl"), GL_FRAGMENT_SHADER);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sh.compileShader();
    }

    public void input() {

    }

    @Override
    public void update() {
        System.out.println("update");
        System.out.println(Input.getCursorX() + " " + Input.getCursorY());
    }

    @Override
    public void render() {
        System.out.println("render");
        sh.bind();
        m.draw();
    }

    public static Vertex matrixVectorMult(Vertex vertex, Matrix4f matrix){
        return new Vertex(
                matrix.getCellValue(0,0)*vertex.get().getX()+
                        matrix.getCellValue(0,1)*vertex.get().getY()+
                        matrix.getCellValue(0,2)*vertex.get().getZ()+matrix.getCellValue(0,3),
                matrix.getCellValue(1,0)*vertex.get().getX()+
                        matrix.getCellValue(1,1)*vertex.get().getY()+
                        matrix.getCellValue(1,2)*vertex.get().getZ()+matrix.getCellValue(1,3),
                matrix.getCellValue(2,0)*vertex.get().getX()+
                        matrix.getCellValue(2,1)*vertex.get().getY()+
                        matrix.getCellValue(2,2)*vertex.get().getZ()+matrix.getCellValue(2,3)
        );
    }

}