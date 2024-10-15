// https://leetcode.com/problems/minimum-time-difference

class MinimumTimeDifferenceSolution {
    public int findMinDifference(List<String> timePoints) {

        // Idea: Can convert all the times listed into minutes 
        // Sort them
        // Compare first and last one, and then immediate neighbors, i.e. timepoint[i] and timepoint[i + 1]
        /// Essentially compare two ways x + y and y - x
        // 1440 minutes in one day
        // O(nlogn)

        int[] sortedTimes = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++){
            String[] temp = timePoints.get(i).split(":");
            int newVal = (Integer.valueOf(temp[0]) * 60)  + Integer.valueOf(temp[1]);
            sortedTimes[i] = newVal;
        }

        Arrays.sort(sortedTimes);

        int minDiff = Math.min(findWrapGap(0, sortedTimes.length - 1, sortedTimes), findNoWrap(0, sortedTimes.length-1, sortedTimes));

        for (int i = 0; i < sortedTimes.length - 1; i++){
            minDiff = Math.min(minDiff, findWrapGap(i, i+1, sortedTimes));
            minDiff = Math.min(minDiff, findNoWrap(i, i+1, sortedTimes));
        }
        return minDiff;
    }

    // If you have two values-- they can either be closer to each other, or closer to each other after a wrap around

    private int findWrapGap(int x, int y, int[] arr){
        int val;
        if (arr[y] == 0){
            val = 0;
        }
        else{
            val = 1440 - arr[y]; 
        }
        return val + arr[x];

        
    }

    private int findNoWrap(int x, int y, int[] arr){
        return arr[y]-arr[x];
    }
}