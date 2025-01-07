class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;        // Length of first array  
        int m = nums2.length;        // Length of second array  
        int[] result = new int[n + m];  // Resultant array of size n + m  
        
        // Merge the arrays
        System.arraycopy(nums1, 0, result, 0, n);  
        System.arraycopy(nums2, 0, result, n, m); 
        
        // Sort the merged array
        Arrays.sort(result);
        
        // Calculate the median
        int length = result.length;
        if (length % 2 == 0) {
            // Even number of elements: take the average of two middle elements
            return (result[length / 2 - 1] + result[length / 2]) / 2.0;
        } else {
            // Odd number of elements: take the middle element
            return result[length / 2];
        }
    }
}