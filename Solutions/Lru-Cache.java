// https://leetcode.com/problems/lru-cache

class LRUCache {

    // My idea is to take advantage of a doubley linkedlist to mimic a queue structure
    // A hashmap will then be used to attach a key to a listnode with value embedded within it
    // If accessed via get -- will rewrite list to bring to front
    // If used via put, add to front of list or overwrite value 

    ListNode head; 
    ListNode tail;  
    int capacity; 
    int size; 
    HashMap<Integer, ListNode> map; 

    // Will have a cache object (linkedlist), hashmap, capacity
    public LRUCache(int capacity) {
        this.capacity = capacity; 
        this.size = 0 ;
        this.map = new HashMap<>(); 
        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1); 
        this.head.next = tail;
        this.tail.prev = head; 
    }
    
    // If key is not in map, return -1
    // If it is return the value attached
    // when accessed, if not already at front of queue, move to front
    public int get(int key) {

    

    
        if (! this.map.keySet().contains(key)){
            return -1; 
        }

        ListNode currNode = this.map.get(key); 
        ListNode copyNode = new ListNode(currNode.key, currNode.val); 
        removeNode(currNode);
        addNode(copyNode); 
        this.map.put(key, copyNode); 
        return copyNode.val;   
    }
    
    // If it is a new node, add to front of linkedlist
    // if it is already in hashmap, just replace val and call .get()
    //  Check if capacity is reached, if so, remove end of node
    // also may have to deal with initialization if both head and tail are null
    public void put(int key, int value) {
        


        if (! this.map.keySet().contains(key)){
            ListNode newNode = new ListNode(key, value); 
            addNode(newNode); 
            this.map.put(key, newNode); 
            this.size += 1; 

            
            if (this.size > this.capacity){
                this.map.remove(this.tail.prev.key);
                removeNode(this.tail.prev);
                this.size -= 1; 

            
            }

            
        }
        else {
            removeNode(this.map.get(key)); 
            ListNode newNode = new ListNode(key, value);
            this.map.put(key, newNode); 
            addNode(newNode);
        }

        


    }

    public void addNode(ListNode node){
        if (node == null){
            return;
        }
        node.next = this.head.next; 
        node.next.prev = node; 
        node.prev = this.head; 
        this.head.next = node; 
    }

    public void removeNode(ListNode node){
        node.prev.next = node.next; 
        node.next.prev = node.prev; 
        node.prev = null;
        node.next = null; 
    }


    class ListNode {
        int key;
        int val; 
        ListNode next; 
        ListNode prev; 

        ListNode(int key, int val) {
            this.key = key; 
            this.val = val; 
            this.next = null; 
            this.prev = null; 
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */