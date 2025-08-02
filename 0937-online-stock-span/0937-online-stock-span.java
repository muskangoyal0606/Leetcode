class StockSpanner {
    public Stack<int[]> s;
    public StockSpanner() {
        s = new Stack<>();
    }
    
    public int next(int price) {
        int ans=1;
        while(!s.isEmpty() && price >= s.peek()[0]){
         ans = ans + s.pop()[1];
        }
        
        s.push(new int[]{price,ans});

        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */