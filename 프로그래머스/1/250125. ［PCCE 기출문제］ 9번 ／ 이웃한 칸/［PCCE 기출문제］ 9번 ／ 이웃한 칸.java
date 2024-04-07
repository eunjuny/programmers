import java.util.*;

class Solution {

    public int solution(String[][] board, int h, int w) {


        int n = board.length; // 변수 n 에 보드의 크기를 저장.

        int count = 0; // 저장할 변수,count 에 0 저장.

        int[] dh = {0, 1, -1, 0}; // h의 변화량 정수리스트

        int[] dw = {1, 0, 0, -1}; // w의 변화량 정수리스트

        for(int i =0; i<4; i++) { // 반복문 사용. i를 0부터 3까지 1씩 증가시키면서 수행

            int h_check = h + dh[i]; // h좌표

            int w_check = w + dw[i]; // w좌표

            

            if(h_check >= 0 && h_check < n && w_check >= 0 && w_check < n) { 

// h_check가 0 이상 n 미만이고 w_check가 0 이상 n 미만일 때 수행하는 조건if 사용

                if(board[h][w].equals(board[h_check][w_check])) { 

// equals메서드를 통해  board[h][w]와 board[h_check][w_check]의 값이 동일하다면 count의 값을 1 증가

                    count ++; 

                }

            }

        }

        return count; //카운트값을 리턴.

    }

}