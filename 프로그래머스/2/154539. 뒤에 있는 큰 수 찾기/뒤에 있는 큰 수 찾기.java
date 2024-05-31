import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        // 결과를 저장할 배열을 numbers의 길이로 초기화
        int[] answer = new int[numbers.length];
        
        // answer 배열의 모든 요소를 -1로 초기화
        Arrays.fill(answer, -1);
        
        // 인덱스를 저장할 스택 초기화
        Stack<Integer> stack = new Stack<>();

        // numbers 배열을 순회
        for (int i = 0; i < numbers.length; i++) {
            // 스택이 비어있지 않고 현재 숫자가 스택의 맨 위 인덱스가 가리키는 숫자보다 큰 동안 반복
            while (!stack.isEmpty() && numbers[i] > numbers[stack.peek()]) {
                // 스택에서 인덱스를 꺼내어 answer 배열의 해당 인덱스에 현재 숫자를 저장
                answer[stack.pop()] = numbers[i];
            }
            
            // 현재 인덱스를 스택에 추가
            stack.push(i);
        }

        // answer 배열 반환
        return answer;
    }
}

/*

numbers = [2, 3, 3, 5]

초기 상태
answer = [-1, -1, -1, -1]
stack = []
각 단계별 설명
i = 0 (현재 숫자 2):

스택이 비어 있으므로 while문을 건너뜁니다.
현재 인덱스 0을 스택에 추가합니다.
stack = [0]
i = 1 (현재 숫자 3):

while (!stack.isEmpty() && numbers[i] > numbers[stack.peek()]):
!stack.isEmpty()는 true (스택이 비어 있지 않음)
numbers[1] > numbers[stack.peek()]는 3 > 2이므로 true
두 조건이 모두 true이므로 while문에 들어갑니다.
answer[stack.pop()] = numbers[i]:
stack.pop()은 0을 반환하고 스택에서 제거합니다.
answer[0] = 3으로 설정합니다.
answer = [3, -1, -1, -1]
현재 인덱스 1을 스택에 추가합니다.
stack = [1]
i = 2 (현재 숫자 3):

while (!stack.isEmpty() && numbers[i] > numbers[stack.peek()]):
!stack.isEmpty()는 true (스택이 비어 있지 않음)
numbers[2] > numbers[stack.peek()]는 3 > 3이므로 false
두 번째 조건이 false이므로 while문을 건너뜁니다.
현재 인덱스 2를 스택에 추가합니다.
stack = [1, 2]
i = 3 (현재 숫자 5):

while (!stack.isEmpty() && numbers[i] > numbers[stack.peek()]):
첫 번째 반복:
!stack.isEmpty()는 true (스택이 비어 있지 않음)
numbers[3] > numbers[stack.peek()]는 5 > 3이므로 true
두 조건이 모두 true이므로 while문에 들어갑니다.
answer[stack.pop()] = numbers[i]:
stack.pop()은 2를 반환하고 스택에서 제거합니다.
answer[2] = 5로 설정합니다.
answer = [3, -1, 5, -1]
stack = [1]
두 번째 반복:
!stack.isEmpty()는 true (스택이 비어 있지 않음)
numbers[3] > numbers[stack.peek()]는 5 > 3이므로 true
두 조건이 모두 true이므로 while문에 들어갑니다.
answer[stack.pop()] = numbers[i]:
stack.pop()은 1을 반환하고 스택에서 제거합니다.
answer[1] = 5로 설정합니다.
answer = [3, 5, 5, -1]
stack = []
세 번째 반복:
!stack.isEmpty()는 false (스택이 비어 있음)
while문을 빠져나옵니다.
현재 인덱스 3을 스택에 추가합니다.
stack = [3]
최종 상태
answer = [3, 5, 5, -1]
stack = [3]
요약
i = 0: 2보다 큰 수 없음 (stack = [0])
i = 1: 2보다 큰 3 발견 (answer[0] = 3, stack = [1])
i = 2: 3보다 큰 수 없음 (stack = [1, 2])
i = 3: 3보다 큰 5 발견 (answer[2] = 5, answer[1] = 5, stack = [3])
*/