import java.util.*;

public class Workstation {
    private List<Job> readyQueue;
    private List<Job> completedJobs;
    private Job inExecution;
    private Integer endTime = 0;

    public Workstation(){
        this.readyQueue = new ArrayList<>();
        this.completedJobs = new ArrayList<>();
    }

    public void sortWithId(){
        Comparator<Job> compareIds = Comparator.comparing(Job::getId);
        Collections.sort(this.completedJobs, compareIds);
    }

    public void addJob(Job job){
        for (int i = 0;i < readyQueue.size();i++){
            if (job.getBurstTime() > readyQueue.get(i).getBurstTime()){
                readyQueue.add(i, job);
                return;
            }
            else if (job.getBurstTime() == readyQueue.get(i).getBurstTime())
                if (job.getArrivalTime() < readyQueue.get(i).getArrivalTime()){
                    readyQueue.add(i, job);
                    return;
                }
        }
        this.readyQueue.add(job);
    }

    public void sortWithArrivalTime(){
        Collections.sort(this.readyQueue);
    }

    public Boolean isBusy(int currentTime){
        if (endTime > currentTime)
            return true;
        return false;
    }

    public Job getInExecution(){
        return inExecution;
    }

    public int getCompletedJobsSize(){
        return completedJobs.size();
    }

    public int getEndTime(){
        return endTime;
    }

    public List<Job> getCompletedJobs(){
        return completedJobs;
    }

    public Job pickJob(int currentTime, ArrayList<Integer> inExecutionJobsIds){

        if (inExecution != null){
            if (completedJobs.size() != 0){
                if (!inExecution.equals(completedJobs.get(completedJobs.size() - 1))){
                    readyQueue.remove(inExecution);
                    completedJobs.add(inExecution);
                }
            }
            else{
                readyQueue.remove(inExecution);
                completedJobs.add(inExecution);
            }
        }
        for (Job job : readyQueue){
            Boolean inExecution = false;
            for (Integer inExecutionJobId : inExecutionJobsIds){
                if (job.getId() == inExecutionJobId){
                    inExecution = true;
                    break;
                }
            }
            if (!inExecution && job.getArrivalTime() <= currentTime){
                endTime = currentTime + job.getBurstTime();
                job.setStartTime(currentTime);
                this.inExecution = job;
                return job;
            }
        }
        return null;
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
