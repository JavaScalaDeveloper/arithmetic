package solution._0027;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int cnt = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == val) {
                ++cnt;
            } else {
                nums[i - cnt] = nums[i];
            }
        }
        return n - cnt;
    }
}