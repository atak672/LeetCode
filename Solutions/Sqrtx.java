// https://leetcode.com/problems/sqrtx

class SqrtxSolution {
    public int mySqrt(int x) {
        if (x == 1 || x == 0){
            return x; 
        }

        long left = 0; 

        // Square root is upperbounded by x/2, so can cut half of the check cases by setting right = x/2 + 1
        long right = (long) x/2 + 1; 

        while (left <= right){
            long mid = left + ((right - left)/2);
            long val = mid * mid; 

            if (val == x){
                return (int) mid;
            }
            else if (val > (long) x){
                right = mid - 1; 
            }
            else{
                left = mid + 1; 
            }
        }

        return (int) right; 
        
    }
}