import Controller.Handler;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    // enter the path of file in args, (for example "./src/test.txt")
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File(args[0]), StandardCharsets.UTF_8.name());
            int[] nm = Arrays.stream(scanner.nextLine().replaceFirst("^\uFEFF", "").split(" "))
                    .map(String::trim).mapToInt(Integer::parseInt).toArray();
            Handler handler = new Handler(nm[1]);
            for (int i = 0; i < nm[0]; i++) {
                handler.addInstance(i, scanner.nextLine().split(" "));
            }
            scanner.close();
            handler.sortWorkstations();
            handler.run();
        } catch (FileNotFoundException e) {
            System.out.println("file not founded");
        }

    }
}
