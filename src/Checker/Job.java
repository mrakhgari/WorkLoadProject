package Checker;

public class Job {
    private int arrivalTime;
    private int onWS1;
    private int onWS2;
    private int onWS3;

    public Job(int arrivalTime, int onWS1, int onWS2, int onWS3) {
        this.arrivalTime = arrivalTime;
        this.onWS1 = onWS1;
        this.onWS2 = onWS2;
        this.onWS3 = onWS3;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getOnWS1() {
        return onWS1;
    }

    public int getOnWS2() {
        return onWS2;
    }

    public int getOnWS3() {
        return onWS3;
    }
}
