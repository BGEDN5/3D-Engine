import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.glfw.GLFWImage;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryUtil;

public class Window {

    private final int width;
    private final int height;
    private final String title;
    private static long window;
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
        if (!glfwInit()) {
            throw new RuntimeException("Window could not be initialised");
        }

        // Configurations for the Window
        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);
        glfwWindowHint(GLFW_FOCUSED, GLFW_TRUE);

        window = glfwCreateWindow(width, height, title, MemoryUtil.NULL, MemoryUtil.NULL);

        if (window == 0) {
            throw new RuntimeException("Window could not be created");
        }

        // Icon
        if (getIcon() != null) {
            glfwSetWindowIcon(window, getIcon());
        }

        // Window gets positioned in the center of the screen
        GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        if (vidMode == null) {
            throw new RuntimeException("GLFWVidMode is null.");
        }
        glfwSetWindowPos(window, (vidMode.width() - getWidth()) / 2, (vidMode.height() - getHeight()) / 2);

        glfwMakeContextCurrent(window);

        // VSync
        glfwSwapInterval(1);

        glfwShowWindow(window);

        GL.createCapabilities();
    }

    public void render() {
        glfwSwapBuffers(window);
    }

    public void update() {
        glfwPollEvents();
    }

    public void cleanup() {
        glfwDestroyWindow(window);
        glfwTerminate();
    }

    public boolean close() {
        boolean shouldClose = glfwWindowShouldClose(window);
        if (shouldClose) {
            cleanup();
        }
        return shouldClose;
    }

    // Getters for the attributes
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

    public static long getWindow() {
        return window;
    }

}
