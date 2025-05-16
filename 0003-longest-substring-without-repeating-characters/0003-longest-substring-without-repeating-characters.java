class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxl = 0;

        while(right < n){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                maxl = Math.max(maxl,right-left+1);
                right++;
            }else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxl;
    }
}