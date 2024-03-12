class Solution {
    public int solution(long num) {
        int answer = 0;
        
        while(num != 1) {
            if (num % 2 != 0) {
                num = (num * 3) + 1;
                answer++;
                System.out.println(answer + " : " + num);
                if (answer > 500) {
                    answer = -1;
                    break;
                }
            } else {
                num = num / 2;
                System.out.println(answer + " : " + num);
                answer++;
                if (answer > 500) {
                    answer = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}