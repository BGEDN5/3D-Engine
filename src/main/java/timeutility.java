public class timeutility {
    double fps = 60;
    Double previousTime = (double) System.nanoTime();
    Double currentTime =  (double) System.nanoTime();
    Double deltaTime = 0.0;
    Double GameRate = (Double) 1.0 / this.fps;

    public Double getCurrentTime() {
        return this.currentTime;
    }

    public Double getPreviousTime() {
        return this.previousTime;
    }

    public void setCurrentTime(Double currentTime) {
        this.currentTime = currentTime;
    }

    public void setPreviousTime(Double previousTime) {
        this.previousTime = previousTime;
    }

    public void setDeltaTime(Double deltaTime) {
        this.deltaTime = deltaTime;
    }

    public Double getDeltaTime() {
        return this.deltaTime;
    }

    public Double calculateDeltaTime() {
        return this.getCurrentTime() - this.getPreviousTime();
    }

}