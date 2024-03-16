import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> answer = new ArrayList<>(); 
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                answer.add(arr[i]);
            }
        }
        
        if (answer.isEmpty()) {
            return new int[]{-1};
        }
        
        int[] as = new int[answer.size()];
        for (int j = 0; j < answer.size(); j++) {
            as[j] = answer.get(j);
        }
        
        Arrays.sort(as);
        return as;
    }
}