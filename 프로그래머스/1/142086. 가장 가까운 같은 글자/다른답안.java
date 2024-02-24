import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            answer[i] = i-map.getOrDefault(ch,i+1);  // getOrDefault(a, b) a의 키로 검색하고 없으면 b의 값을 반환
            map.put(ch,i);
        }
        return answer;
    }
}
