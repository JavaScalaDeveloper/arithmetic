package jz_offer.src.medium.JZ67;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int cutRope(int target) {
        if (target < 4)
            return target - 1;
        int m = target / 3;
        int n = target % 3;
        if (n == 1) {
            m = m - 1;
            n = 4;
        } else if (n == 0) {
            n = 1;
        }
        return (int) (n * Math.pow(3, m));
    }
}
