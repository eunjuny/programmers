class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String str = Integer.toBinaryString(n); //  2진법으로 변환해주는 함수
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                cnt++;
            }
        }
        
        for (int i = n + 1; i < 1000000; i++) {
            String temp = Integer.toBinaryString(i);
            int tempCnt = 0;
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == '1') {
                    tempCnt++;
                }
            }
            if (cnt == tempCnt) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}