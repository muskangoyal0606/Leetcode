

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to handle duplicates
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempSet, int[] nums, int start) {
        // Add the current subset to the result
        result.add(new ArrayList<>(tempSet));

        for (int i = start; i < nums.length; i++) {
            // Skip duplicates
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // Include the current number
            tempSet.add(nums[i]);

            // Recur with the next index
            backtrack(result, tempSet, nums, i + 1);

            // Exclude the current number (backtrack)
            tempSet.remove(tempSet.size() - 1);
        }
    }
}