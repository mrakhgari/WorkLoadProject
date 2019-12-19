package Model;

/**
 * Job class that contains information of Job.
 * fields of class are:
 * id: A unique integer to find a job and check whether it is equivalent to another job.
 * arrivalTime: a byte (range in 1 to 50) that show the arrival time of job
 * burstTime: a byte (range in 1 to 50) that show the burst time of job.
 * startTime: time that the job executed.
 *
 * @author _MuhmdrezA
 * @version 1.01
 */

public class Job implements Comparable<Job> {
    private Integer id;
    private byte arrivalTime;
    private byte burstTime;
    private int startTime;
    private boolean isActive;

    /**
     * Constructs a newly allocated {@code Job} object that
     * represents the specified {@code int} id ,{@code byte} arrivalTime ,{@code byte} burstTime and {@code int} startTime.
     *
     * @param id          a unique int.
     * @param arrivalTime a byte that shows arrival time of job.
     * @param burstTime   a byte that shows burst time of job.
     */
    public Job(int id, byte arrivalTime, byte burstTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }

    Integer getId() {
        return id;
    }

    byte getArrivalTime() {
        return arrivalTime;
    }

    byte getBurstTime() {
        return burstTime;
    }

    int getStartTime() {
        return startTime;
    }

    boolean isActive() {
        return isActive;
    }

    void setActive() {
        isActive = true;
    }

    void setDeActive() {
        isActive = false;
    }

    void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Job)
            return ((Job) obj).getId().equals(this.id);
        return false;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    public boolean hasOverlap(Job j) {
        return hasOverlap(this, j);
    }

    /**
     * Checks if the two job {@code Job} ,{ @code Job} have time interference?
     *
     * @param j1 first job.
     * @param j2 second job.
     * @return {@code true} if the objects have time interference;
     * {@code false} otherwise;
     */
    private static boolean hasOverlap(Job j1, Job j2) {
        return j1.getStartTime() < j2.getStartTime() + j2.getBurstTime() &&
                j2.getStartTime() < j1.getStartTime() + j1.getBurstTime();
    }

    /**
     * Compares two {@code Job} objects numerically.
     *
     * @param o the {@code Job} to be compared.
     * @return the value {@code 0} if this {@code Job} is
     * equal to the argument {@code Job}; a value less than
     * {@code 0} if this.arrivalTime {@code Integer} is numerically less
     * than the argument.arrivalTime {@code Integer} or if this.arrivalTime {@code Integer} is equal to
     * argument.arrivalTime and this.burstTime {@code Integer} is numerically less
     * than the argument.burstTime {@code Integer};
     * and a value greater than {@code 0} if this.arrivalTime {@code Integer} is numerically
     * greater than the argument.arrivalTime {@code Integer}.
     */
    @Override
    public int compareTo(Job o) {
        return compare(this.getBurstTime(), o.getBurstTime(), this.getArrivalTime(), o.getArrivalTime());
    }

    private int compare(int x1, int y1, int x2, int y2) {
        return x1 == y1 ? Integer.compare(x2, y2) : Integer.compare(y1, x1);
    }


    @Override
    public String toString() {
//        return "(id: " + this.id + " exe time: " + this.startTime + " burstTime: " + this.burstTime + ")";
        return  "( " + this.startTime + ", " + this.burstTime + ")";
    }
}