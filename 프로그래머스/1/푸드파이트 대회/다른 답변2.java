class Solution {
    public String solution(int[] food) {
        String answer = "0";

        for (int i = food.length - 1; i > 0; i--) {
            for (int j = 0; j < food[i] / 2; j++) {
                answer = i + answer + i; 
            }
        }

        return answer;
    }
}

/*
String 객체가 많이 생성되므로 StringBuilder를 사용하는 것보다 효율적이지 못하다는 의견이 있음.
*/
