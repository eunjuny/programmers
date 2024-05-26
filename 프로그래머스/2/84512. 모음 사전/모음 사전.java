class Solution {
    public int solution(String word) {
        String str = "AEIOU"; // 모음 문자열
        int[] nums = {781, 156, 31, 6, 1}; // 각 자리수의 가중치
        int answer = word.length(); // word의 길이로 초기화

        // 배열 word 순회
        for (int i = 0; i < word.length(); i++) {
            // 현재 문자가 모음 str의 몇 번째 인덱스인지 저장
            int idx = str.indexOf(word.charAt(i));
            // 현재 문자의 가중치 * idx
            answer += nums[i] * idx;
        }

        return answer;
    }
}