// https://leetcode.com/problems/task-scheduler

class TaskSchedulerSolution {
    public int leastInterval(char[] tasks, int n) {
        // Use a max-heap priorityqueue in order to do the most frequent nums
        // Once we use it, if not 0, we can add to a 'jail' queue so we can store w/ penalty
        // since it is a cont. amount of time, once we use once, it can be used faster than the next
        // Can use a queue FIFO: put first time it will be available .peek() and then pop pop, second is #

        // Make pq to store values of operations, need counts of tasks (hashmap), then input them
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        Map<Integer, Integer> map = new HashMap<>(); 

        for (int task : tasks){
            map.putIfAbsent(task, 0);
            map.put(task, map.get(task) + 1);
        }

        for (int val : map.values()){
            pq.offer(val);
        }

        // Logic to select current task, keep track of counter, add to 'jail' queue 
        Queue<Integer> queue = new LinkedList<>(); 
        int numCycles = 0; 

        while (! pq.isEmpty() || ! queue.isEmpty()){
            numCycles += 1; 
            if (! pq.isEmpty()){
                int num = pq.poll() - 1; // Decrement, we do this task this cycle
                if (num > 0){
                    queue.add(numCycles + n);
                    queue.add(num);
                }
            }
            // We need to do this every turn so it cant be an else
            // Just make sure it is not empty 
            if (! queue.isEmpty()) {
                if (queue.peek() <= numCycles){
                    queue.remove(); 
                    pq.offer(queue.remove());
                }
            }
            
        }
        return numCycles; 
    }
}