import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        ArrayList<String> arr = new ArrayList<>();
        
        for (int i = 0; i < strings.length; i++) {
            arr.add(strings[i].charAt(n) + strings[i]); // n번째 문자 + 문자열 (n번째 문자를 맨 앞에 추가하고 정렬)
        }
        
        Collections.sort(arr);
        
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i).substring(1, arr.get(i).length());   // 맨 앞 문자 제거
        }
        
        return answer;
    }
}