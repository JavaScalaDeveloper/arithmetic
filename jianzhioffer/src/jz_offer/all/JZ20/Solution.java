package jz_offer.all.JZ20;

import java.util.Stack;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    Stack<Integer> total = new Stack<>();
    Stack<Integer> little = new Stack<>();

    public void push(int node) {
        total.push(node);
        if (little.isEmpty() || node < little.peek()) {
            little.push(node);
        } else {
            little.push(little.peek());
        }
    }

    public void pop() {
        total.pop();
        little.pop();
    }

    public int top() {
        return total.peek();
    }

    public int min() {
        return little.peek();
    }
}
