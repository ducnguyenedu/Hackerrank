package BotCleanLarge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int botY = in.nextInt();
        int botX = in.nextInt();
        int W = in.nextInt();
        int H = in.nextInt();
        char board[][] = new char[H][W];
        for (int i = 0; i < H; i++)
            board[i] = in.next().toCharArray();
        in.close();
        System.out.println(new Solution().play(botY, botX, H, W, board));
    }

    public ArrayList<Integer> search(ArrayList<Integer> path, int[][] results) {
        int loop = 0;
        boolean improvement = true;
        int n = path.size();
        int actualPathResult, newPathResult;
        while (improvement && loop < n * n) {
            improvement = false;
            for (int i = 1; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    loop++;
                    if (j == n - 1) {
                        actualPathResult = getResult(results, path.get(i - 1), path.get(i));
                        newPathResult = getResult(results, path.get(i - 1), path.get(j));
                    } else {
                        actualPathResult = getResult(results, path.get(i - 1), path.get(i)) + getResult(results, path.get(j), path.get(j + 1));
                        newPathResult = getResult(results, path.get(i - 1), path.get(j)) + getResult(results, path.get(i), path.get(j + 1));
                    }
                    if (actualPathResult > newPathResult) {
                        // path[i], path[j] = path[j], path[i]
                        Collections.swap(path, i, j);
                        improvement = true;
                    }
                }
            }
        }
        return path;
    }

    // transfer point to the mat index
    public int getResult(int[][] results, int index1, int index2) {
        if (index1 < index2)
            return results[index2 - 2][index1 - 1];
        else
            return results[index1 - 2][index2 - 1];
    }

    public int getTotalResult(int[][] results, ArrayList<Integer> path) {
        int result = 0;
        for (int i = 0; i < path.size() - 1; i++)
            result += getResult(results, path.get(i), path.get(i + 1));
        return result;
    }

    public int calculateBestResult(int botY, int botX, char[][] board, int H, int W) {

        ArrayList<Coords> dirties = new ArrayList();
        // add the bot current to dirties
        dirties.add(new Coords(botY, botX));
        // find the dirty
        for (int i = 0; i < H; i++)
            for (int j = 0; j < W; j++)
                if (board[i][j] == 'd')
                    dirties.add(new Coords(i, j));

        int[][] results = new int[dirties.size() - 1][dirties.size()];
        for (int i = 0; i < dirties.size() - 1; i++)
            for (int j = 0; j < i + 1; j++)
                results[i][j] = dirties.get(j).calculateDistance(dirties.get(i + 1));
        ArrayList<ArrayList> solution = new ArrayList();
        for (int i = 0; i < H * W * 4; i++) {
            ArrayList<Integer> path = new ArrayList(dirties.size());
            for (int j = 1; j < dirties.size(); j++)
                path.add(j + 1);
            Collections.shuffle(path);
            path.add(0, 1);
            solution.add(search(path, results));
        }
        // print("path:", path)
        int bestResult = getTotalResult(results, solution.get(0));
        int result;
        for (int i = 1; i < H * W * 4; i++) {
            result = getTotalResult(results, solution.get(i));
            if (result < bestResult)
                bestResult = result;
        }
        return bestResult;
    }

    public String play(int botY, int botX, int H, int W, char[][] board) {

        String move = null;
        if (board[botY][botX] == 'd')
            move = "CLEAN";
        else {
            int bestResult = Integer.MAX_VALUE, result;
            if (botY - 1 >= 0) {
                result = calculateBestResult(botY - 1, botX, board, H, W);
                if (result < bestResult) {
                    bestResult = result;
                    move = "UP";
                }
            }
            if (botY + 1 < W) {
                result = calculateBestResult(botY + 1, botX, board, H, W);
                if (result < bestResult) {
                    bestResult = result;
                    move = "DOWN";
                }
            }
            if (botX - 1 >= 0) {
                result = calculateBestResult(botY, botX - 1, board, H, W);
                if (result < bestResult) {
                    bestResult = result;
                    move = "LEFT";
                }
            }
            if (botX + 1 < W) {
                result = calculateBestResult(botY, botX + 1, board, H, W);
                if (result < bestResult) {
                    bestResult = result;
                    move = "RIGHT";
                }
            }
        }
        return move;
    }

    public class Coords {
        int x, y;

        public Coords(int xTarget, int yTarget) {
            x = xTarget;
            y = yTarget;
        }

        public int calculateDistance(Coords target) {
            return Math.abs(target.x - x) + Math.abs(target.y - y) + 1;
        }
    }
}