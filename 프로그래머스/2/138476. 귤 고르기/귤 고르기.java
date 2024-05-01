import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < tangerine.length; i++) {
            if(map.containsKey(tangerine[i])) {
                map.put(tangerine[i], map.get(tangerine[i])+1);
            } else {
                map.put(tangerine[i], 1);
            }
        }
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        
        Collections.sort(list, new Comparator<>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());  // 내림차순
            }
        });
        
        int sum = 0;
        
        while (sum < k) {
            sum += list.get(answer).getValue();
            answer++;
        }
        
        return answer;
    }
}