import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++) {
            if(map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1); 
            } else {
                map.put(clothes[i][1], 1);
            }
        }    
        for (String key : map.keySet()) {
            System.out.println(map.get(key));
            answer *= (map.get(key) + 1); // 해당 부위의 아이템이 하나도 선택 안될 경우를 포함
        }
        
        return answer - 1;  // 모든 아이템을 선택하지 않은 경우는 제외
    }
}