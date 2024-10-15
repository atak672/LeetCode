// https://leetcode.com/problems/check-if-it-is-a-straight-line

class CheckIfItIsAStraightLineSolution {
    public boolean checkStraightLine(int[][] coordinates) {
        
        // Given two points, you can make a linear line function y = mx + b
        // Use first two points to make slope, calculate b
        // Then iterate through points and see if x == y when plugged in
        // Constraint: coordiantes has at least 2 points 

        int[] pointOne = coordinates[0];
        int[] pointTwo = coordinates[1];

        double dy =  pointTwo[1] - pointOne[1];
        double dx = pointTwo[0] - pointOne[0];
        if (dx == 0){
            return notAFunctionCheck(coordinates);
        }
        double slope = dy / dx; ; 
        double yIntercept = pointOne[1] - (slope * pointOne[0]);

        for (int[] point : coordinates){
            double calculation = (point[0] * slope) + yIntercept; 
            if (point[1] != calculation){
                return false; 
            }
        }
        return true; 
    }

    private boolean notAFunctionCheck(int[][] coordinates){
        int xStatic = coordinates[0][0];
        for (int[] point : coordinates){
            if (point[0] != xStatic){
                return false; 
            }
        }
        return true; 

    }   
}