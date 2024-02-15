import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        // String[] answer = players;	// 이럴 경우, 배열의 참조를 복사하는 것이므로 answer를 변경하면 players도 변경 됨
        String[] answer = Arrays.copyOf(players, players.length);
        
        // 선수 순위를 매번 찾는 시간복잡도를 낮추기 위해 해시맵을 사용해서 선수와 순위 매핑 
        Map<String, Integer> playerIndexMap = new HashMap<>();
        for(int i=0; i<players.length; i++){
            playerIndexMap.put(players[i], i);
        }
        
        for(String calling : callings){
            int rank = playerIndexMap.get(calling);
			String temp = answer[rank -1];
            answer[rank-1] = calling;
            answer[rank] = temp;
            
            // Map 갱신
            playerIndexMap.put(calling, rank-1);
            playerIndexMap.put(temp, rank);
        }
        return answer;
    }
   
}