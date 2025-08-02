class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> m = new HashMap<>();
        int f=0;
        for(char c:s.toCharArray()){
            m.put(c,m.getOrDefault(c,0)+1);
            
        }
        for(int i=0;i<s.length();i++){
            if(m.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}