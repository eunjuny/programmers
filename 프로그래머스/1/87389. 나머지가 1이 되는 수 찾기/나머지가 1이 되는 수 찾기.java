import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int n) {
        ArrayList<Integer> arr = new ArrayList<>();  
        
//         for (int i = 1; i <= n; i++) {
//             if ((n-1) % i == 0) {
//                 arr.add(i);
//             }
//         }
        
//         arr.remove(Integer.valueOf(1)); // 1을 제외한 가장 작은 수
        
        for (int i = 2; i <= n; i++) {  // 애초에 2부터 시작
            if ((n-1) % i == 0) {
                arr.add(i);
            }
        }
        int answer = Collections.min(arr);
        
        return answer;
    }
}