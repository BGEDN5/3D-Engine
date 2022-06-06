package core;

import utils.TimeUtility;

public class Engine implements Runnable {

    private Thread loopthread;
    private boolean running = false;
    private boolean isRendered = false;
    private static final int width = 1280;
    private static final int height = 760;
    private TimeUtility time = new TimeUtility();
    private static Window frame = new Window(Engine.width, Engine.height, "test frame");
    private Input input = new Input();
    private Game game;


    public Engine(Game game) {
        this.game = game;
    }

    public void start() {
        if (this.running != true) {
            this.running = true;
            this.loopthread = new Thread(this);
            this.loopthread.start();
        }
    }

    public boolean stop() throws InterruptedException {
        this.running = false;
        this.loopthread = null;
        return true;
    }

    @Override
    public void run() {
        frame.init();
        game.init();
        this.time.setPreviousTime((double) System.nanoTime());
        float DeltaTime = 0;
        while (this.running) {

            if (frame.close()) {
                try {
                    this.stop();
                    return;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.time.setCurrentTime((double) System.nanoTime());
            this.time.setDeltaTime(this.time.calculateDeltaTime());
            DeltaTime += this.time.calculateDeltaTime();
            Double TempGameRate = this.time.GameRate * 1000000000;
            while (DeltaTime >= TempGameRate) {
                DeltaTime -= TempGameRate;
                update();
            }
            if (!isRendered) {
                try {
                    render();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.time.setPreviousTime(this.time.getCurrentTime());
        }

    }

    private void update() {
        this.input.update();
        this.frame.update();
        this.game.update();
        this.isRendered = false;
    }

    private void render() throws InterruptedException {
        this.frame.render();
        this.game.render();
    }

    private void clean() {
        this.frame.cleanup();
    }

    public boolean isRunning() {
        return this.running;
    }

    public Input getInput() {
        return this.input;
    }

}
