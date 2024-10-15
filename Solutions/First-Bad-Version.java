// https://leetcode.com/problems/first-bad-version

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class FirstBadVersionSolution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1; 
        int end = n; 

        while (start <= end){
            int mid = start + ((end - start)/2);
            // If false -- increment start to mid + 1
            if (isBadVersion(mid)){
                end = mid - 1; 
            }
            else {
                start = mid + 1; 
            }
        }
        return start;
    }
}