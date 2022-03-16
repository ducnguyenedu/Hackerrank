package BotCleanLarge;

import java.util.Scanner;

public class Solution {
    static void play(int botY, int botX, int H, int W, String[] board) {
        //add logic here
        int dirtX = 0;
        int dirtY = 0;
        boolean isHave= false;
        //update check next to dirt
        if (board[botY].charAt(botX) == 'd') {
            dirtX = botX;
            dirtY = botY;
            isHave= true;
        }
        else if (botX>0 && board[botY].charAt(botX-1) == 'd') {
            dirtX = botX-1;
            dirtY = botY;
            isHave= true;
        }
        else if(botX+1<W && board[botY].charAt(botX+1) == 'd') {
            dirtX = botX+1;
            dirtY = botY;
            isHave= true;
        }
        else if(botY>0 && board[botY-1].charAt(botX) == 'd') {
            dirtX = botX;
            dirtY = botY-1;
            isHave= true;
        }
        else if (botY+1<H && board[botY+1].charAt(botX) == 'd') {
            dirtX = botX;
            dirtY = botY+1;
            isHave= true;
        }

        //update check nearly dirt
        if(!isHave){
            for (int y = (botY==0?botY:botY-1);y<(botY+2>H?H:botY+2) ; y++) {
                for (int x = (botX==0?botX:botX-1); x < (botX+2>W?W:botX+2); x++) {


                    if (board[y].charAt(x) == 'd') {
                        dirtX = x;
                        dirtY = y;
                        isHave= true;
                    }
                }
            }}
        //find dirt normal way
        if(!isHave){
            for (int y = 0; y < H; y++) {
                for (int x = 0; x < W; x++) {


                    if (board[y].charAt(x) == 'd') {
                        dirtX = x;
                        dirtY = y;
                    }
                }
            }
        }


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