package solution._0020;

import java.util.ArrayDeque;
import java.util.Deque;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> q = new ArrayDeque<>();
        for (char ch : chars) {
            boolean left = ch == '(' || ch == '[' || ch == '{';
            if (left) q.push(ch);
            else if (q.isEmpty() || !match(q.pop(), ch)) return false;
        }
        return q.isEmpty();
    }

    private boolean match(char l, char r) {
        return (l == '(' && r == ')') || (l == '{' && r == '}') || (l == '[' && r == ']');
    }
}