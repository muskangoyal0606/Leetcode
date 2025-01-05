class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // Step 1: Find the pivot (smallest element index)
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1; // Pivot is to the right
            } else {
                right = mid; // Pivot is to the left or at mid
            }
        }

        // Now, `left` is the pivot index
        int pivot = left;

        // Step 2: Perform binary search in the appropriate segment
        left = 0;
        right = nums.length - 1;

        if (target >= nums[pivot] && target <= nums[right]) {
            left = pivot; // Search in the right half
        } else {
            right = pivot - 1; // Search in the left half
        }

        // Standard binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Target not found
    }
}