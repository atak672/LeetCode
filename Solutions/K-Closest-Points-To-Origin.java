// https://leetcode.com/problems/k-closest-points-to-origin

class KClosestPointsToOriginSolution {
    public int[][] kClosest(int[][] points, int k) {

        // Idea is to keep a priorityqueue of size k (priroity assigned based on distane from origin)
        // inspect points one at a type
        // Insert into pq, if size > k, remove head
        // this lets us keep track of the k closest points

        // If size < k, point is inserted 
        // If > k, insert
            // Point is further than current head, it will be added to front and removed
            // If greater, it will be inserted into place with everything ahead shifted down
            // Then remove head, once the kth furtherest point is made, nothing smaller can
            //  ever take its place

            // First, make return array... k x 2 
                // First is number of elements and second is size of subarrays

            // Ordering in priorityQueue, I want descending order based on distance from origin
            
            int[][] ret = new int[k][2];
            PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.dist, a.dist)); 


            // Add items to pq, maintain size k for kth closest
            for (int[] point : points){
                Point newPoint = new Point(point[0], point[1]);
                pq.offer(newPoint);
                if (pq.size() > k){
                    pq.poll(); 
                }
            }

            // Populate answer array
            int i = 0; 
            for (Point p : pq){
                ret[i][0] = p.x;
                ret[i][1] = p.y;
                i += 1; 
            }
            
            return ret;
    }

    private class Point {
        private int x; 
        private int y;
        private int dist; 

        private Point(int x, int y){
            this.x = x; 
            this.y = y; 

            // Calculate dist from origin when created, avoids recalculations
            this.dist = x * x + y * y; 
        }

    }
}
