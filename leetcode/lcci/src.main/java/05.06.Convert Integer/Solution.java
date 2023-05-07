package src.main.java._0506;
import java.util.*;

public class Solution {
    public int convertInteger(int A, int B) {
        return Integer.bitCount(A ^ B);
    }
}