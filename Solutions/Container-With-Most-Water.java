// https://leetcode.com/problems/container-with-most-water

class ContainerWithMostWaterSolution {
    public int maxArea(int[] height) {

        // Idea is to maximize the base (distance between i's')
        // Idea is to maximize the height (the height of both respective bars)
        // i'th bar has x-point (i, 0) so base is simply (j - i) where j is jth point
        // Height is given as (i, h) -- or just h in array -- so heights is min(h_{i}, h_{j})
        // Maximizing area of rectangle: b * h

        // Do a brute force solution which calculates the area between any two pairs of bars

        int maxArea = Integer.MIN_VALUE; 

        int start = 0; 
        int end = height.length - 1; 

        while (start < end){
            int area = (end-start) * Math.min(height[start], height[end]);
            maxArea = Math.max(maxArea, area);
            if (height[start] <= height[end]){
                start += 1; 
            }
            else {
                end -= 1; 
            }
        }
        return maxArea; 
        
    }
}