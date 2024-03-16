import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr).filter(f -> {
                                return f % divisor == 0;
                            }).sorted().toArray();
        
        return answer.length > 0 ? answer : new int[]{-1};
        
    }
}