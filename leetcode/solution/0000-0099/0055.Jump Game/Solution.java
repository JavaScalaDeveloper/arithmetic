package solution._0066;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {

    public boolean canJump(int[] nums) {
        int count = 0;
        for (int i = nums.length - 2; i >= 0; i --) {
            count = nums[i] > count ? 0 : count + 1;
        }
        return count == 0;
    }
}