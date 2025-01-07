class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
int n1 = nums1.length, n2 = nums2.length;

    // Ensure the first array is smaller or equal in size
    if (n1 > n2) return findMedianSortedArrays(nums2, nums1);

    int n = n1 + n2; // Total length of combined arrays
    int left = (n1 + n2 + 1) / 2; // Elements in the left half of the partition

    int low = 0, high = n1;
    while (low <= high) {
        int mid1 = (low + high) / 2;
        int mid2 = left - mid1;

        // Define partition values
        int l1 = (mid1 > 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
        int l2 = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;
        int r1 = (mid1 < n1) ? nums1[mid1] : Integer.MAX_VALUE;
        int r2 = (mid2 < n2) ? nums2[mid2] : Integer.MAX_VALUE;

        // Check if the partitions are correct
        if (l1 <= r2 && l2 <= r1) {
            if (n % 2 == 1) {
                // Odd total length: median is the max of the left side
                return Math.max(l1, l2);
            } else {
                // Even total length: median is the average of two middle values
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            }
        } else if (l1 > r2) {
            // Move partition left in nums1
            high = mid1 - 1;
        } else {
            // Move partition right in nums1
            low = mid1 + 1;
        }
    }
    return 0.0; // Should never reach here
    }
    
    
}