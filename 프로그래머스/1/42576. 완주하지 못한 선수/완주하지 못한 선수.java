import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();   
     
        // 참가자 목록을 해시맵에 추가하고, 이름이 같은 경우 카운트를 증가시킴
        for (String name : participant) {
            // getOrDefault(name, 0) + 1 는 key가 name인 값이 있으면 해당 값을 출력하고 없으면 0을 출력한 후 1을 더함 
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        // 완주자 목록을 해시맵에서 제거
        for (String name : completion) {
            map.put(name, map.get(name) - 1);
        }
        
        // 카운트가 0이 아닌 이름이 완주하지 못한 참가자
        for (String name : map.keySet()) {
            if (map.get(name) != 0) {
                return name;
            }
        }
        
        return null;
    }
}
