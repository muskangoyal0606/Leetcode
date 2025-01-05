class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check if the mid is in the increasing part of the array
            if (arr[mid] < arr[mid + 1]) {
                // Move to the right
                left = mid + 1;
            } else {
                // Move to the left
                right = mid;
            }
        }

        // At the end of the binary search, left == right, which points to the peak index
        return left;
    }
}