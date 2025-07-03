class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for (int num = i; num <= j; num++) {
            int tmp = num;
            while (tmp > 0) {
                int n = tmp % 10;
                tmp /= 10;
                if (k == n) answer++;
            }
        }
        return answer;
    }
}