import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWImage;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.system.MemoryUtil;

public class Window {

    private int width;
    private int height;
    private final String title;
    private long window;
    private final GLFWImage.Buffer icon;

    public Window(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
        this.icon = null;
    }

    public Window(int width, int height, String title, GLFWImage.Buffer icon) {
        this.width = width;
        this.height = height;
        this.title = title;
        this.icon = icon;
    }

    public void init() {
        if (!GLFW.glfwInit()) {
            throw new RuntimeException("Window could not be initialised");
        }
        this.window = GLFW.glfwCreateWindow(width, height, title, MemoryUtil.NULL, MemoryUtil.NULL);
        if (this.window == 0) {
            throw new RuntimeException("Window could not be created");
        }

        // Icon
        if (getIcon() != null) {
            GLFW.glfwSetWindowIcon(this.window, getIcon());
        }

        // Window gets displayed in the center of the screen
        GLFWVidMode vidMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
        GLFW.glfwSetWindowPos(this.window, (vidMode.width() - getWidth()) / 2, (vidMode.height() - getHeight()) / 2);
        GLFW.glfwShowWindow(this.window);
    }

    public void render() {
        GLFW.glfwSwapBuffers(this.window);
    }

    public void update() {
        GLFW.glfwPollEvents();
    }

    public void cleanup() {
        GLFW.glfwDestroyWindow(this.window);
    }

    public boolean close() {
        return GLFW.glfwWindowShouldClose(this.window);
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

    public GLFWImage.Buffer getIcon() {
        return icon;
    }


    // Tester
    public static void main(String[] args) {
        Thread thread = new Thread(new Test());
        thread.start();
    }

    static class Test implements Runnable {
        static Window window;

        public static void init() {
            window = new Window(500, 500, "Test Window");
            window.init();
        }

        @Override
        public void run() {
            init();
            while (!window.close()) {
                window.update();
                window.render();
            }
            window.cleanup();
        }


    }
}



