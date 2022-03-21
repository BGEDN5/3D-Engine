import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.glfw.GLFWImage;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.system.MemoryUtil;

public class Window {

    private final int width;
    private final int height;
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
        if (!glfwInit()) {
            throw new RuntimeException("Window could not be initialised");
        }

        // Configurations for the Window
        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);
        glfwWindowHint(GLFW_FOCUSED, GLFW_TRUE);

        this.window = glfwCreateWindow(width, height, title, MemoryUtil.NULL, MemoryUtil.NULL);

        if (this.window == 0) {
            throw new RuntimeException("Window could not be created");
        }

        // Icon
        if (getIcon() != null) {
            glfwSetWindowIcon(this.window, getIcon());
        }

        // Window gets positioned in the center of the screen
        GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        if (vidMode == null) {
            throw new RuntimeException("GLFWVidMode is null.");
        }
        glfwSetWindowPos(this.window, (vidMode.width() - getWidth()) / 2, (vidMode.height() - getHeight()) / 2);

        glfwMakeContextCurrent(this.window);
        glfwShowWindow(this.window);

        // VSync
        glfwSwapInterval(1);
    }

    public void render() {
        glfwSwapBuffers(this.window);
    }

    public void update() {
        glfwPollEvents();
    }

    public void cleanup() {
        glfwDestroyWindow(this.window);
    }

    public boolean close() {
        boolean shouldClose = glfwWindowShouldClose(this.window);
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
}