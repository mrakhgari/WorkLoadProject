package Model;

import java.util.*;

public class Workstation {
    private List<Job> readyQueue;
    private List<Job> completedJobs;
    private Job inExecution;
    private int endTime;
    private boolean isDone;

    public Workstation() {
        this.readyQueue = new ArrayList<>();
        this.completedJobs = new ArrayList<>();
    }

    public List<Job> getCompletedJobs() {
        return completedJobs;
    }

    public void sortWithId() {
        Comparator<Job> compareIds = Comparator.comparing(Job::getId);
        this.completedJobs.sort(compareIds);
    }

    public void addJob(Job j) {
        this.readyQueue.add(j);
    }

    public void sortWithArrivalTime() {
        Collections.sort(this.readyQueue);
    }

    public void setHLT() {
        inExecution = null;
    }

    public Job getInExecution() {
        return inExecution;
    }

    public void setUnlock(Job j) {
        for (Job job : readyQueue) {
            if (job.equals(j))
                job.setDeActive();
        }
    }

    public void setLock(Job j) {
        for (Job job : readyQueue) {
            if (job.equals(j))
                job.setActive();
        }
    }

    public Job findBestJob(int time) {
        if (inExecution != null) return null;
        for (int i = 0; i < readyQueue.size(); i++) {
            if (!readyQueue.get(i).isActive() && readyQueue.get(i).getArrivalTime() <= time) {
                readyQueue.get(i).setActive();
                inExecution = readyQueue.get(i);
                inExecution.setStartTime(time);
                readyQueue.remove(inExecution);
                break;
            }
        }
        if (readyQueue.isEmpty() && inExecution == null) isDone = true;
        return inExecution;
    }

    public boolean testJobFinished(int time) {
        if (inExecution == null) return false;
        if (inExecution.getStartTime() + inExecution.getBurstTime() <= time) {
            completedJobs.add(inExecution);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        Iterator<Job> it = completedJobs.iterator();
        if (!it.hasNext())
            return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (; ; ) {
            if (!it.hasNext())
                return sb.append(']').toString();
            sb.append(it.next());
            sb.append(',').append(' ');
        }
    }

    public boolean isDone() {
        return isDone;
    }

}