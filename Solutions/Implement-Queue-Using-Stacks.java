// https://leetcode.com/problems/implement-queue-using-stacks

class MyQueue {
    private Stack<Integer> stackOne;
    private Stack<Integer> stackTwo; 

    public MyQueue() {
        stackOne = new Stack<>(); 
         stackTwo = new Stack<>(); 
        
    }
    

    // Use 1 stack to hold values while you rearrange other stack LIFO
    // i.e. say stack 1 has [1, 2, 3] s.t. queue.remove reveals 1
    // we want to add 4. Pop and empty stack 1 into stack 2
    // put 4 in stack 1, adn then empty 2 back into 1

    public void push(int x) {

        while(! stackOne.isEmpty()){
            stackTwo.push(stackOne.pop());
        }

        stackOne.push(x); 
        
        while(! stackTwo.isEmpty()){
            stackOne.push(stackTwo.pop());
        }

        return; 
        
    }
    
    public int pop() {
        return stackOne.pop(); 
        
    }
    
    public int peek() {
        return stackOne.peek();
        
    }
    
    public boolean empty() {
        return stackOne.isEmpty(); 
        
        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */