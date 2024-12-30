class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder result = new StringBuilder(s);

        // Continue until no occurrence of `part` exists
         while (result.toString().contains(part))  {
            // Find the index of the first occurrence of `part`
            int index = result.indexOf(part);

            // Remove `part` from `result`
            result.delete(index, index + part.length());
        }

        return result.toString();
    }
}