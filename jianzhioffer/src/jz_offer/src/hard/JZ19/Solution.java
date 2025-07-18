package jz_offer.src.hard.JZ19;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return list;
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (true) {
            for (int col = left; col <= right; col++) {
                list.add(matrix[up][col]);
            }
            up++;
            if (up > down) break;
            for (int row = up; row <= down; row++) {
                list.add(matrix[row][right]);
            }
            right--;
            if (right < left) break;
            for (int col = right; col >= left; col--) {
                list.add(matrix[down][col]);
            }
            down--;
            if (down < up) break;
            for (int row = down; row >= up; row--) {
                list.add(matrix[row][left]);
            }
            left++;
            if (left > right) break;
        }
        return list;
    }
}
