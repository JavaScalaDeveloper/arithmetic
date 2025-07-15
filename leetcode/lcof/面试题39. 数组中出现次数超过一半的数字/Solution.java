package lcof.面试题39.数组中出现次数超过一半的数字;

public class Solution {
    public int majorityElement(int[] nums) {
        int major = 0, cnt = 0;
        for (int num : nums) {
            if (cnt == 0) {
                major = num;
                ++cnt;
            } else {
                cnt += (num == major ? 1 : -1);
            }
        }
        return major;
    }
}