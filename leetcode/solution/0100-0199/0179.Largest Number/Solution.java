 package solution._0179;

 import java.util.Arrays;
 import java.util.Comparator;

 import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public String largestNumber(int[] nums) {

		String[] strs = new String[nums.length];

		for (int i = 0; i < strs.length; i++) {
			strs[i] = nums[i] + "";
		}

		Arrays.sort(strs, new Comparator<String>() {

			public int compare(String x, String y) {
				return (y + x).compareTo(x + y);
			}
		});

		if ("0".equals(strs[0])) {
			return "0";
		}

		return String.join("", strs);
	}
}