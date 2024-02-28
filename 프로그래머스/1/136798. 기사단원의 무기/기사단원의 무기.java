import java.lang.Math;
import java.util.ArrayList;

class Solution {
    public int solution(int number, int limit, int power) { 
        // ArrayList<Integer> arr = new ArrayList<>();
        int answer = 0;
        
        for (int i = 1; i <= number; i++) {
            int cnt = 0;
            // 약수는 대칭값이 존재한다. 예를들어 100이면 (2, 50), (4, 25) 이런식으로 작은 값을 구하면 큰 값을 계산 가능하다.
            // 이때 작은 값은 100의 제곱근보다 크거나 작으므로 제곱근을 이용해서 계산하면 효율을 높일 수 있다.
            double sqrt = Math.sqrt(i); 
            for (int j = 1; j <= sqrt; j++) {
                if (i % j == 0) {
                   cnt += 2;
                    if (j == sqrt) {    // sqrt를 int로 하면 내림이 적용돼서 오류 발생 (2, 3도 sqrt가 1로 나옴)
                        cnt--;
                    }
                } 
            }
            System.out.println(cnt);
            answer += cnt > limit ? power : cnt;
        }
        return answer;
    }
}