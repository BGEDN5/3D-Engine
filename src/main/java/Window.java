import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.system.MemoryUtil;

public class Window {

    private int width;
    private int height;
    private final String title;
    private long window;

    public Window(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    public void init() {
        if (!GLFW.glfwInit()) {
            throw new RuntimeException("Window could not be initialised");
        }
        window = GLFW.glfwCreateWindow(width, height, title, MemoryUtil.NULL, MemoryUtil.NULL);
        if (window == 0) {
            throw new RuntimeException("Window could not be created");
        }

        GLFWVidMode vidMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
//        GLFW.glfwSetWindowPos(window, (vidMode.width() - getWidth()) / 2, (vidMode.height() - getHeight()) / 2);
    }

    public void render() {

    }

    public void update() {

    }

    public void cleanup() {
        GLFW.glfwDestroyWindow(window);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getTitle() {
        return title;
    }

    public static void main(String[] args) {
        Window window = new Window(500, 500, "Test Window");
        window.init();
    }
}



