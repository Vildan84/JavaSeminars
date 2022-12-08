package org.example;

import java.util.Arrays;

public class EightQueens {

    static int[] lines = {0,0,0,0,0,0,0,0};
    static int index = 0;

    public static void main(String[] args){

        do {
            if (checking()){
                if (index == 7) {

                    for (int j : lines) {
                        printBoard(j);
                    }
                    System.out.println("////////////////////////");
                    lines[index]++;
                }
                else {
                    index++;
                }
            }
            else {
                lines[index]++;
            }
        } while (lines[0]<8);
    }

    static boolean checking() {

        if (index == 0) {
            return true;
        }

        if (lines[index]>7){
            lines[index] = 0;
            index--;
            return false;
        }

        for (int i = 0; i < index; i++){
            if ((lines[index] == lines[i])|((Math.abs(lines[index] - lines[i])) == (index-i))){
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
