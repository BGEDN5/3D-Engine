package render;
import maths.Matrix4f;
import maths.Vector3f;
import org.lwjgl.opengl.GL20;
import java.util.HashMap;

public class Shader{
    private int program;
    private HashMap<String, Integer> uniforms;
    public void addUniform(String uniform){
        int location = GL20.glGetUniformLocation(this.program, uniform);
        assert(location != 0);

        uniforms.put(uniform, location);
    }

    public Shader() {
        this.program = GL20.glCreateProgram();
        if(this.program == 0){
            System.out.println("render.Shader creation failed!");
            System.exit(1);
        }
    }

    public void setUniformi(String uniform, int value){
        GL20.glUniform1i(uniforms.get(uniform), value);
    }

    public void setUniformf(String uniform, float value){
        GL20.glUniform1f(uniforms.get(uniform), value);
    }

    public void setUniform(String uniform, Vector3f value){
        GL20.glUniform3f(uniforms.get(uniform), value.getX(), value.getY(), value.getZ());
    }

    public void setUniform(String uniform, Matrix4f value){
        GL20.glUniformMatrix4fv(uniforms.get(uniform), true, Buffer.createFlippedBuffer(value));
    }

    public void bind() {
        GL20.glUseProgram(this.program);
    }

    public void compileShader() {
        GL20.glLinkProgram(program);
        if(GL20.glGetProgrami(program, GL20.GL_LINK_STATUS) == 0) {
            GL20.glGetProgramInfoLog(program, 1024);
            System.exit(1);
        }

        GL20.glValidateProgram(program);
        if(GL20.glGetProgrami(program, GL20.GL_VALIDATE_STATUS) == 0) {
            GL20.glGetProgramInfoLog(program, 1024);
            System.exit(1);
        }
    }

    public void addProgram(String text, int type) {
        int shader = GL20.glCreateShader(type);
        if(shader == 0){
            System.out.println("render.Shader creation failed!");
            System.exit(1);
        }

        GL20.glShaderSource(shader, text);
        GL20.glCompileShader(shader);
        if(GL20.glGetShaderi(shader, GL20.GL_COMPILE_STATUS) == 0){
            GL20.glGetShaderInfoLog(shader, 1024);
            System.exit(1);
        }

        GL20.glAttachShader(program, shader);
    }

    public int getProgram() {
        return program;
    }
}