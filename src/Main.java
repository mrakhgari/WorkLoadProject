import java.util.*;
public class Main{
    public static void main(String[] args) {

        // Scanner scanner = new Scanner(System.in);
        // String firstLine = scanner.nextLine();
        // String[] numberOfJobsAndWorkstations = firstLine.split(" ");
        // int numberOfJobs = numberOfJobsAndWorkstations[0];
        // int numberOfWorkstations = numberOfJobsAndWorkstations[1];
        // Workstation[] workstations = new Workstation[numberOfWorkstations];
        // for (int i = 0; i < numberOfJobs;i++){
        //     String line = scanner.nextLine();
        //     String arrivalTimeAndExecutionTime = line.split();
        //     for (int j = 1; j <= numberOfWorkstations;j++){
        //         Job job = new Job(i, Integer.parseInt(arrivalTimeAndExecutionTime[0], Integer.parseInt(arrivalTimeAndExecutionTime[j])));
        //         workstations[j - 1].addJob(job);
        //     }
        // }

        /* for test*/
        Workstation[] workstations = new Workstation[3];
        Workstation w = new Workstation();
        Workstation wo = new Workstation();
        Workstation wor = new Workstation();
        workstations[0] = w;
        workstations[1] = wo;
        workstations[2] = wor;
        Job a = new Job(0, 1, 3);
        Job b = new Job(0, 1, 2);
        Job c = new Job(0, 1, 6);
        Job d = new Job(1, 3, 1);
        Job e = new Job(1, 3, 5);
        Job f = new Job(1, 3, 1);
        Job g = new Job(2, 7, 5);
        Job h = new Job(2, 7, 3);
        Job i = new Job(2, 7, 3);
        Job j = new Job(3, 5, 7);
        Job k = new Job(3, 5, 3);
        Job l = new Job(3, 5, 2);
        // Job m = new Job(4, 8, 9);
        // Job n = new Job(4, 8, 2);
        // Job o = new Job(4, 8, 1);
        // Job p = new Job(5, 2, 3);
        // Job q = new Job(5, 2, 11);
        // Job r = new Job(5, 2, 13);
        // Job s = new Job(6, 4, 12);
        // Job t = new Job(6, 4, 1);
        // Job u = new Job(6, 4, 8);

        workstations[0].addJob(a);
        workstations[1].addJob(b);
        workstations[2].addJob(c);
        workstations[0].addJob(d);
        workstations[1].addJob(e);
        workstations[2].addJob(f);
        workstations[0].addJob(g);
        workstations[1].addJob(h);
        workstations[2].addJob(i);
        workstations[0].addJob(j);
        workstations[1].addJob(k);
        workstations[2].addJob(l);
        // workstations[0].addJob(m);
        // workstations[1].addJob(n);
        // workstations[2].addJob(o);
        // workstations[0].addJob(p);
        // workstations[1].addJob(q);
        // workstations[2].addJob(r);
        // workstations[0].addJob(s);
        // workstations[1].addJob(t);
        // workstations[2].addJob(u);

        Handler handler = new Handler(workstations, 4);
        handler.run();
        handler.print();
    
    
    }
}