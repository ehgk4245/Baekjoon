class Solution {
    public String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder();
        char[] cArr = my_string.toCharArray();
        for (char c : cArr) {
            for (int i = 0; i < n; i++) {
                sb.append(String.valueOf(c));
            }
        }
        return sb.toString();
    }
}