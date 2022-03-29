public class Engine  implements Runnable {

    private Thread loopthread ;
    private boolean running = false;
    private boolean isRendered = false;
    private static final int Width = 800;
    private static final int Height = 600;
    private timeutility time = new timeutility();
    private Window frame = new Window(this.Height,this.Width,"test frame");

    public void start() {
        if(this.running!=true){
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
        System.out.println("run run");
        this.time.setPreviousTime(System.nanoTime());
        float DeltaTime = 0;
        while (this.running) {
            this.time.setCurrentTime(System.nanoTime());
            this.time.setDeltaTime(this.time.CalculateDeltaTime());
            DeltaTime += this.time.CalculateDeltaTime();
            float TempGameRate = this.time.GameRate;
            this.time.setPreviousTime(this.time.getCurrentTime());
            while(TempGameRate>DeltaTime){
                TempGameRate-=DeltaTime;
                update();
            }
            if(!isRendered){
                render();
            }
            System.out.println("loop");
        }
    }

    private void update(){
        this.frame.update();
        this.isRendered = false;
    }

    private void render(){
        this.frame.render();
    }

    private void clean(){
        this.frame.cleanup();
    }


    public static void main(String[] args) throws InterruptedException {
        Engine eng = new Engine();
        eng.start();
        System.out.println("started");
        Thread.sleep(1000);
        eng.stop();
        System.out.println("stoped");
    }

}
