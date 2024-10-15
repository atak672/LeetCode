// https://leetcode.com/problems/design-snake-game

class SnakeGame {
    
    // Provides width and height of the board for checking bounds
    int width; 
    int height; 
    // Food array that is technically k x 2 where each element is an (x, y) coord of the next food point to appear
    int[][] food;
    int foodIdx; // IDX to identify which is next food to spawn -- can check food in O(1) by indexing food array
    int lenFood;

    // Snake body -- simulated by double ended queue -- O(1) removal at both ends
    Deque<int[]> snake;
    // Body array s.t. we can detect collissions in O(1)
    Set<Integer> body; 

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width; 
        this.height = height; 
        this.food = food; 
        this.foodIdx = 0; 
        this.snake = new LinkedList<>(); 
        this.lenFood = food.length; 
        this.snake.addFirst(new int[]{0, 0});
        this.body = new HashSet<>();
        body.add(encode(0, 0));
    }
    
    public int move(String direction) {

        // We want to find coordinate we may be moving to given by direction
        int x = this.snake.peekFirst()[0];
        int y = this.snake.peekFirst()[1];
        if (direction.equals("U")){
            x -= 1; 
        }
        else if (direction.equals("D")){
            x += 1; 
            
        }
        else if (direction.equals("R")){
            y += 1; 
            
        }
        else if (direction.equals("L")){
            y -= 1;    
        }

        // check if # is inbounds, if no return -1
        if (! inBounds(x, y, this.height, this.width)){
            return -1; 
        }

        // See if it hits itself now
        if (this.body.contains(encode(x, y)) && (x != this.snake.peekLast()[0] || y != this.snake.peekLast()[1])){
            return -1; 
        }

        // If next item is food, we will increase score and not remove tail to simulate growth
        if (this.foodIdx < this.lenFood && x == this.food[this.foodIdx][0] && y == this.food[this.foodIdx][1]){
            this.foodIdx += 1; 
        }
        else {
            int[] removedPos = this.snake.removeLast(); 
            this.body.remove(encode(removedPos[0], removedPos[1]));
        }


        // If not, add it to occupied body spot and return score
        this.body.add(encode(x, y));
        this.snake.addFirst(new int[]{x, y});
        return this.foodIdx; 
        
    }

    public int encode(int x, int y){
        return x *this.width + y;
    }

    public boolean inBounds(int x, int y, int m, int n){
        if (x < 0 || x >= m){
            return false;
        }
        else if (y < 0 || y >= n){
            return false;
        }
        return true;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */