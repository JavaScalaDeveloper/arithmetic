package solution._0069;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int mySqrt(int x) {
        if(x==0)return 0;
        long i=x;
        while(i>x/i) i = (i + x / i) / 2;
        return (int)i;
    }
}