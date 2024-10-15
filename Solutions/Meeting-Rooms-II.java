// https://leetcode.com/problems/meeting-rooms-ii

class MeetingRoomsIISolution {
    public int minMeetingRooms(int[][] intervals) {

        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        // Start : [1, 6, 13]
        // End: [9, 13, 15]

        Arrays.sort(start);
        Arrays.sort(end);

        int i = 0; 
        int j = 0; 
        int count = 0; 
        int maxCount = 0; 
        while (i < intervals.length && j < intervals.length){
            if (start[i] < end[j]){
                i += 1; 
                count += 1; 
                maxCount = Math.max(maxCount, count);
            }
            else {
                count -= 1; 
                j += 1; 
            }
        }
        return maxCount;
    }
}