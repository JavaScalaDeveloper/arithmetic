package solution._1095;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int findInMountainArray(int target, List<Integer> mountainArr) {
        int length = mountainArr.size();
        int l = 0, r = length - 1;
        while (l < r) {
            int mid = l + r >>> 1;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) r = mid;
            else l = mid + 1;
        }
        int topIndex = r;
        int topValue = mountainArr.get(topIndex);
        if (target == topValue) return topIndex;
        if (target > topValue) return -1;
        l = 0;
        r = topIndex - 1;
        while (l < r) {
            int mid = l + r >>> 1;
            if (mountainArr.get(mid) >= target) r = mid;
            else l = mid + 1;
        }
        if (mountainArr.get(r) == target) {
            return r;
        }
        l = topIndex + 1;
        r = length - 1;
        while (l < r) {
            int mid = l + r >>> 1;
            if (mountainArr.get(mid) <= target) r = mid;
            else l = mid + 1;
        }
        return mountainArr.get(r) == target ? r : -1;
    }
}
