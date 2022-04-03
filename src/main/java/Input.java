import org.lwjgl.glfw.*;

public class Input{

    private GLFWKeyCallback keyboard;
    private GLFWMouseButtonCallback mouseButtons;
    private GLFWCursorPosCallback cursorPos;
    private GLFWScrollCallback mouseScroll;

    private static boolean[] keys = new boolean[GLFW.GLFW_KEY_LAST];
    private static boolean[] buttons = new boolean[GLFW.GLFW_MOUSE_BUTTON_LAST];
    private static double cursorX, cursorY;
    private static double scrollX, scrollY;

    private static int keyPressed;
    private static int buttonPressed;

    public Input(){
        keyboard = new GLFWKeyCallback(){
            @Override
            public void invoke(long window, int key, int scancode, int action, int mods) {
                keys[key] = (action == GLFW.GLFW_PRESS);
                keyPressed = key;
            }
        };

        mouseButtons = new GLFWMouseButtonCallback() {
            @Override
            public void invoke(long window, int button, int action, int mods) {
                buttons[button] = (action == GLFW.GLFW_PRESS);
                buttonPressed = button;
            }
        };

        cursorPos = new GLFWCursorPosCallback() {
            @Override
            public void invoke(long window, double xpos, double ypos) {
                cursorX = xpos;
                cursorY = ypos;
            }
        };

        mouseScroll = new GLFWScrollCallback() {
            @Override
            public void invoke(long window, double xoffset, double yoffset) {
                scrollX += xoffset;
                scrollY += yoffset;
            }
        };
    }

    public static boolean isKeyDown(int key){
        return keys[key];
    }

    public static boolean isButtonDown(int button){
        return buttons[button];
    }

    public static boolean isKeyPressed(int key){
        boolean check = (keyPressed == key);
        if(check) keyPressed = -1;
        return check;
    }

    public static boolean isButtonPressed(int button){
        boolean check = (buttonPressed == button);
        if(check) buttonPressed = -1;
        return check;
    }

    public static boolean isKeyUp(int key){
        boolean check = (key != keyPressed);
        if(check) keyPressed = -1;
        return check;
    }

    public static boolean isButtonUp(int button){
        boolean check = (button != keyPressed);
        if(check) keyPressed = -1;
        return check;
    }

    public void destroy(){
        keyboard.free();
        mouseButtons.free();
        cursorPos.free();
        mouseScroll.free();
    }

    public void update(){
        GLFW.glfwSetKeyCallback(Window.getWindow(), getKeyboardCallback());
        GLFW.glfwSetMouseButtonCallback(Window.getWindow(), getMouseButtonsCallback());
        GLFW.glfwSetCursorPosCallback(Window.getWindow(), getCursorPosCallback());
    }

    public GLFWKeyCallback getKeyboardCallback() {
        return keyboard;
    }

    public GLFWMouseButtonCallback getMouseButtonsCallback() {
        return mouseButtons;
    }

    public GLFWCursorPosCallback getCursorPosCallback() {
        return cursorPos;
    }

    public GLFWScrollCallback getMouseScrollCallback() {
        return mouseScroll;
    }

    public static double getCursorX() {
        return cursorX;
    }

    public static double getCursorY() {
        return cursorY;
    }

    public static double getScrollX() {
        return scrollX;
    }

    public static double getScrollY() {
        return scrollY;
    }
}
