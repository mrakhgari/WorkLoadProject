import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Handler {
    private ArrayList<Workstation> workstations;
    private int timeLine;
    private boolean isDone;

    Handler(int numberOfWorkstations) {
        workstations = new ArrayList<>(numberOfWorkstations);
        for (int i = 0; i < numberOfWorkstations; i++) {
            workstations.add(new Workstation());
        }
        System.out.println(workstations.size());
    }

    void addInstance(int id, String[] eachJob) {
        for (int j = 0; j < eachJob.length - 1; j++) {
            workstations.get(j).addJob(new Job(id, Byte.parseByte(eachJob[0]), Byte.parseByte(eachJob[j + 1])));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Workstation workstation : workstations) {
            sb.append(workstation.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortWorkstations() {
        for (Workstation w : workstations) {
            w.sortWithArrivalTime();
        }
    }

    void run() {
//        ArrayList<ArrayList<Workstation>> permutes = findPermute(workstations);
        int k = 0;
//        for (ArrayList<Workstation> set : permutes) {
        ArrayList<Workstation> set = workstations;
        isDone = false;
        this.timeLine = 0;
        while (!isDone) {
            for (int i = 0; i < set.size(); i++) {
                if (set.get(i).testJobFinished(timeLine)) {
                    System.out.println(set.get(i).getInExecution());
                    System.out.println("in test job");
                    for (Workstation workstation : set) {
                        workstation.setUnlock(set.get(i).getInExecution());
                    }
                    set.get(i).setHLT();
                }
            }
            for (int i = 0; i < set.size(); i++) {
                Job temp = set.get(i).findBestJob(timeLine);
                System.out.println("best job " + temp);
                if (temp != null) {
                    for (Workstation workstation : set) {
                        workstation.setLock(temp);
                    }
                }
            }
            timeLine++;
            isDone = true;
            for (Workstation workstation : set) {
//                System.out.print(workstation.isDone() + " ");
                isDone = isDone && workstation.isDone();
//                isDone = true;
            }
            System.out.println();
//            if (k == 2) break;
//                System.out.println("i "+ k + set);
//            k++;
        }

        for (Workstation w: workstations ) {
            System.out.println(w.getReadyQueue());
        }
    }

    private ArrayList<ArrayList<Workstation>> findPermute(List<Workstation> workstations) {
        ArrayList<ArrayList<Workstation>> result = new ArrayList<>();
        //start from an empty list
        result.add(new ArrayList<>());
        for (Workstation location : workstations) {
            //list of list in current iteration of the array num
            ArrayList<ArrayList<Workstation>> current = new ArrayList<>();

            for (ArrayList<Workstation> l : result) {
                // # of locations to insert is largest index + 1
                for (int j = 0; j < l.size() + 1; j++) {
                    // + add num[i] to different locations
                    l.add(j, location);

                    ArrayList<Workstation> temp = new ArrayList<>(l);
                    current.add(temp);
                    // - remove num[i] add
                    l.remove(j);
                }
            }

            result = new ArrayList<>(current);
        }
        return result;
    }
}
