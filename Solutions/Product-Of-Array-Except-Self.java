// https://leetcode.com/problems/product-of-array-except-self

class ProductOfArrayExceptSelfSolution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length; 
        int[] prefix = new int[nums.length];
        Arrays.fill(prefix, 1); // Fill in with 1 for multiplication. Prefix for first item is just 1 as its left prefix contributes nothing
        // can break down each value arr[i] where arr[i] == product(arr[0:i-1]) * product(arr[i + 1: n])
        // Dont need traditional nth index elemtn whoich is all

        // Construct left half of prefix 
        for (int i = 1; i < n; i++){
            // remember arr[i] means product up to but not including current number at idx 
            // SO for idx 1, we want values from before prefix up to previous index * value of prev index 
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        // Now, we want to do the suffix
        // For the last elem, its suffix is just 1 (nothing to the right so nothing contributing)
        // can do a running total and add it where necessary
        // remmeber a value is product of both its prefix and suffix
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--){
            prefix[i] *= suffix;
            suffix *= nums[i];
        }
        return prefix;
    }
}