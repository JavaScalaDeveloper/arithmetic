package src.main.java._0109;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public boolean isFlipedString(String s1, String s2) {
        return s1.length() == s2.length() && (s2 + s2).indexOf(s1) != -1;
    }
}