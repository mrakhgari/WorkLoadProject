import java.util.*;

public class Workstation {
    private List<Job> readyQueue;
    private List<Job> completedJobs;
    private Job inExecution;
    private int endTime;

    public Workstation(){
        this.readyQueue = new ArrayList<>();
        this.completedJobs = new ArrayList<>();
    }

    public void sortWithId(){
        Comparator<Job> compareIds = Comparator.comparing(Job::getId);
        Collections.sort(this.completedJobs, compareIds);
    }

    public boolean addJob(Job j){
        return this.readyQueue.add(j);
    }

    public void sortWithArrivalTime(){
        Collections.sort(this.readyQueue);
    }

    @Override
    public String toString() {
        Iterator<Job> it = readyQueue.iterator();
        if (! it.hasNext())
            return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            if (! it.hasNext())
                return sb.append(']').toString();
            sb.append(it.next());
            sb.append(',').append(' ');
        }
    }

}
