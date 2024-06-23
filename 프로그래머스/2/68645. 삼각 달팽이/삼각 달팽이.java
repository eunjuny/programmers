class Solution {
    public int[] solution(int n) {
		// 등차수열의 합 공식을 사용하여 배열 크기 설정
        int[] answer = new int[n*(n+1) / 2];
		// 직접 값을 대입하기 위한 2차원 배열 생성
        int[][] matrix = new int[n][n];
        
		// x, y 좌표, 배열에 들어갈 값이 되는 변수 선언
		// 이때 시작부터 x좌표가 1 증가하므로 x는 -1로 초기화
        int x = -1, y = 0, value = 1;
        
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
				// 아래
                if(i % 3 == 0) {
                    x++;
                }
				// 우측 
				else if(i % 3 == 1) {
                    y++;
                }
				// 대각선 좌측 위 
				else if(i % 3 == 2) {
                    x--;
                    y--;
                }
                matrix[x][y] = value++;
            }
        }
        
        int index = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
				// 해당 배열에 값이 0일 경우 반복문 종료
                if(matrix[i][j] == 0) {
                    break;
                }
                answer[index++] = matrix[i][j];
            }
        }
        
        return answer;
    }
}