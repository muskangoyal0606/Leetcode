class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // Check if mid is at the correct position
            boolean isEvenIndex = (mid % 2 == 0);
            
            if (nums[mid] == nums[mid + 1]) {
                // Pair is on the right side
                if (isEvenIndex) {
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] == nums[mid - 1]) {
                // Pair is on the left side
                if (isEvenIndex) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }
            } else {
                // Found the single element
                return nums[mid];
            }
        }
        
        // Left points to the single element
        return nums[left];
    }
}