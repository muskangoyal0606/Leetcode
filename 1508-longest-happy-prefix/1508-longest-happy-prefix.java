class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] lps = new int[n]; // LPS array to store lengths of prefix which are also suffix
        int len = 0; // Length of the current longest prefix which is also a suffix
        int i = 1;

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = lps[len - 1]; // Try to find the previous longest prefix which is also suffix
                } else {
                    lps[i] = 0; // No match
                    i++;
                }
            }
        }

        int longestPrefixLength = lps[n - 1]; // Length of the longest happy prefix
        return s.substring(0, longestPrefixLength);
    }
}