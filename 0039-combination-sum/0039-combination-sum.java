import java.util.ArrayList;
import java.util.List;

class Solution {
    private void findCombinations(int index, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        // Base condition: If the index reaches the end of the array
        if (index == arr.length) {
            // If target is 0, add the current combination to the answer
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        // Pick the current element if it does not exceed the target
        if (arr[index] <= target) {
            ds.add(arr[index]); // Add the current element to the combination
            findCombinations(index, arr, target - arr[index], ans, ds); // Recur with the same index
            ds.remove(ds.size() - 1); // Backtrack to try other combinations
        }

        // Skip the current element
        findCombinations(index + 1, arr, target, ans, ds);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>(); // To store all combinations
        findCombinations(0, candidates, target, ans, new ArrayList<>()); // Helper function call
        return ans;
    }
}
