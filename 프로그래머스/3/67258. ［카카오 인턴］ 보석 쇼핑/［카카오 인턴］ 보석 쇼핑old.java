import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        Set<String> gemSet = new HashSet<>(Arrays.asList(gems));
        int totalGem = gemSet.size();
        
        Map<String, Integer> result = new HashMap<>();
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        
        for(int i = 0; i < gems.length; i++) {
            result.put(gems[i], result.getOrDefault(gems[i], 0)+1);
            
            while(result.size() == totalGem) {
                if(i - left < minLen) {
                    minLen = i - left;
                    answer[0] = left +1;
                    answer[1] = i +1;
                }
                
                result.put(gems[left], result.get(gems[left]) -1);
                if(result.get(gems[left]) == 0) {
                    result.remove(gems[left]);
                }
                left++;
            }
            
        }
        
        return answer;
    }
}
