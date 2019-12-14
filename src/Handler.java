import java.util.*;
public class Handler{
    private Integer currentTime = 0;
    private Workstation[] workstations;
    private Integer numberOfTotalJobs;

    public Handler(Workstation[] workstations, Integer numberOfTotalJobs){
        this.workstations = workstations;
        this.numberOfTotalJobs = numberOfTotalJobs;
    }

    public void run(){
            while(true){
                ArrayList<Integer> inExecutionJobsIds = new ArrayList();
                for (Workstation workstation : workstations){
                    if (workstation.isBusy(currentTime))
                        inExecutionJobsIds.add(workstation.getInExecution().getId());
        }
                boolean finished = true;
                for (Workstation workstation : workstations){
                    if (workstation.isBusy(currentTime))
                        finished = false;
                    else if (workstation.getCompletedJobsSize() != numberOfTotalJobs){
                        finished = false;
                        Job picked = workstation.pickJob(currentTime, inExecutionJobsIds);
                        if (picked != null){
                            inExecutionJobsIds.add(picked.getId());
                        }
                    }
                }
                if (finished)
                    return;
                currentTime++;
            }
        }

    private int getOverallCompletionTime(){
        int min = 0;
        for (Workstation workstaion : workstations){
            if (workstaion.getEndTime() + workstaion.getInExecution().getBurstTime() > min)
                min = workstaion.getEndTime() + workstaion.getInExecution().getBurstTime();
        }
        return min; 
    }

    public void print(){
        System.out.println(getOverallCompletionTime());
        for (int i = 0; i < numberOfTotalJobs; i++){
            for (Workstation workstaion : workstations){
                for (Job job : workstaion.getCompletedJobs()){
                    if (i == job.getId()){
                        System.out.println(job.getStartTime());
                        break;
                    }
                }
            }
        }
    }
}