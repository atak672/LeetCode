// https://leetcode.com/problems/design-browser-history

class BrowserHistory {
    private String current_page;
    private Stack<String> back_history;
    private Stack<String> forward_history;

    public BrowserHistory(String homepage) {
        current_page = homepage; 
        back_history = new Stack<>();
        forward_history = new Stack<>();
        back_history.push(homepage);
    }
    
    public void visit(String url) {
        forward_history.clear();
        back_history.push(url);
        current_page = url;
        
    }
    
    public String back(int steps) {
         while (steps-- > 0 && back_history.size() > 1) {
            forward_history.push(back_history.pop());
        }
        current_page = back_history.peek();
        return current_page;
        
    }
    
    public String forward(int steps) {
         while (steps-- > 0 && !forward_history.empty()) {
            back_history.push(forward_history.pop());
        }
        current_page = back_history.peek();
        return current_page;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */