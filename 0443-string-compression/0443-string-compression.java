class Solution {
    public int compress(char[] chars) {
        int write = 0; // Position to write in the array
        int read = 0;  // Position to read in the array
        
        while (read < chars.length) {
            char currentChar = chars[read]; // Current character
            int count = 0;
            
            // Count consecutive repeating characters
            while (read < chars.length && chars[read] == currentChar) {
                read++;
                count++;
            }
            
            // Write the character
            chars[write] = currentChar;
            write++;
            
            // Write the count if greater than 1
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[write] = c;
                    write++;
                }
            }
        }
        
        return write;
    }
}