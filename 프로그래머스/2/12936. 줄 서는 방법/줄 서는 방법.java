import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n]; // 결과를 저장할 배열
        List<Integer> list = new ArrayList<>(); // 1부터 n까지의 숫자를 저장할 리스트

        long f = 1; // 팩토리얼 값을 저장할 변수
        for(int i = 1; i <= n; i++) {
            list.add(i); // 리스트에 1부터 n까지 숫자 추가
            f *= i; // n! 값을 계산
        }

        k--; // k는 0부터 시작하므로 k를 1 감소시킴
        int idx = 0; // 결과 배열의 인덱스
        while (idx < n) {
            f /= n - idx; // 현재 남은 숫자들의 팩토리얼 값을 계산
            // k / f 값을 인덱스로 하여 리스트에서 숫자를 선택하고, 그 숫자를 결과 배열에 추가
            answer[idx++] = list.remove((int) (k / f)); 
            // k를 현재 팩토리얼 값으로 나눈 나머지를 새로운 k로 설정
            k %= f;
        }

        return answer; // 결과 배열 반환
    }
}
