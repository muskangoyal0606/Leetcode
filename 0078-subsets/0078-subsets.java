class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int psize = (1 << n); // Total number of subsets (2^n)
        List<List<Integer>> result = new ArrayList<>();

        // Generate all subsets
        for (int i = 0; i < psize; i++) {
            List<Integer> subset = new ArrayList<>(); // Temporary list for the current subset
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) { // Check if the j-th bit in i is set
                    subset.add(nums[j]); // Add nums[j] to the current subset
                }
            }
            result.add(subset); // Add the current subset to the result list
        }

        return result;
    }
}