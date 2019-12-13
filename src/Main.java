import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Handler handler;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // take n and m
        int[] nm = Arrays.stream(scanner.nextLine().split(" "))
                .map(String::trim).mapToInt(Integer::parseInt).toArray();
        handler = new Handler(nm[1]);
        // for i in range(n) do:
        for (int i = 0; i < nm[0]; i++) {
            String[] eachJob = scanner.nextLine().split(" ");
            handler.addInstance(i + 1, eachJob);
        }
        handler.sortWorkstations();
        System.out.println(handler);
        handler.run();
    }
}
