class Solution {
    public int majorityElement(int[] nums) {
        int length=nums.length;
        for(int i=0;i<length;i++){
            int count=0;
            for(int j=0;j<length;j++){
                if(nums[j]==nums[i]){
                    count++;
                }
            }
            if(count>(length/2)){
                return nums[i];
            }
        }
        return 0;
    }
    
}