// https://leetcode.com/problems/min-stack

class MinStack {

    // Gonna have the stack function and store nodes
    // Each node has a value: val, the actual number, and min, the current minimum value
    // If val is smaller than the minimum, update the objects, min value after we add it to stack
    // When something is popped, update min to the min value stored at that node

    class node {
        int val; 
        int min; 

        public node(int val, int min){
            this.val = val; 
            this.min = min;
        }
    }


    int min;
    Stack<node> stack;


    public MinStack() {
        this.stack = new Stack<>(); 
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        stack.push(new node(val, this.min));
        this.min = Math.min(this.min, val);
        
    }
    
    public void pop() {
        if (this.stack.isEmpty()){
            return;
        }
        this.min = this.stack.peek().min;
        this.stack.pop(); 
        
    }
    
    public int top() {
         if (this.stack.isEmpty()){
            return Integer.MAX_VALUE;
        }
        return this.stack.peek().val;
        
    }
    
    public int getMin() {
         if (this.stack.isEmpty()){
            return Integer.MAX_VALUE;
        }
        return this.min; 
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */