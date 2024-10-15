// https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60

class PairsOfSongsWithTotalDurationsDivisibleBySixtySolution {
    public int numPairsDivisibleBy60(int[] time) {

        int[] duration = new int[60];
        int ret = 0;

        for (int song : time){
            int remainder = song % 60; 
           // System.out.println(remainder + " " + duration[remainder]);
            ret += duration[remainder];
            duration[(60 - remainder) % 60] += 1; 
        }
        return ret; 
    }
}