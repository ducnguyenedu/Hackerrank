package breaking_best_and_worst_records;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        List<Integer> result = Result.breakingRecords(scores);
        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );
        bufferedReader.close();
        bufferedWriter.close();
    }
}

class Result {
    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */
    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Write your code here
        int highest, lowest;
        highest = lowest = scores.get(0);
        Integer[] result = new Integer[2];
        Arrays.fill(result, 0);
        for (int s_i = 1; s_i < scores.size(); s_i++) {
            if (scores.get(s_i) > highest) {
                highest = scores.get(s_i);
                ++result[0];
            } else if (scores.get(s_i) < lowest) {
                lowest = scores.get(s_i);
                ++result[1];
            }
        }
        List<Integer> res = Arrays.asList(result);
        return res;
    }
}
