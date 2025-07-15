package solution._0292;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public boolean canWinNim(int n) {
        return (n & 3) != 0;// n%4 != 0
    }
}