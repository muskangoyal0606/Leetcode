class Solution {
    public int maxSubArray(int[] nums) {
        int cs = nums[0]; // Start with the first element
        int ms = nums[0]; // Max sum starts as the first element
        
        for (int i = 1; i < nums.length; i++) {
            cs = Math.max(nums[i], cs + nums[i]); // Either start fresh or add to current sum
            ms = Math.max(ms, cs); // Update max sum
        }
        
        return ms;
    }
}