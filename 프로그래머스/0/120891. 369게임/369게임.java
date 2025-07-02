class Solution {
    public int solution(int order) {
        int count = 0;
        while (order > 0) {
            int num = order % 10;
            order /= 10;
            if (num != 0 && num % 3 == 0) count++;
        }
        return count;
    }
}