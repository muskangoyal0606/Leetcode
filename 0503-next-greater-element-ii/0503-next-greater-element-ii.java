

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); // Initialize with -1
        Stack<Integer> stack = new Stack<>();

        // Iterate twice to simulate circular array
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n]; // Circular index

            // While stack is not empty and current element is greater than the element at index stored in stack
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                result[stack.pop()] = num; // Update result array
            }

            // Push only indices from first pass (i < n) to avoid redundant values
            if (i < n) stack.push(i);
        }

        return result;
    }

}