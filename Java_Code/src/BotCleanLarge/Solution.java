package BotCleanLarge;

import java.util.Scanner;
//Score 52.8
public class Solution {
    static int[] findAround (int botX, int botY, int radius,int H, int W, String[] board){
        if (board[botY].charAt(botX) == 'd') {
            int[] res = new int[2];
            res[0]=botX;
            res[1]=botY;
            return res;
        }
        int startX= Math.max(botX - radius, 0);
        int startY= Math.max(botY - radius, 0);
        int endX= Math.min(botX + radius, W);
        int endY = Math.min(botY + radius, H);

        for (int y= startY; y < endY; y++) {
            for (int x = startX; x < endX; x++) {
                if (board[y].charAt(x) == 'd') {
                    int[] res = new int[2];
                    res[0]=x;
                    res[1]=y;
                    return res;
                }
            }
        }

        return findAround(botX,  botY,  radius+1, H,  W,  board);
    }
    static void play(int botY, int botX, int H, int W, String[] board) {
        //add logic here
        int dirtX = 0;
        int dirtY = 0;

        int[] dirt= null;
        int radius=0;
        dirt = findAround(botX,  botY,  radius, H,  W,  board);

        dirtX= dirt[0];
        dirtY= dirt[1];



        if ((dirtX == botX) && (dirtY == botY)) {
            System.out.println("CLEAN");
        } else if (dirtX < botX) {
            System.out.println("LEFT");
        } else if (dirtX > botX) {
            System.out.println("RIGHT");
        } else if (dirtY < botY) {
            System.out.println("UP");
        } else if (dirtY > botY) {
            System.out.println("DOWN");
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] bot = new int[2];
        int[] size = new int[2];
        for (int i = 0; i < 2; i++) {
            bot[i] = in.nextInt();
        }
        for (int i = 0; i < 2; i++) {
            size[i] = in.nextInt();
        }
        String board[] = new String[size[0]];
        for (int i = 0; i < size[0]; i++) {
            board[i] = in.next();
        }
        play(bot[0], bot[1], size[0], size[1], board);
    }
}