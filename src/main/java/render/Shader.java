package render;
import maths.Matrix4f;
import maths.Vector3f;
import org.lwjgl.opengl.GL20;
import java.util.HashMap;

/**
 * Shader class Shader.java to manipulate an image before it is drawn to the screen
 */
public class Shader{
    private int program;
    private HashMap<String, Integer> uniforms;

    /**
     * This method takes uniform string and then shader links on it
     * @param uniform name of uniform
     */
    public void addUniform(String uniform){
        int location = GL20.glGetUniformLocation(this.program, uniform);
        assert(location != 0);

        uniforms.put(uniform, location);
    }

    /**
     * Constructor of shader for every shader call
     */
    public Shader() {
        this.program = GL20.glCreateProgram();
        if(this.program == 0){
            System.out.println("render.Shader creation failed!");
            System.exit(1);
        }
    }

    /**
     * Setter for uniform variable for int value
     * @param uniform uniform string
     * @param value int value
     */
    public void setUniformi(String uniform, int value){
        GL20.glUniform1i(uniforms.get(uniform), value);
    }

    /**
     *  Setter for uniform variable for float value
     * @param uniform uniform variable
     * @param value float value
     */
    public void setUniformf(String uniform, float value){
        GL20.glUniform1f(uniforms.get(uniform), value);
    }

    /**
     *  Setter for uniform variable for vector3f value
     * @param uniform uniform variable
     * @param value vector3f value
     */
    public void setUniform(String uniform, Vector3f value){
        GL20.glUniform3f(uniforms.get(uniform), value.getX(), value.getY(), value.getZ());
    }

    /**
     * Setter for uniform variable for matrix4f value
     * @param uniform uniform variable
     * @param value matrix4f value
     */
    public void setUniform(String uniform, Matrix4f value){
        GL20.glUniformMatrix4fv(uniforms.get(uniform), true, Mesh.createFlippedBuffer(value));
    }

    /**
     * This method activates program with current rendering state
     */
    public void bind() {
        GL20.glUseProgram(this.program);
    }

    /**
     * This method compiles GLSL shader into binary data
     */
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

    /**
     * This method uses shader object to attach it to program object
     * @param text path of shader
     * @param type type of shader
     */
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

    /**
     * Getter for current program
     * @return current program state(integer)
     */
    public int getProgram() {
        return program;
    }
}