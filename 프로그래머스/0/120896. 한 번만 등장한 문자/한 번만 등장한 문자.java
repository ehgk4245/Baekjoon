class Solution {
    public String solution(String s) {
        int[] count = new int[26];
        
        char[] cArr = s.toCharArray();
        
        for (char c : cArr) {
            int index = c - 'a';
            count[index]++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < 26; i++) {
            if (count[i] == 1) sb.append((char)('a' + i));
        }
        
        return sb.toString();
    }
}