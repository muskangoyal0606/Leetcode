class Solution {
    public int subarraySum(int[] nums, int k) {
        int count  = 0;
        int currentsum = 0;
        HashMap<Integer, Integer> prefixsum = new HashMap<>();
        prefixsum.put(0,1);
        for(int num: nums){
            currentsum = currentsum + num;
            if(prefixsum.containsKey(currentsum-k)){
                count = count + prefixsum.get(currentsum-k);
            }
            prefixsum.put(currentsum, prefixsum.getOrDefault(currentsum,0)+1);
        }
        return count;
    }
}