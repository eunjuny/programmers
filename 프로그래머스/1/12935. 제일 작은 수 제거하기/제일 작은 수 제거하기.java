import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        
        if (arr.length == 1) {
            return new int[]{-1};
        } else {
            int min = Arrays.stream(arr).min().getAsInt();
            int[] answer = new int[arr.length - 1];
            int idx = 0;
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] == min) {
                    continue;
                } 
                answer[idx++] = arr[i];
            }
            return answer;
        }
        
        
    }
}