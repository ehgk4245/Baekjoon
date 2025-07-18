class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isStart = true;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append(' ');
                isStart = true;
                continue;
            } else {
                if (isStart) {
                    sb.append(String.valueOf(s.charAt(i)).toUpperCase());
                } else {
                    sb.append(String.valueOf(s.charAt(i)).toLowerCase());
                }
                isStart = false;
            }
        }
        
        return sb.toString();
    }
}