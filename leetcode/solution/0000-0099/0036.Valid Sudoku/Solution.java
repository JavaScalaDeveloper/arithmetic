package solution._0036;

import java.util.HashSet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            HashSet<Character> col = new HashSet<>() , row = new HashSet<>() , cube = new HashSet<>();
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.' && !row.add(board[i][j])) return false;
                if(board[j][i] != '.' && !col.add(board[j][i])) return false;
                int colIndex = i/3*3+j/3 , rowIndex = i%3*3+j%3;
                if(board[rowIndex][colIndex] != '.' && !cube.add(board[rowIndex][colIndex])) return false;
            }
        }
        return true;
    }
}