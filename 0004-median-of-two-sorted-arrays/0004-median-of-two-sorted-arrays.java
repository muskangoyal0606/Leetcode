class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int n1 = nums1.length;  // Length of the first array
        int n2 = nums2.length;  // Length of the second array
        int n = n1 + n2;        // Total length of the combined array
        
        int ind1 = (n - 1) / 2;  // First median index
        int ind2 = n / 2;        // Second median index (same as ind1 for odd lengths)
        
        int cnt = 0;   // Count of merged elements so far
        int i = 0, j = 0;  // Pointers for nums1 and nums2
        int ind1el = -1, ind2el = -1;  // Median elements

        // Traverse nums1 and nums2 simultaneously
        while (i < n1 && j < n2) {
            int val;
            if (nums1[i] <= nums2[j]) {
                val = nums1[i++];
            } else {
                val = nums2[j++];
            }
            
            if (cnt == ind1) ind1el = val;
            if (cnt == ind2) ind2el = val;
            cnt++;
        }

        // If nums1 has remaining elements
        while (i < n1) {
            if (cnt == ind1) ind1el = nums1[i];
            if (cnt == ind2) ind2el = nums1[i];
            i++;
            cnt++;
        }

        // If nums2 has remaining elements
        while (j < n2) {
            if (cnt == ind1) ind1el = nums2[j];
            if (cnt == ind2) ind2el = nums2[j];
            j++;
            cnt++;
        }

        // Calculate the median
        if (n % 2 == 1) {
            // Odd length: median is the middle element
            return ind1el;
        } else {
            // Even length: median is the average of the two middle elements
            return (ind1el + ind2el) / 2.0;
        }
    }
    
    
}