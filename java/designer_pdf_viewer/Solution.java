package designer_pdf_viewer;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'designerPdfViewer' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h
     *  2. STRING word
     */

    public static int designerPdfViewer(List<Integer> h, String word) {
        // Write your code here
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int highestValue = 0;
        Map<Character, Integer> letterValue = new HashMap<>();

        for (int i = 0; i < h.size(); i++) {
            letterValue.put(alphabet[i], h.get(i));
        }

        for (int i = 0; i < word.length(); i++) {
            int current = 0;
            for (Map.Entry<Character, Integer> j : letterValue.entrySet()) {
                if (word.charAt(i) == j.getKey()) {
                    current = j.getValue();
                }
                if (current > highestValue) {
                    highestValue = current;
                }
            }
        }

        return highestValue * word.length();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String word = bufferedReader.readLine();

        int result = Result.designerPdfViewer(h, word);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
