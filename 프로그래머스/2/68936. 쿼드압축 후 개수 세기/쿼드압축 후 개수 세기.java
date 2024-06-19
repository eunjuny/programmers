class Solution {
    
    // 분할정복 문제
    // Step 1) 작은 영역으로 나누기
    // Step 2) 나누어진 작은 영역 계산
    // Step 3) 필요 시, 해결된 답 모으기
    
    // 결과를 저장할 배열
    static int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        int totalSize = arr.length;
        // 전체 배열에 대해 분할정복 시작
        dq(0, 0, totalSize, arr);
        return answer;
    }
    
    // 분할 정복 함수
    private static void dq(int startX, int startY, int size, int[][] arr) {
        // 주어진 영역이 모두 같은 값인지 확인
        if (check(startX, startY, size, arr)) {
            // 모두 같은 값이면 해당 값을 카운트
            answer[arr[startX][startY]]++;
            return;
        }
        
        // 영역을 4등분하여 재귀적으로 처리
        int newSize = size / 2;
        dq(startX, startY, newSize, arr); // 왼쪽 위
        dq(startX + newSize, startY, newSize, arr); // 오른쪽 위
        dq(startX, startY + newSize, newSize, arr); // 왼쪽 아래
        dq(startX + newSize, startY + newSize, newSize, arr); // 오른쪽 아래
    }    
    
    // 영역 안의 모든 숫자가 같은 값이면 true 반환
    private static boolean check(int x, int y, int size, int[][] arr) {
        int value = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                // 하나라도 다른 값이 있으면 false 반환
                if (arr[i][j] != value) {
                    return false;
                }
            }
        }
        return true; // 모든 값이 같으면 true 반환
    }
}
