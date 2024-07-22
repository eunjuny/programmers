import java.util.*;

class Solution {
    static long answer = 0; // 최대값을 저장할 변수
    static String[] op = {"+","-","*"}; // 사용할 연산자들
    static boolean[] visited = new boolean[3]; // 연산자가 사용되었는지 확인하기 위한 배열
    static ArrayList<Long> numList = new ArrayList<>(); // 숫자들을 저장할 리스트
    static ArrayList<String> opList = new ArrayList<>(); // 연산자들을 저장할 리스트
    static String[] perm = new String[3]; // 연산자 우선순위 순열을 저장할 배열
    
    public long solution(String expression) {
        String num = "";
        
        // 숫자와 연산자를 구분하여 각각 리스트에 저장
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '*' || c == '+' || c == '-') {
                opList.add(c + ""); 
                numList.add(Long.parseLong(num));
                num = "";
            } else {
                num += c;
            }
        }
        // 마지막 숫자를 리스트에 추가
        numList.add(Long.parseLong(num));
        
        // 연산자의 모든 순열을 생성
        makePermutation(0);
        
        return answer;
    }
    
    static void makePermutation(int depth) {
        if (depth == op.length) {
            // 3개의 연산자 순열을 모두 선택한 경우 -> 연산 수행
            sol();
            return;
        }
        
        for (int i = 0; i < op.length; i++) {
            if (visited[i]) continue; // 이미 선택된 연산자는 건너뜀
            visited[i] = true; // 연산자를 선택함
            perm[depth] = op[i]; // 현재 깊이에 연산자 저장
            makePermutation(depth + 1); // 다음 깊이로 이동
            visited[i] = false; // 연산자 선택 해제
        }
    }
    
    static void sol() {
        // 연산자 리스트 복사
        ArrayList<String> oper = new ArrayList<>(opList);
        
        // 숫자 리스트 복사
        ArrayList<Long> num = new ArrayList<>(numList);
        
        // 연산자 우선순위에 따라 계산
        for (int i = 0; i < perm.length; i++) {
            String op = perm[i];
            for (int j = 0; j < oper.size(); j++) {
                if (oper.get(j).equals(op)) {
                    long n1 = num.get(j);
                    long n2 = num.get(j + 1);
                    long res = cal(n1, n2, op); // 두 숫자를 연산
                    
                    // 리스트 갱신: 사용된 숫자와 연산자를 제거하고 결과를 추가
                    num.remove(j + 1);
                    num.remove(j);
                    oper.remove(j);
                    
                    num.add(j, res);
                    
                    j--; // 다음 연산을 위해 인덱스 조정
                }
            }
        }
        
        // 결과의 절대값과 현재 최대값을 비교하여 더 큰 값 저장
        answer = Math.max(answer, Math.abs(num.get(0)));
    }
    
    static long cal(long n1, long n2, String op) {
        long res = 0;
        switch (op) {
            case "*": 
                res = n1 * n2;
                break;
            case "+":
                res = n1 + n2;
                break;
            case "-":
                res = n1 - n2;
                break;
        }
        return res;
    }
}
