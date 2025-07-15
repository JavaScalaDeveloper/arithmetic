package lcof.面试题65.不用加减乘除做加法;

public class Solution {
    public int add(int a, int b) {
        if (b == 0) return a;
        return add(a ^ b, (a & b) << 1);
    }
}