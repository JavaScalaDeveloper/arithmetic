package jz_offer.src.hard.JZ52;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public boolean match(char[] str, char[] pattern) {
        return new String(str).matches(new String(pattern));
    }
}
