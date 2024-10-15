// https://leetcode.com/problems/non-overlapping-intervals

class NonOverlappingIntervalsSolution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // [1, 4], [5, 7], [6, 14], [8, 20], [21, 24]

        // idea, sort the intervals and you can find overlaps by comparing end to start
        // When confronted with an overlap, you want to choose the one with the eariest
        // End interval. If you pick the one with the earliest end time you increase
        // The likelihood of non overlap as it gives more leeway for additional 
        // Intervals to occur 


        // Sort by end times (same as sorting by start essentially -- can use start end comparison)
        // By it has the end time that ends earliest for ones that overlap

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        // Now if we encounter an overlap we want to essentially select the first one
        // That occurs in this series of overlaps. If it ends earliest, we have more chance
        // Of attending additional events in the freed up space 
        
        // Compare current one to a subsequent interval, if it overlaps we increase our count
        // As we would essentially remove subseuqent overlaps until done
        // If it does not overlap, we can simply increase the boundary of our end as they are
        // Distinct non overlapping interverals
        int end = Integer.MIN_VALUE; 
        int count = 0; 
        for (int[] interval : intervals){
            // End points can be equal
            if (end > interval[0]){
                count += 1; 
            }
            else {
                end = interval[1]; // If not overlap select end to keep moving end forward
                                    // So if we find a new overlap we have its earliest interval selected
            }
        }
        return count;
    }
}
