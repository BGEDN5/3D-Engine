public class timeutility {
    int fps = 60;
    double interval = 1000000000 / fps;

    public double next_frame_time() {
        return System.nanoTime() + interval;
    }

    public double remeining_time() {
        double k = next_frame_time() - System.nanoTime();
        if (k < 0) {
            return 0;
        }
        return k;
    }

    public double nano_to_milisec(double nanosec) {
        return nanosec / 1000000;
    }

}
