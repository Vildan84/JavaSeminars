package org.example;

import java.util.Arrays;

public class EightQueens {

    static int[] board = {0,0,0,0,0,0,0,0};
    static int index = 0;

    public static void main(String[] args){

        do {
            if (checking()){
                if (index == 7) {

                    for (int j : board) {
                        printBoard(j);
                    }
                    System.out.println("////////////////////////");
                    board[index]++;
                }
                else {
                    index++;
                }
            }
            else {
                board[index]++;
            }
        } while (board[0]<8);
    }

    static boolean checking() {

        if (index == 0) {
            return true;
        }

        if (board[index]>7){
            board[index] = 0;
            index--;
            return false;
        }

        for (int i = 0; i < index; i++){
            if ((board[index] == board[i])|((Math.abs(board[index] - board[i])) == (index-i))){
                return false;
            }
        }
        return true;
    }

    public static void printBoard(int n){
        Character[] board = new Character[]{'-', '-', '-', '-', '-', '-', '-', '-'};
        board[n] = 'Q';
        System.out.println(Arrays.toString(board));
    }

}
