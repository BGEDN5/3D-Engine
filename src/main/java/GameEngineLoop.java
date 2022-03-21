import javax.swing.*;
import java.awt.*;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.enumerate;
import static java.lang.Thread.sleep;

public class GameEngineLoop extends Canvas implements Runnable {

    private Thread loopthread;
    private boolean running = false;
    private JFrame frame = new JFrame();
    private static final int Width = 800;
    private static final int Height = 600;
    private timeutility time = new timeutility();
    Vector<JLabel> v = new Vector<JLabel>(0);
    private int lastlabley = 0;
    private int lastlablex = 0;


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
        while (this.running) {
            update();
            render();
            try {
                Thread.sleep((long) time.nano_to_milisec(time.remeining_time()));
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    private void update() {
        v.add(new JLabel("3d game loop"));
        frame.add(v.lastElement());
        this.lastlabley += 10;
        if (this.lastlabley == 600) {
            this.lastlablex += 100;
            this.lastlabley = 0;
        }
        v.lastElement().setBounds(this.lastlablex, this.lastlabley, 100, 50);

    }

    private void render() {
        int lastx = 0, lasty = 0;
        if (this.lastlabley != lasty || this.lastlablex != lastx) {
            v.lastElement().setText(String.valueOf(time.remeining_time()) + "\n");
            lastx = this.lastlablex;
            lasty = this.lastlabley;
        }
    }

    private void clean() {
        frame.getContentPane().removeAll();
        frame.repaint();
    }


    GameEngineLoop() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Width, Height);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws InterruptedException {

        GameEngineLoop g = new GameEngineLoop();
        g.start();
        sleep(2000);
        g.stop();
        g.v.lastElement().setText("first stop \n");
        sleep(2000);
        g.start();
        sleep(2000);
        g.stop();
        g.v.lastElement().setText("second stop \n");
        g.clean();
        g.frame.dispose();
    }

}