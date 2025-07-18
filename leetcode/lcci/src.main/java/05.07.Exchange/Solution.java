package src.main.java._0507;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int exchangeBits(int num) {
        int t1 = num >> 1;
    	int t2 = num << 1;
    	return t1 & 0x55555555 | t2 & 0xaaaaaaaa;
    }
}