/**
 * @author MohamadHasan Taghadosi
 */
package Checker;


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

    private boolean haveOverLab() {
        Iterator jobsIterator = jobs.iterator();
        Iterator startTimesIterator = startTimes.iterator();
        Job tmpJob;
        StartTime tmpStartTime;
        int i = 0;
        while (jobsIterator.hasNext() && startTimesIterator.hasNext()) {
            tmpJob = (Job) jobsIterator.next();
            tmpStartTime = (StartTime) startTimesIterator.next();

            System.out.println(i);

            if(     (tmpStartTime.getStartOnWS1() > tmpStartTime.getStartOnWS2() &&  tmpStartTime.getStartOnWS1() + tmpJob.getOnWS1() < tmpStartTime.getStartOnWS2()) ||
                    (tmpStartTime.getStartOnWS1() > tmpStartTime.getStartOnWS3() &&  tmpStartTime.getStartOnWS1() + tmpJob.getOnWS1() < tmpStartTime.getStartOnWS3()) ||
                    (tmpStartTime.getStartOnWS1() < tmpStartTime.getStartOnWS2() &&  tmpStartTime.getStartOnWS1() + tmpJob.getOnWS1() > tmpStartTime.getStartOnWS2()) ||
                    (tmpStartTime.getStartOnWS1() < tmpStartTime.getStartOnWS3() &&  tmpStartTime.getStartOnWS1() + tmpJob.getOnWS1() > tmpStartTime.getStartOnWS3())) {
//                System.out.println(tmpStartTime.getStartOnWS1() + " " + tmpJob.getOnWS1());
//                System.out.println(tmpStartTime.getStartOnWS2() + " " + tmpJob.getOnWS2());
//                System.out.println(tmpStartTime.getStartOnWS3() + " " + tmpJob.getOnWS3());
                return true;
            }
            if(     (tmpStartTime.getStartOnWS2() > tmpStartTime.getStartOnWS1() &&  tmpStartTime.getStartOnWS2() + tmpJob.getOnWS2() < tmpStartTime.getStartOnWS1()) ||
                    (tmpStartTime.getStartOnWS2() > tmpStartTime.getStartOnWS3() &&  tmpStartTime.getStartOnWS2() + tmpJob.getOnWS2() < tmpStartTime.getStartOnWS3()) ||
                    (tmpStartTime.getStartOnWS2() < tmpStartTime.getStartOnWS1() &&  tmpStartTime.getStartOnWS2() + tmpJob.getOnWS2() > tmpStartTime.getStartOnWS1()) ||
                    (tmpStartTime.getStartOnWS2() < tmpStartTime.getStartOnWS3() &&  tmpStartTime.getStartOnWS2() + tmpJob.getOnWS2() > tmpStartTime.getStartOnWS3())) {
                return true;
            }
            if(     (tmpStartTime.getStartOnWS3() > tmpStartTime.getStartOnWS2() &&  tmpStartTime.getStartOnWS3() + tmpJob.getOnWS3() < tmpStartTime.getStartOnWS2()) ||
                    (tmpStartTime.getStartOnWS3() > tmpStartTime.getStartOnWS1() &&  tmpStartTime.getStartOnWS3() + tmpJob.getOnWS3() < tmpStartTime.getStartOnWS1()) ||
                    (tmpStartTime.getStartOnWS3() < tmpStartTime.getStartOnWS2() &&  tmpStartTime.getStartOnWS3() + tmpJob.getOnWS3() > tmpStartTime.getStartOnWS2()) ||
                    (tmpStartTime.getStartOnWS3() < tmpStartTime.getStartOnWS1() &&  tmpStartTime.getStartOnWS3() + tmpJob.getOnWS3() > tmpStartTime.getStartOnWS1())) {
                return true;
            }


        }

        return false;
    }
    private boolean haveTrueTime() {
        System.out.println(startTimes.size());
        return startTimes.size() == 833;
    }
    public boolean isPassCheck() {
        return !haveOverLab() & haveTrueTime();
    }
}
