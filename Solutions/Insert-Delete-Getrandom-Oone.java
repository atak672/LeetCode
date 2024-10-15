// https://leetcode.com/problems/insert-delete-getrandom-o1

class RandomizedSet {
    
    List<Integer> list;
    Map<Integer, Integer> map; 
    Random rand;


    public RandomizedSet() {
        this.list = new ArrayList<>(); 
        this.map = new HashMap<>(); 
        this.rand = new Random(); 
    }
    
    public boolean insert(int val) {
        if (map.keySet().contains(val)){
            return false;
        }
        map.put(val, this.list.size());
        this.list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (! map.keySet().contains(val)){
            return false;
        }
        // set the idx or the to be removed val to the latest item in the arraylist
        int idx = list.size() - 1; 
        this.list.set(map.get(val), this.list.get(idx));
        map.put(this.list.get(idx), map.get(val));
        map.remove(val);
        list.remove(idx);
        return true;    
    }
    
    public int getRandom() {
        int rand_int = rand.nextInt(list.size());
        return list.get(rand_int);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */