class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder(a);
        int count = 1;  // Start with one repetition of `a`
        
        // Repeat `a` until the length of the repeated string is at least as long as `b`
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }
        
        // Check if `b` is a substring of the repeated string
        if (sb.toString().contains(b)) {
            return count;
        }
        
        // Append one more time to handle cases where `b` spans across repetitions
        sb.append(a);
        count++;
        if (sb.toString().contains(b)) {
            return count;
        }
        
        // If `b` is not a substring even after these attempts, return -1
        return -1;
    }
}