class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // Initialize the result list
        List<List<Integer>> result = new ArrayList<>();
        // Call the recursive function
        findPermutation(nums, new ArrayList<>(), result);
        return result;
    }

    private void findPermutation(int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Base case: If the current permutation's size equals the array length, add it to the result
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Iterate through the array
        for (int num : nums) {
            // Skip the number if it is already in the current permutation
            if (current.contains(num)) continue;

            // Add the number to the current permutation
            current.add(num);
            // Recursive call
            findPermutation(nums, current, result);
            // Backtrack: Remove the last added number
            current.remove(current.size() - 1);
            }
}
}