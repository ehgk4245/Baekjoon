class Solution {
    public int solution(int[] numbers) {
        int answer = -100000000;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i == j) continue;
                answer = Math.max(answer, numbers[i] * numbers[j]);
            }
        }
        return answer;
    }
}