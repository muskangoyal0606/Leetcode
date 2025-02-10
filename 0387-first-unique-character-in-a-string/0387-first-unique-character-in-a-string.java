class Solution {
    public int firstUniqChar(String s) {
        int[] char_count = new int[26];
        
        // Count occurrences of each character
        for (int i = 0; i < s.length(); i++) {
            char_count[s.charAt(i) - 'a']++;
        }
        
        // Find the first unique character
        for (int i = 0; i < s.length(); i++) {
            if (char_count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        
        return -1; // No unique character found
    }
}