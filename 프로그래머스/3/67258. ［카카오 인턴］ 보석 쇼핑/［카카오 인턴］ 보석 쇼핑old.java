import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        Set<String> gemSet = new HashSet<>(Arrays.asList(gems));
        int totalGem = gemSet.size();
        
        Map<String, Integer> result = new HashMap<>();
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        
        // 윈도우를 이동하면서 최소 구간 탐색
        for(int i = 0; i < gems.length; i++) {
            result.put(gems[i], result.getOrDefault(gems[i], 0) +1);
            
            while(result.size() == totalGem) {  // 모든 보석이 다 들어 있다면
                if(i - left < minLen) { // 왼쪽에서 부터 중복 제거해서 길이 줄이기 위한 작업
                    minLen = i - left;
                    answer[0] = left + 1;
                    answer[1] = i + 1;
                }
                
                result.put(gems[left], result.get(gems[left])-1); 
                if(result.get(gems[left]) == 0) {
                    result.remove(gems[left]);  // 보석이 하나도 안남고 지워졌으면 해당 보석 제거해서 루프 탈출
                }
                left++; // 한칸 증가한 시작점에서 재시작
            } 
        }
        
        
        return answer;
    }
}
