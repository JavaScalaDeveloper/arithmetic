
package solution._0946;
import java.util.*;

public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, k = 0;
        while (i < popped.length) {
            if (!stack.isEmpty() && popped[i] == stack.peek()) {
                stack.pop();
                i ++;
            } else {
                if (k < pushed.length) {
                    stack.push(pushed[k ++]);
                } else return false;
            }
        }
        return stack.isEmpty();
    }
}