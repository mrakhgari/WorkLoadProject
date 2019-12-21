package Checker;
import Model.Job;

import java.io.*;
import java.util.ArrayList;

/**
 * @author MohamadHasan Taghadosi
 * @date
 */

public class FileHandler {
    private ArrayList<StartTime> startTimes;
    private  ArrayList<Job> jobs;
    private String oneLineOfFile;
    private String[] resOneLineOfFile;
    private int time;

    public FileHandler() throws FileNotFoundException {
        startTimes = new ArrayList<StartTime>();
        jobs = new ArrayList<Job>();
    }

    public ArrayList<StartTime> getStartTimes() {
        return startTimes;
    }

    public ArrayList<Job> getJobs() {
        return jobs;
    }

    public int getTime() {
        return time;
    }

    public ArrayList<StartTime> readOutputFile() throws IOException {



        File file = new File("./src/Checker/outputFile.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        oneLineOfFile = br.readLine();
        time = Integer.parseInt(oneLineOfFile);
        while ((oneLineOfFile = br.readLine()) != null) {
            if (oneLineOfFile.equals("")) {
                break;
            }
            resOneLineOfFile = oneLineOfFile.split(" ");
            startTimes.add(new StartTime(Integer.parseInt(resOneLineOfFile[0]),
                                        Integer.parseInt(resOneLineOfFile[1]),
                                        Integer.parseInt(resOneLineOfFile[2])
                                        ));
            System.out.println(resOneLineOfFile[1]);
        }

        return startTimes;


    }


    public ArrayList<Job> readInputFile() throws IOException {



        File file = new File("./src/Checker/inputFile.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        oneLineOfFile = br.readLine();
        while ((oneLineOfFile = br.readLine()) != null) {
            if (oneLineOfFile.equals("")) {
                break;
            }
            resOneLineOfFile = oneLineOfFile.split(" ");
            jobs.add(new Job(Integer.parseInt(resOneLineOfFile[0]),
                    Byte.parseByte(resOneLineOfFile[1]),
                    Byte.parseByte(resOneLineOfFile[2])
            ));
            System.out.println(Byte.parseByte(resOneLineOfFile[1]));
        }

        return jobs;


    }

}
