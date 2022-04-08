public class Engine implements Runnable {

    private Thread loopthread;
    private boolean running = false;
    private boolean isRendered = false;
    private static final int width = 800;
    private static final int height = 600;
    private timeutility time = new timeutility();
    private Window frame = new Window(this.width, this.height, "test frame");
    private Input input = new Input();

    public void start() {
        if (this.running != true) {
            this.running = true;
            this.loopthread = new Thread(this);
            this.loopthread.start();
        }
    }

    public void stop() throws InterruptedException {
        this.running = false;
        this.loopthread = null;
    }

    @Override
    public void run() {

        this.frame.init();
        this.time.setPreviousTime((double) System.nanoTime());
        float DeltaTime = 0;
        while (this.running) {

            if (frame.close()) {
                try {
                    this.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.time.setCurrentTime((double) System.nanoTime());
            this.time.setDeltaTime(this.time.calculateDeltaTime());
            DeltaTime += this.time.calculateDeltaTime();
            Double TempGameRate = this.time.GameRate * 1000000000;
            this.time.setPreviousTime(this.time.getCurrentTime());
            while (TempGameRate <= DeltaTime) {
                DeltaTime -= TempGameRate;
                update();
            }
            if (!isRendered) {
                render();
            }
        }
    }

    private void update() {
        this.frame.update();
        this.input.update();
        this.isRendered = false;
    }

    private void render() {
        this.frame.render();
    }

    private void clean() {
        this.frame.cleanup();
    }



}
