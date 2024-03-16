class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        
        for (int i = 0; i < seoul.length; i++) {    
            // == 는 두 문자열이 메모리상의 동일한 객체인지를 비교한다. 따라서 equals()메서드를 사용해야 한다.
            if ("Kim".equals(seoul[i])) {
                System.out.println(seoul[i]);
                answer = "김서방은 " + i + "에 있다";
            }
        }
        return answer;
    }
}