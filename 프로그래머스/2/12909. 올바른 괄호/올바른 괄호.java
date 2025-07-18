import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (st.empty()) return false;
                st.pop();
            } else {
                st.push(c);
            }
        }
        
        if (st.empty()) return true;
        return false;
    }
}