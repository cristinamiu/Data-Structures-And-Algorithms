package com.practice.leetcode.top100;

import java.util.HashSet;
import java.util.Set;

public class Sudoku {
    public static int GRID_SIZE = 9;
    public static char[][] board = {
            {'8' , '3' , '.' , '.' , '7' , '.' , '.' , '.' , '.'},
            {'6' , '.' , '.' , '1' , '9' , '5' , '.' , '.' , '.'},
            {'.' , '9' , '5' , '.' , '.' , '.' , '.' , '6' , '.'},
            {'1' , '.' , '.' , '.' , '6' , '.' , '.' , '.' , '3'},
            {'4' , '.' , '.' , '8' , '.' , '3' , '.' , '.' , '1'},
            {'7' , '.' , '.' , '.' , '2' , '.' , '.' , '.' , '6'},
            {'.' , '6' , '.' , '.' , '.' , '.' , '2' , '8' , '.'},
            {'.' , '.' , '.' , '4' , '1' , '9' , '.' , '.' , '5'},
            {'.' , '.' , '.' , '.' , '8' , '.' , '.' , '7' , '9'}};
    
    public static char[][] board2 = 
                          {{'.','.','.','.','5','.','.','1','.'},
                           {'.','4','.','3','.','.','.','.','.'},
                           {'.','.','.','.','.','3','.','.','1'},
                           {'8','.','.','.','.','.','.','2','.'},
                           {'.','.','2','.','7','.','.','.','.'},
                           {'.','1','5','.','.','.','.','.','.'},
                           {'.','.','.','.','.','2','.','.','.'},
                           {'.','2','.','9','.','.','.','.','.'},
                           {'.','.','4','.','.','.','.','.','.'}};

    public static void main(String[] args) {
        char[][] m = {{'1', '2'}, {'4', '1'}};
        System.out.println(isValidSudoku(board2));
    }

    public static boolean isValidSudoku(char[][] board) {
        return !rowHasDuplicates(board) && !columnHasDuplicates(board) && !duplicateInGrid(board);
    }

    private static boolean duplicateInGrid(char[][] board) {
        boolean res = false;
        for (int i = 0; i < board.length; i=i+3) {
            for (int j = 0; j < board.length; j=j+3)
            if (checkGrid(board, i, i + 3, j, j+3)) {
                return true;
            }
        }
        return false;
    }

    public static boolean columnHasDuplicates(char[][] board) {

        for (int col = 0; col < GRID_SIZE; col++) {
            Set<Character> s = new HashSet<>();
            for (int row = 0; row < GRID_SIZE; row++) {
                if (board[row][col] != '.' && !s.add(board[row][col]))
                    return true;
            }
        }
        return false;
    }

    public static boolean rowHasDuplicates(char[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            Set<Character> s = new HashSet<>();
            for (int col = 0; col < GRID_SIZE; col++) {
                if (board[row][col] != '.' && !s.add(board[row][col]))
                    return true;
            }
        }
        return false;
    }

    public static boolean checkGrid(char[][] matrix, int startRow, int endRow, int startCol, int endCol) {
        Set<Character> s = new HashSet<>();
        for (int i = startRow; i < endRow; i++) {
            for (int j = startCol; j < endCol; j++) {
                if (matrix[i][j] != '.' && !s.add(matrix[i][j])) {
                        return true;
                }
            }
        }

        return false;
    }
}
