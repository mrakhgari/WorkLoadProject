/**
 * @author MohamadHasan Taghadosi
 */

package Checker;


import java.io.*;
import java.util.ArrayList;



public class FileHandler {
    private ArrayList<StartTime> startTimes;
    private  ArrayList<Job> jobs;
    private String oneLineOfFile;
    private String[] resOneLineOfFile;
    private int time;

    public FileHandler() throws IOException {
        startTimes = new ArrayList<StartTime>();
        jobs = new ArrayList<Job>();
        readOutputFile();
        readInputFile();

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

    public void readOutputFile() throws IOException {


        int i = 0;
        File file = new File("./src/Checker/testCase.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        oneLineOfFile = br.readLine();
//        time = Integer.parseInt(oneLineOfFile);
        while ((oneLineOfFile = br.readLine()) != null) {
            if (oneLineOfFile.equals("")) {
                break;
            }
            resOneLineOfFile = oneLineOfFile.split(" ");
            startTimes.add(new StartTime(Integer.parseInt(resOneLineOfFile[0]),
                                        Integer.parseInt(resOneLineOfFile[1]),
                                        Integer.parseInt(resOneLineOfFile[2])
                                        ));
        }
        System.out.println(i);



    }


    private void readInputFile() throws IOException {

        File file = new File("./src/Checker/inputFile.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        oneLineOfFile = br.readLine();
        while ((oneLineOfFile = br.readLine()) != null) {
            if (oneLineOfFile.equals("")) {
                break;
            }
            resOneLineOfFile = oneLineOfFile.split(" ");
            jobs.add(new Job(Integer.parseInt(resOneLineOfFile[0]),
                    Integer.parseInt(resOneLineOfFile[1]),
                    Integer.parseInt(resOneLineOfFile[2]),
                    Integer.parseInt(resOneLineOfFile[3])
            ));
        }

    }

}
