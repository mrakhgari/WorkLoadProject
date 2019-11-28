import java.util.*;

public class Workstation {
    private List<Job> jobs;

    public Workstation(){
        this.jobs = new ArrayList<>();
    }

    public boolean addJob(Job j){
        return this.jobs.add(j);
    }

    public void sortWithArrivalTime(){
        Collections.sort(this.jobs);
    }

    @Override
    public String toString() {
        Iterator<Job> it = jobs.iterator();
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
