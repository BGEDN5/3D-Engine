import java.awt.event.KeyEvent;
import java.io.IOException;
import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;

public class Demo implements Game {
    private Mesh m;
    private Shader sh;

    public Demo() {

    }

    public void init() {
        m = new Mesh();
        m.addVertices(new Vertex[]{ new Vertex(0.1f, 0.2f, 0.3f), new Vertex(2f, 3f, 2.4f), new Vertex() });

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
    }

    @Override
    public void render() {
        System.out.println("render");
        sh.bind();
        m.draw();
    }

}













//
//
//
//
//import java.awt.event.KeyEvent;
//
//public class presentationMain  {
//
//    static Engine engine = new Engine(new Game() {
//        @Override
//        public void update() {
//
//        }
//
//        @Override
//        public void render() {
//
//        }
//    });
//
//    static boolean wasPressedOnce = false;
//
//    public static void keyDemo() throws InterruptedException {
//        if (engine.getInput().isKeyPressed(KeyEvent.VK_A)) {
//            System.out.println("A key is pressed");
//            wasPressedOnce = true;
//        }
//        if (engine.getInput().isKeyPressed(KeyEvent.VK_S)) {
//            System.out.println("S key is pressed");
//            wasPressedOnce = true;
//        }
//        if (engine.getInput().isKeyPressed(KeyEvent.VK_D)) {
//            System.out.println("D key is pressed");
//            wasPressedOnce = true;
//        }
//
//        if (engine.getInput().isKeyPressed(KeyEvent.VK_W)) {
//            System.out.println("W key is pressed");
//            wasPressedOnce = true;
//        }
//    }
//
//
//    public static void main(String[] args) throws InterruptedException {
//
//        engine.start();
//        int i = 300000;
//        while (i>0){
//            System.out.println(engine.getInput().getCursorX() + " " + engine.getInput().getCursorY());
//            System.out.println(1/engine.getTime().getDeltaTime()*1000000000);
//            keyDemo();
//            i--;
//        }
//        System.out.println(wasPressedOnce);
//    }
//
//}
//
