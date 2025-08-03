class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n =nums.length;
        long[] prefixsum = new long[n+1];
        for(int i=1;i<=n;i++){
            prefixsum[i] = prefixsum[i-1]+nums[i-1];;
        }
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        int[] left = new int[n];
        int[] right = new int[n];

        for(int i=0;i<n;i++){
            while(!s1.isEmpty()&& nums[i]<=nums[s1.peek()]){
                s1.pop();
            }
            if(s1.isEmpty()){
                left[i] =-1;
            }else{
                left[i] = s1.peek();
            }
            s1.push(i);
        }
        for(int i=n-1;i>=0;i--){
            while(!s2.isEmpty()&& nums[i]<=nums[s2.peek()]){
                s2.pop();
            }
            if(s2.isEmpty()){
                right[i] =n;
            }else{
                right[i] =s2.peek();
            }
            s2.push(i);
        }

        long max=0;
        for(int i=0;i<n;i++){
            long sum = prefixsum[right[i]]-prefixsum[left[i]+1];
            long product = sum * nums[i];
            max = Math.max(product,max);
        }
        return (int)(max%1000000007);
    }
}