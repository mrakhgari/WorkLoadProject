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

public class Job {
    private int id;
    private byte arrivalTime;
    private byte burstTime;
    private int startTime;

    /**
     * Cou
     *
     * @param id          a unique int.
     * @param arrivalTime a byte that shows arrival time of job.
     * @param burstTime   a byte that shows burst time of job.
     * @param startTime   a int that shows execution time of job.
     */
    public Job(int id, byte arrivalTime, byte burstTime, int startTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.startTime = startTime;
    }

    public int getId() {
        return id;
    }

    public byte getArrivalTime() {
        return arrivalTime;
    }

    public byte getBurstTime() {
        return burstTime;
    }

    public int getStartTime() {
        return startTime;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Job)
            return ((Job) obj).getId() == this.id;
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
     * @param j1 first job.
     * @param j2 second job.
     * @return {@code true} if the objects have time interference;
     *         {@code false} otherwise;
     */
    public static boolean hasOverlap(Job j1, Job j2) {
        return j1.getStartTime() < j2.getStartTime() + j2.getBurstTime() &&
                j2.getStartTime() < j1.getStartTime() + j1.getBurstTime();
    }
}
