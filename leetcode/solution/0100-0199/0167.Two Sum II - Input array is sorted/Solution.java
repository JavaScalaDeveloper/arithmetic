package solution._0167;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;

        while(numbers[l]+numbers[r] != target) {
            while(numbers[l] + numbers[r] > target) r --;
            while(numbers[l] + numbers[r] < target) l ++;
        }
        return new int[] {l + 1, r + 1};
    }
}