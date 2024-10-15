// https://leetcode.com/problems/merge-sorted-array

class MergeSortedArraySolution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int sorted = m + n - 1; 
        int i = m - 1; 
        int j = n - 1; 

        while (i >= 0 && j >= 0){
            if (nums1[i] >= nums2[j]){
                nums1[sorted] = nums1[i];
                sorted -= 1; 
                i -= 1; 
            }
            else {
                nums1[sorted] = nums2[j];
                sorted -= 1; 
                j -= 1; 
            }

        }

        while (i >= 0){
            nums1[sorted] = nums1[i];
            i -= 1; 
            sorted -= 1; 
        }

        while (j >= 0){
            nums1[sorted] = nums2[j];
            j -= 1; 
            sorted -= 1; 
        }
        
    }
}