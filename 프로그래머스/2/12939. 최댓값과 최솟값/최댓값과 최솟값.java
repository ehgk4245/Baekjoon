class Solution {
    public String solution(String s) {
        String[] strNum = s.split(" ");
        int max = Integer.parseInt(strNum[0]);
        int min = Integer.parseInt(strNum[0]);
        for (String ss : strNum) {
            int num = Integer.parseInt(ss);
            if (max < num) max = num;
            if (min > num) min = num;
        }
        
        return min + " " + max;
    }
}