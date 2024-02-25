class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] c = new char[s.length()];
        char x = s.charAt(0);
        int xCnt = 0;
        int oCnt = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (xCnt == oCnt) {
                System.out.println(i);
                // answer가 먼저 오르고 진행된다.
                // xCnt = oCnt = 0 일때도 answer++ 
                // banana의 경우 i가 0, 2, 4일 때 오름.
                // i가 4일때 answer가 오르고 s.length()가 5이므로 i가 5일때는 이 로직을 거치지 않고 결과 출력
                answer++;
                x = s.charAt(i);
                xCnt = 0;
                oCnt = 0;
            } 
            if (x != s.charAt(i)) {
                xCnt++;
            } else {
                oCnt++;
            }
        }
        
        return answer;
    }
}