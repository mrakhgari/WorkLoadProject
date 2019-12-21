package Checker;
import Model.Job;

import java.io.*;
import java.util.ArrayList;

/**
 * @author MohamadHasan Taghadosi
 * @date
 */

public class FileHandler {


    public FileHandler() throws FileNotFoundException {

    }


    public ArrayList<Job> handleInputFile() throws IOException {
        ArrayList<Job> jobs = new ArrayList<Job>();
        String oneLineOfFile;
        String[] resOneLineOfFile;
        int lineNum = 0;
        File file = new File("./Checker/inputFile.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        oneLineOfFile = br.readLine();
        lineNum = Integer.parseInt(oneLineOfFile);
        while ((oneLineOfFile = br.readLine()) != null) {
            if (oneLineOfFile.equals("")) {
                break;
            }
            resOneLineOfFile = oneLineOfFile.split(" ");




        }


    }

}
