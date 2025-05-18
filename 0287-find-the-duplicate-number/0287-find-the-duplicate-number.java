class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> n = new HashSet<>();
        int a=0;
        for(int i=0;i<nums.length;i++){
            if(n.contains(nums[i])){
                a =nums[i];
            }
            n.add(nums[i]);
        }
        return a;
    }
}