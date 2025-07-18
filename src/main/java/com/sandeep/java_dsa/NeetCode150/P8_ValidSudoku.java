package com.sandeep.java_dsa.NeetCode150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P8_ValidSudoku {

    /**
     * Three pass solution
     * TC -> O(N^2)
     * SC-> O(N^2)
     */
    public static boolean checkValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '.') continue;
                if (set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }

        for (int i = 0; i < cols; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < rows; j++) {
                if (board[j][i] == '.') continue;
                if (set.contains(board[j][i])) return false;
                set.add(board[j][i]);
            }
        }

        for (int square = 0; square < 9; square++) {
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    if (board[row][col] == '.') continue;
                    if (set.contains(board[row][col])) return false;
                    set.add(board[row][col]);
                }
            }
        }
        return true;
    }

    /**
     * One pass solution
     */
    private static boolean checkValidSudokuOnePass(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') continue;

                String squareKey = (i / 3) + "," + (j / 3);

                if (rows.computeIfAbsent(i, k -> new HashSet<>()).contains(board[i][j]) ||
                        cols.computeIfAbsent(j, k -> new HashSet<>()).contains(board[i][j]) ||
                        squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(board[i][j])) {
                    return false;
                }

                rows.get(i).add(board[i][j]);
                cols.get(j).add(board[i][j]);
                squares.get(squareKey).add(board[i][j]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'1', '2', '.', '.', '3', '.', '.', '.', '.'},
                {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '.', '3'},
                {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
                {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(checkValidSudokuOnePass(board));
    }
}
