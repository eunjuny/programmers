// import java.util.Arrays;

// class Solution {
//     public int[] solution(int[] numbers) {
//         int[] answer = new int[numbers.length];
//         int[] sortedNumbers = numbers.clone();
//         Arrays.sort(sortedNumbers);
//         int maxNum = sortedNumbers[sortedNumbers.length - 1];
        
//         for (int i = 0; i < numbers.length; i++) {
//             for (int j = i; j < numbers.length; j++) {
//                 answer[i] = -1;
//                 if (numbers[i] == maxNum) {
//                     break;
//                 } else if (numbers[i] < numbers[j]) {
//                     answer[i] = numbers[j];
//                     break;
//                 }
//             }
//         }
        
//         return answer;
//     }
// }
import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
		Arrays.fill(answer, -1);
		
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < numbers.length; i++) {
			while (!stack.isEmpty() && numbers[i] > numbers[stack.peek()]) {
				answer[stack.pop()] = numbers[i];
			}
			
			stack.push(i);
		}

		return answer;
    }
}