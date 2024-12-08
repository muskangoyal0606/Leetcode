class Solution {
    public int minBitFlips(int start, int goal) {
         int i=0;
         int count=0;
         int res=start^goal;
            
           while (res > 0) {
            count += res & 1; // Check if the least significant bit is 1
            res >>= 1; // Right shift to process the next bit
        }
        
        return count;
        
    }
}