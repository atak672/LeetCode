// https://leetcode.com/problems/koko-eating-bananas

class KokoEatingBananasSolution {
    public int minEatingSpeed(int[] piles, int h) {

        int max = 1; 
        for (int pile : piles){
            max = Math.max(pile, max);
        }
    
        int start = 1; 
        int end = max; 
        while (start <= end){
            int mid = start + ((end - start) / 2);
            long totalTime = hoursToEat(mid, piles);
            if (totalTime > (long) h){
                start = mid + 1; 
            }
            else {
                end = mid - 1; 
            }
        }
        return start;
    }   
    private long hoursToEat(int rate, int[] piles){
        long hours = 0;
        for (int pile : piles){
           hours +=  (int) Math.ceil((double) pile / rate);
        }
        return hours;
    }
}