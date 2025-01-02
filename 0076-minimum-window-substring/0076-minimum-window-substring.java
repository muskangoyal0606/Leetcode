class Solution {
    public String minWindow(String s, String t) {
        if (t.length() == 0) {
            return "";
        }

        // Frequency map for characters in t
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        // Sliding window variables
        Map<Character, Integer> windowMap = new HashMap<>();
        int currentCount = 0;
        int requiredCount = tMap.size();
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int[] resultIndices = new int[]{-1, -1};

        while (right < s.length()) {
            char rightChar = s.charAt(right);

            // Expand the window
            if (tMap.containsKey(rightChar)) {
                windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);

                if (windowMap.get(rightChar).equals(tMap.get(rightChar))) {
                    currentCount++;
                }
            }

            // Shrink the window while it satisfies the condition
            while (currentCount == requiredCount) {
                // Update the result if the current window is smaller
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    resultIndices[0] = left;
                    resultIndices[1] = right;
                }

                char leftChar = s.charAt(left);

                // Shrink the window
                if (tMap.containsKey(leftChar)) {
                    windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                    if (windowMap.get(leftChar) < tMap.get(leftChar)) {
                        currentCount--;
                    }
                }
                left++;
            }
            right++;
        }

        // Return the result
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(resultIndices[0], resultIndices[1] + 1);
    }
}