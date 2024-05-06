import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0 ; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        for (int i= 0; i <= discount.length - 10; i++) {
        HashMap<String, Integer> map2 = new HashMap<>();
            
            for (int j = 0; j < 10; j++) {
                map2.put(discount[i+j], map2.getOrDefault(discount[i+j], 0) + 1);
            }
            
            boolean allZero = true;
            for (String key : map.keySet()) {
                if (map.get(key) != map2.get(key)) {
                    allZero = false;
                    break;
                }
            }
            if (allZero) {
                answer++;
            }
        }
        
        return answer;
    } 
}