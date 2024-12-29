class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        String[] words= s.split("\\s+");
        StringBuffer rs=new StringBuffer();
        for(int i=words.length-1;i>=0;i--){
                rs.append(words[i]);
                if(i!=0){
                    rs.append(" ");
                }
        }
        return rs.toString();
    }
}