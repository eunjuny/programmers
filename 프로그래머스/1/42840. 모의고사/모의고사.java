import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int len = answers.length;
        
        // 수포자들의 답안 패턴 설정
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        // 각 수포자들이 맞힌 문제의 개수 계산
        int scoreOne = calculateScore(answers, one);
        int scoreTwo = calculateScore(answers, two);
        int scoreThree = calculateScore(answers, three);
        
        System.out.println(scoreOne);
        System.out.println(scoreTwo);
        System.out.println(scoreThree);
        
        // 맞힌 문제의 개수가 가장 많은 수포자 찾기
        int maxScore = Math.max(Math.max(scoreOne, scoreTwo), scoreThree);
        List<Integer> winners = new ArrayList<>();
        if (scoreOne == maxScore) winners.add(1);
        if (scoreTwo == maxScore) winners.add(2);
        if (scoreThree == maxScore) winners.add(3);
        
        // List를 배열로 변환
        int[] answer = new int[winners.size()];
        for (int i = 0; i < winners.size(); i++) {
            answer[i] = winners.get(i);
        }
        
        return answer;
    }
    
    // 각 수포자가 맞힌 문제의 개수 계산하는 함수
    private int calculateScore(int[] answers, int[] pattern) {
        int score = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == pattern[i % pattern.length]) {
                score++;
            }
        }
        return score;
    }
}
