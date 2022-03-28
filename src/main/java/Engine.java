public class Engine  implements Runnable {

    private Thread loopthread;
    private boolean running = false;
    private static final int Width = 800;
    private static final int Height = 600;
    private Window frame = new Window(this.Height,this.Width,"test frame");

    public void start() {
        this.running = true;
        this.loopthread = new Thread(this);
        this.loopthread.start();
    }

    public void stop() throws InterruptedException {
        this.running = false;
        this.loopthread = null;
    }

    @Override
    public void run() {
        float PreviousTime = System.nanoTime();
        while (this.running) {
            update();
            render();
            float CurrentTime = System.nanoTime();
            float DeltaTime = CurrentTime - PreviousTime;
            PreviousTime = CurrentTime;
        }
    }

    private void update(){
        this.frame.update();
    }

    private void render(){
        this.frame.render();
    }

    private void clean(){
        this.frame.cleanup();
    }


    public static void main(String[] args) throws InterruptedException {
        Engine eng = new Engine();
        eng.frame.init();
    }

}
