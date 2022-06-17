package core;

import static org.lwjgl.glfw.GLFW.GLFW_FALSE;
import static org.lwjgl.glfw.GLFW.GLFW_FOCUSED;
import static org.lwjgl.glfw.GLFW.GLFW_RESIZABLE;
import static org.lwjgl.glfw.GLFW.GLFW_TRUE;
import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
import static org.lwjgl.glfw.GLFW.glfwDestroyWindow;
import static org.lwjgl.glfw.GLFW.glfwGetPrimaryMonitor;
import static org.lwjgl.glfw.GLFW.glfwGetVideoMode;
import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSetWindowIcon;
import static org.lwjgl.glfw.GLFW.glfwSetWindowPos;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwSwapInterval;
import static org.lwjgl.glfw.GLFW.glfwTerminate;
import static org.lwjgl.glfw.GLFW.glfwWindowHint;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;
import org.lwjgl.glfw.GLFWImage;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryUtil;

/**
 * Window class Window.java for initialising window
 */
public class Window {

    private final int width;
    private final int height;
    private final String title;
    private static long window;
    private final GLFWImage.Buffer icon;

    /**
     * Constructor of window
     * @param width width of window
     * @param height height of window
     * @param title title of window
     */
    public Window(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
        this.icon = null;
    }

    /**
     * Second constructor of window if we have icon
     * @param width width of window
     * @param height height of window
     * @param title title of window
     * @param icon icon of window
     */
    public Window(int width, int height, String title, GLFWImage.Buffer icon) {
        this.width = width;
        this.height = height;
        this.title = title;
        this.icon = icon;
    }

    /**
     * Initialise window
     */
    public void init() {
        if (!glfwInit()) {
            throw new RuntimeException("core.Window could not be initialised");
        }

        // Configurations for the core.Window
        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);
        glfwWindowHint(GLFW_FOCUSED, GLFW_TRUE);

        window = glfwCreateWindow(width, height, title, MemoryUtil.NULL, MemoryUtil.NULL);

        if (window == 0) {
            throw new RuntimeException("core.Window could not be created");
        }

        // Icon
        if (getIcon() != null) {
            glfwSetWindowIcon(window, getIcon());
        }

        // core.Window gets positioned in the center of the screen
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

    /**
     * Renders window
     */
    public void render() {
        glfwSwapBuffers(window);
    }

    /**
     * Updates window
     */
    public void update() {
        glfwPollEvents();
    }

    /**
     * Cleanups window
     */
    public void cleanup() {
        glfwDestroyWindow(window);
        glfwTerminate();
    }

    /**
     * Closes window
     * @return close action if shouldClose is true
     */
    public boolean close() {
        boolean shouldClose = glfwWindowShouldClose(window);
        if (shouldClose) {
            cleanup();
        }
        return shouldClose;
    }

    /**
     * @return width of window
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return height of window
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return title of window
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return icon of window
     */
    public GLFWImage.Buffer getIcon() {
        return icon;
    }

    /**
     * @return window object
     */
    public static long getWindow() {
        return window;
    }

}
