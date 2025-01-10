class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int n1 = nums1.length, n2 = nums2.length;

    // Ensure the first array is the smaller one.
    if (n1 > n2) {
        int[] temp = nums1;
        nums1 = nums2;
        nums2 = temp;
        n1 = nums1.length;
        n2 = nums2.length;
    }

    int n = n1 + n2; // Total length of combined arrays
    int left = (n + 1) / 2; // Size of the left partition

    int low = 0, high = n1;

    // Binary search to find the correct partition.
    while (low <= high) {
        int mid1 = (low + high) / 2;
        int mid2 = left - mid1;

        // Values on either side of the partition.
        int l1;
        if (mid1 > 0) {
            l1 = nums1[mid1 - 1];
        } else {
            l1 = Integer.MIN_VALUE;
        }

        int l2;
        if (mid2 > 0) {
            l2 = nums2[mid2 - 1];
        } else {
            l2 = Integer.MIN_VALUE;
        }

        int r1;
        if (mid1 < n1) {
            r1 = nums1[mid1];
        } else {
            r1 = Integer.MAX_VALUE;
        }

        int r2;
        if (mid2 < n2) {
            r2 = nums2[mid2];
        } else {
            r2 = Integer.MAX_VALUE;
        }

        if (l1 <= r2 && l2 <= r1) {
            if (n % 2 == 1) {
                return Math.max(l1, l2);
            } else {
                return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            }
        } else if (l1 > r2) {
            high = mid1 - 1;
        } else {
            low = mid1 + 1;
        }
    }

    return 0.0;
    }
    
    
}