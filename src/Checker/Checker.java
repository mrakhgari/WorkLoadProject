package Checker;
import Model.Job;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Checker {
    private boolean passCheck;
    private ArrayList<Job> jobs;
    private ArrayList<StartTime> startTimes;

    public Checker() throws IOException {
        FileHandler fileHandler = new FileHandler();
        jobs = fileHandler.readInputFile();
        startTimes = fileHandler.readOutputFile();

    }
}
