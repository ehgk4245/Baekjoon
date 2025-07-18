class Solution {
    public int[] solution(String s) {
        int zeroCountSum = 0;
        int count = 0;
        
        while (s.length() > 1) {
            int zeroCount = (int) s.chars().filter(i -> i == '0').count();
            zeroCountSum += zeroCount;
            s = Integer.toBinaryString(s.length() - zeroCount);
            count++;
        }
        
        return new int[] {count, zeroCountSum};
    }
}