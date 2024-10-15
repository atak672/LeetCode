// https://leetcode.com/problems/minimum-operations-to-make-all-array-elements-equal

class MinimumOperationsToMakeAllArrayElementsEqualSolution {
    public List<Long> minOperations(int[] nums, int[] queries) {

    
        List<Long> ret = new ArrayList<>();

         // Sort nums
        Arrays.sort(nums);

        // Sum of the array up to but not including idx i
        long[] prefix = new long[nums.length + 1];
        for (int i = 1; i <= nums.length; i++){
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        // for (long pre : prefix){
        //     System.out.print(pre + " ");
        // }
        //  System.out.print("\n");


        for (int target : queries){
            long total = 0; 
            // Need to do binary search to find right most occurrence of = to query or boundary between < and >

            int start = 0; 
            int end = nums.length - 1;
            while (start <= end){
                int mid = start + ((end - start)/2);
                if (nums[mid] <= target){
                    start = mid + 1; 
                }
                else {
                    end = mid - 1; 
                }
            }

            if (end >= 0){
                 total += ((end + 1) * (long) target)  - prefix[end + 1]; // Sum of all numbers up to and including mid
            }
            if (end <= nums.length - 1){
                 total += (prefix[prefix.length - 1] - prefix[end + 1]) - ((nums.length - 1 - end) * (long) target);

            }

            ret.add(total);


    
        }

           return ret;
    }

}