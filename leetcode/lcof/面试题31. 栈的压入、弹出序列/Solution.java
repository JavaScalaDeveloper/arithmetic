package lcof.面试题31.栈的压入;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> s = new ArrayDeque<>();
        int q = 0;
        for (int num : pushed) {
            s.push(num);
            while (!s.isEmpty() && s.peek() == popped[q]) {
                s.pop();
                ++q;
            }
        }
        return s.isEmpty();
    }

}