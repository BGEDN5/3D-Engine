public class timeutility {
    int fps = 60;
    float PreviousTime;
    float CurrentTime;
    float DeltaTime;
    float GameRate = 1/fps;

    public float getCurrentTime() {
        return this.CurrentTime;
    }

    public float getPreviousTime() {
        return this.PreviousTime;
    }

    public void setCurrentTime(float currentTime) {
        this.CurrentTime = currentTime;
    }

    public void setPreviousTime(float previousTime) {
        this.PreviousTime = previousTime;
    }

    public void setDeltaTime(float deltaTime) {
        this.DeltaTime = deltaTime;
    }

    public float getDeltaTime() {
        return this.DeltaTime;
    }

    public float CalculateDeltaTime() {
        return this.getCurrentTime()-this.getPreviousTime();
    }

}