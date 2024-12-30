class Solution {
    public int romanToInt(String s) {
       // Map Roman numerals to their integer values
        java.util.Map<Character, Integer> romanToValue = new java.util.HashMap<>();
        romanToValue.put('I', 1);
        romanToValue.put('V', 5);
        romanToValue.put('X', 10);
        romanToValue.put('L', 50);
        romanToValue.put('C', 100);
        romanToValue.put('D', 500);
        romanToValue.put('M', 1000);

        int total = 0;
        int prevValue = 0;

        // Traverse the string from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = romanToValue.get(s.charAt(i));
            
            // Check if we need to add or subtract
            if (currentValue < prevValue) {
                total -= currentValue;
            } else {
                total += currentValue;
            }

            prevValue = currentValue; // Update the previous value
        }

        return total; 
    }
}