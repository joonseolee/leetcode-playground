/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 0;
        while (l < n) {
            int mid = l + (n - l) / 2;
            if (super.isBadVersion(mid)) {
                n = mid;
            } else {
                l = mid + 1;
            }
        }
        
        return l;
    }
}