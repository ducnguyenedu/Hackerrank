package NumberLineJumps;

import java.io.IOException;

class Result {
    /*
     * Complete the 'kangaroo' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER x1
     *  2. INTEGER v1
     *  3. INTEGER x2
     *  4. INTEGER v2
     */
    public static String kangaroo(int x1, int v1, int x2, int v2) {
        // Write your code here
        if (x1 == x2) return "YES";
        boolean canCatchUp = x1 < x2 ? (v1 > v2) : (v2 > v1);
        if (canCatchUp) {
            boolean willCatchUpOnLand = (x1 - x2) % (v2 - v1) == 0;
            if (willCatchUpOnLand) {
                return "YES";
            }
        }
        return "NO";
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        int x1 = 4;
        int v1 = 3;
        int x2 = 0;
        int v2 = 3;
        String result = Result.kangaroo(x1, v1, x2, v2);
        System.out.println(result);
    }
}
