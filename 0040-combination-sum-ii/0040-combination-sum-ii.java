import java.util.*;

class Solution {
    // Function to return all unique combinations in candidates where the numbers sum to target
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates); // Sort to handle duplicates and allow pruning
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    private void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (target == 0) { // Base case: if the target is met, add the current combination to the answer
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            // Skip duplicates in the same recursive level
            if (i > ind && arr[i] == arr[i - 1]) continue;

            // If the current element exceeds the target, no need to proceed further
            if (arr[i] > target) break;

            // Include the current element
            ds.add(arr[i]);
            // Recurse with the next index (i + 1) to ensure each element is used at most once
            findCombinations(i + 1, arr, target - arr[i], ans, ds);
            // Backtrack by removing the last added element
            ds.remove(ds.size() - 1);
        }
    }
    
}
