package jz_offer.all.JZ9;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int JumpFloorII(int target) {
        int sum = 1;
        if (target == 0 || target == 1)
            return 1;
        for (int i = 1; i < target; i++) {
            sum *= 2;
        }
        return sum;
    }
}
