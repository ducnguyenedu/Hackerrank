package cats_and_a_mouse;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the catAndMouse function below.
    static String catAndMouse(int x, int y, int z) {
        int catA = x;
        int catB = y;
        int mouseC = z;
        if (Math.abs(catA - mouseC) < Math.abs(catB - mouseC)) {
            return "Cat A";
        }
        if (Math.abs(catA - mouseC) == Math.abs(catB - mouseC)) {
            return "Mouse C";
        }
        return "Cat B";
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] xyz = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xyz[0]);

            int y = Integer.parseInt(xyz[1]);

            int z = Integer.parseInt(xyz[2]);

            String result = catAndMouse(x, y, z);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
