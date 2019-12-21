package Checker;
import Model.Job;

import java.io.*;
import java.util.ArrayList;

/**
 * @author MohamadHasan Taghadosi
 * @date
 */
class startTime {
    private int startOnWS1;
    private int startOnWS2;
    private int startOnWS3;

    public startTime(int startOnWS1, int startOnWS2, int startOnWS3) {
        this.startOnWS1 = startOnWS1;
        this.startOnWS2 = startOnWS2;
        this.startOnWS3 = startOnWS3;
    }

    public int getStartOnWS1() {
        return startOnWS1;
    }

    public int getStartOnWS2() {
        return startOnWS2;
    }

    public int getStartOnWS3() {
        return startOnWS3;
    }
}
public class FileHandler {


    public FileHandler() throws FileNotFoundException {

    }


    public ArrayList<startTime> readOutputFile() throws IOException {
        ArrayList<startTime> startTimes = new ArrayList<startTime>();
        String oneLineOfFile;
        String[] resOneLineOfFile;
        int lineNum = 0;
        File file = new File("./src/Checker/outputFile.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        oneLineOfFile = br.readLine();
        lineNum = Integer.parseInt(oneLineOfFile);
        while ((oneLineOfFile = br.readLine()) != null) {
            if (oneLineOfFile.equals("")) {
                break;
            }
            resOneLineOfFile = oneLineOfFile.split(" ");
            startTimes.add(new startTime(Integer.parseInt(resOneLineOfFile[0]),
                                        Integer.parseInt(resOneLineOfFile[1]),
                                        Integer.parseInt(resOneLineOfFile[2])
                                        ));
            System.out.println(resOneLineOfFile[1]);
        }

        return startTimes;


    }


    public ArrayList<Job> readInputFile() throws IOException {
        ArrayList<Job> jobs = new ArrayList<Job>();
        String oneLineOfFile;
        String[] resOneLineOfFile;
        int lineNum = 0;
        File file = new File("./src/Checker/inputFile.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        oneLineOfFile = br.readLine();
        lineNum = Integer.parseInt(oneLineOfFile);
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
//    public static void main(String[] args) throws IOException {
//        FileHandler fileHandler = new FileHandler();
//        fileHandler.readInputFile();
//    }

}
