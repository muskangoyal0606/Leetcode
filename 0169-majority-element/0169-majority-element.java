class Solution {
    public int majorityElement(int[] nums) {
        int count=0;
        int ele=0;
        int n=nums.length;
        int c=0;
        for(int i=0;i<n;i++){
            if(count==0){
                ele = nums[i];
            }
            if(nums[i]==ele){
                count++;
            }else{
                count--;
            }
        }
         for(int i=0;i<n;i++){
            if(nums[i]==ele){
                c++;
            }
        }
        if(c>=(n/2)){
            return ele;
        }
        return -1;
    }
    
}