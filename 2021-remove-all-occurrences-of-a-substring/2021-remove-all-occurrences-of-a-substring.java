class Solution {
    public String removeOccurrences(String s, String part) {
       Stack<Character> stack = new Stack<>();
    int L = part.length();
    
    // Iterate through the string s
    for (int i = 0; i < s.length(); i++) {
        // Push the current character onto the stack
        stack.push(s.charAt(i));
        
        // Check if the stack has enough characters to form 'part'
        if (stack.size() >= L) {
            // Create a temporary string from the top of the stack
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < L; j++) {
                sb.append(stack.get(stack.size() - L + j));
            }
            
            // If the top of the stack forms the substring 'part', pop those characters
            if (sb.toString().equals(part)) {
                for (int j = 0; j < L; j++) {
                    stack.pop();
                }
            }
        }
    }
    
    // Convert the stack back into a string
    StringBuilder result = new StringBuilder();
    for (Character c : stack) {
        result.append(c);
    }
    
    return result.toString();
    }
}