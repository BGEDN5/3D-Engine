public class timeutility {
    double fps = 60;
    Double PreviousTime;
    Double CurrentTime;
    Double DeltaTime;
    Double GameRate = (Double) 1.0 / this.fps;

    public Double getCurrentTime() {
        return this.CurrentTime;
    }

    public Double getPreviousTime() {
        return this.PreviousTime;
    }

    public void setCurrentTime(Double currentTime) {
        this.CurrentTime = currentTime;
    }

    public void setPreviousTime(Double previousTime) {
        this.PreviousTime = previousTime;
    }

    public void setDeltaTime(Double deltaTime) {
        this.DeltaTime = deltaTime;
    }

    public Double getDeltaTime() {
        return this.DeltaTime;
    }

    public Double CalculateDeltaTime() {
        return this.getCurrentTime() - this.getPreviousTime();
    }

}