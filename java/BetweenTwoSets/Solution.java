package BetweenTwoSets;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {
    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        // Range of int goes from the LAST element of A to the FIRST of B
        int start = a.get(a.size() - 1), end = b.get(0);
        int count = 0;
        for (int x = start; x <= end; x++) {
            Boolean a_pass = true, b_pass = true;
            for (Integer ai : a
            ) {
                if (x % ai != 0) {
                    a_pass = false;
                    break;
                }
            }
            if (!a_pass) continue;
            for (Integer bi : b
            ) {
                if (bi % x != 0) {
                    // Idem A loop
                    b_pass = false;
                    break;
                }
            }
            if (a_pass && b_pass) count++;
        }
        return count;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(firstMultipleInput[0]);
        int m = Integer.parseInt(firstMultipleInput[1]);
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        int total = Result.getTotalX(arr, brr);
        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
