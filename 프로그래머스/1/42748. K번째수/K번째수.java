import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            int a = commands[i][0] - 1; // 복사를 시작할 인덱스
            int b = commands[i][1]; // 복사가 끝난 다음 인덱스 (마지막 인덱스 + 1 값)
            int c = commands[i][2] - 1;
            System.out.println("a : " + a + " b : " + b + " c : " + c);
            int[] arr = Arrays.copyOfRange(array, a, b);
            Arrays.sort(arr);
            answer[i] = arr[c]; 
        }
        
        return answer;
    }
}