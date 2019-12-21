/**
 * @author MohamadHasan Taghadosi
 */
package Checker;
import Model.Job;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Checker {
    private boolean passCheck;
    private ArrayList<Job> jobs;
    private ArrayList<StartTime> startTimes;
    private int resTime;

    public Checker() throws IOException {
        FileHandler fileHandler = new FileHandler();
        jobs = fileHandler.getJobs();
        startTimes = fileHandler.getStartTimes();
        resTime = fileHandler.getTime();
    }

    public boolean haveOverLab() {
        Iterator jobsIterator = jobs.iterator();
        Iterator startTimesIterator = startTimes.iterator();
        Job tmpJob;
        StartTime tmpStartTime;

        while (jobsIterator.hasNext() && startTimesIterator.hasNext()) {
            tmpJob = (Job) jobsIterator.next();
            tmpStartTime = (StartTime) startTimesIterator.next();

        }
    }
}
