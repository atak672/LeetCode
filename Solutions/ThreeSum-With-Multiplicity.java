// https://leetcode.com/problems/3sum-with-multiplicity

class ThreeSumWithMultiplicitySolution {
    public int threeSumMulti(int[] arr, int target) {
        
        // Sort
        // Fix i
        // use two pointer method to check for two sum given fixed i and target
        // If found, move both
        // If too small, move left
        // too big, move right
        // No duplicates, make sure i is unqiue each iteration, and if item found, move left until new value found
        // If we ensure i has no dupes and make sure left is unique, right is guaranteed to be unique bc if an x + y + z is found, x and z dont change, 
        // and y does, it forced a diff sum 

        // If value is found, it all three are found, total * total - 1 * total - 2 / 6 (which is 3!)
        // If two match, total * total - 1 / 2 (which is 2!)
        // Else just the respective totals 
        // We need counts before going further 

        // Frequency counts
        Map<Integer, Long> map = new HashMap<>(); 
        for (int a : arr){
            map.putIfAbsent(a, (long) 0);
            map.put(a, map.get(a) + 1);
        }

        // Sort for easy traversal and two sum approach -- algo is O(N^2) anyway so O(NlogN) isnt changing asymptotic runtime
        Arrays.sort(arr);
        int n = arr.length;
        long ret = 0;

        // Fix i
        for (int i = 0; i < n; i++){
            // Ensure unique i
            if (i != 0 && arr[i] == arr[i - 1]){
                continue; 
            }

            // Two sum approach intiialization and loop
            int left = i + 1; 
            int right = n - 1; 
            while (left < right){
                int a = arr[i];
                int b = arr[left];
                int c = arr[right];
                int val = a + b + c; 

                // Valid value found
                if (val == target){
                    
                    //System.out.println("a: " + a + " b: " + b + " c: " + c);
                    // If all values are the same-- count combinations of nums
                    if (a == b && b == c){
                        ret += ((map.get(a) * (map.get(a) - 1) * (map.get(a) - 2))/6); 
                    }
                    // If two are the same (say a and b)
                    else if (a == b){
                        ret += ((map.get(a) * (map.get(a) - 1) * map.get(c))/2);

                    }
                    // if b and c are same
                    else if (c == b){
                        ret += ((map.get(a) * map.get(b) * (map.get(b) - 1))/2);

                    }
                    // if a and c are the same
                    else if (a == c){
                        ret += ((map.get(a) * (map.get(a) - 1) * map.get(b))/2);

                    }
                    // None are same
                    else {
                        ret += (map.get(a) * map.get(b) * map.get(c));
                    }
                    
                    // Make sure unique left value, min value is 1 so can check prev
                    left += 1; 
                    while (left < right && arr[left] == arr[left - 1]){
                        left += 1; 
                    }
                    right -= 1; 
                }

                else if (val < target){
                    // Move start
                    left += 1; 
                }
                else {
                    // Move end
                    right -= 1; 
                }
            }
        }
        return (int) (ret % (1000000007));
    }
}