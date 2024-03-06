class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int[] x = new int[10];
        int[] y = new int[10];
        
        // X와 Y의 각 숫자별 개수를 카운트
        for(int i = 0; i < X.length(); i++){
            x[X.charAt(i) - '0']++;
        }
        for(int i = 0; i < Y.length(); i++){
            y[Y.charAt(i) - '0']++;
        }
        /*
        여기서 '0'은 아스키 코드 값이며, '0'의 아스키 코드 값은 48입니다. 그리고 문자열에서 숫자 문자의 아스키 코드 값은 해당 숫자에 48을 빼면 됩니다. 따라서 '1' - '0'은 1이 됩니다.

예를 들어, 문자열 "123"이 있다면,

'1' - '0'은 1이 되어서 x[1]이 1 증가합니다.
'2' - '0'은 2가 되어서 x[2]이 1 증가합니다.
'3' - '0'은 3이 되어서 x[3]이 1 증가합니다.
즉, 이 코드는 문자열에서 각 숫자의 개수를 카운트하는 역할을 합니다.
        */
        // 공통으로 나타나는 숫자들을 이용하여 가장 큰 정수를 만듦
        for(int i = 9; i >= 0; i--){
            for(int j = 0; j < Math.min(x[i], y[i]); j++){
                answer.append(i);
            }
        }
        
        // 결과가 없으면 -1 반환
        if (answer.length() == 0) {
            return "-1";
        } 
        // 결과가 0으로만 이루어져 있으면 0 하나만 반환
            // 가장 큰 정수를 만들었기 때문에 첫번째 문자가 '0'으로 시작하면 '0' 하나만 출력
        else if (answer.charAt(0) == '0') {
            return "0";
        } 
        // 결과 반환
        else {
            return answer.toString();
        }
    }
}


