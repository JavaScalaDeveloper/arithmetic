/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

package solution._0278;
/*
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1, high = n;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (isBadVersion(mid)) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}*/
