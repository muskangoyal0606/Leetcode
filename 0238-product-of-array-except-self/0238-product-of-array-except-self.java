class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n= nums.length;
        int[] ans = new int[n];
        int prefixproduct = 1;
        for(int i=0;i<n;i++){
            ans[i] =prefixproduct;
            prefixproduct = prefixproduct * nums[i];
        }
        int suffixproduct =1;
        for(int i=n-1;i>=0;i--){
            ans[i] = ans[i]*suffixproduct;
            suffixproduct = suffixproduct * nums[i];
        }

        return ans;
    }
}