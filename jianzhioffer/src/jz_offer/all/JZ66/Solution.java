package jz_offer.all.JZ66;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    private int sum = 0;

    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] vis = new boolean[rows][cols];
        solve(0, 0, rows, cols, vis, threshold);
        return sum;
    }

    private void solve(int x, int y, int rows, int cols, boolean[][] vis, int threshold) {
        if (x < 0 || x >= rows || y < 0 || y >= cols || vis[x][y] || cul(x, y) > threshold) {
            return;
        }
        vis[x][y] = true;
        sum++;
        solve(x + 1, y, rows, cols, vis, threshold);
        solve(x - 1, y, rows, cols, vis, threshold);
        solve(x, y + 1, rows, cols, vis, threshold);
        solve(x, y - 1, rows, cols, vis, threshold);
    }

    private int cul(int x, int y) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        while (y != 0) {
            res += y % 10;
            y /= 10;
        }
        return res;
    }
}
