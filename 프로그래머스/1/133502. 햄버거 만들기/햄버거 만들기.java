import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        List<Integer> arr = new ArrayList<>();
        
        for (int i : ingredient) {
            arr.add(i);
        }
        
        for (int i = 0; i < arr.size()-3; i++) {
            if (arr.get(i) == 1) {
                if (arr.get(i+1) == 2 && arr.get(i+2) ==3 && arr.get(i+3) == 1) {
                    answer++;
                    arr.subList(i, i+4).clear();
                    i = Math.max(-1, i-4); // i를 재설정하여 중복 검사를 방지합니다.

                }
            }
        }
        return answer;
    }
}