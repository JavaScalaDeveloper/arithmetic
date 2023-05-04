import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public  class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, n = nums.length; i < n; ++i) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                return new int[]{map.get(num), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3};
        Solution solution = new Solution();
        int[] ints = solution.twoSum(arr1, 3);
        System.out.println(Arrays.toString(ints));
    }
}