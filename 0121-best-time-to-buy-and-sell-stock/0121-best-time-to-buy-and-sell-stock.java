class Solution {
    public int maxProfit(int[] prices) {
        int bp=Integer.MAX_VALUE;
        int maxp=0;
        for(int i=0;i<prices.length;i++){
            if(bp<prices[i]){
                int profit = prices[i] - bp;
                maxp = Math.max(profit,maxp); 
            }else{
                bp = prices[i];
            }
        }
        return maxp;
    }
}