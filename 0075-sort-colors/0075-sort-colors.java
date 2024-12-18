class Solution {
    public void sortColors(int[] nums) {
        int low = 0;   // Pointer for 0
        int mid = 0;   // Pointer for current element
        int high = nums.length - 1; // Pointer for 2
        
        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap nums[mid] and nums[low], then increment low and mid
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // Leave 1 in place and just move mid forward
                mid++;
            } else {
                // Swap nums[mid] and nums[high], then decrement high
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
    
}