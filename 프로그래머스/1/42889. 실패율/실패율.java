import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        HashMap<Integer, Double> map = new HashMap<>();
        // 해당 스테이지에 도전했지만 실패한 인원 수 
        // userFailCnts[N+1]값을 얻기 위해 크기를 N+2로 설정 (userFialCnts[1]에 1번 스테이지를 표현하기 위해)
        int[] userFailCnts = new int[N+2];  
        
        // 해당 스테이지에 도달한 인원 수
        int[] userTotalCnts = new int[N+1]; 
        
        for (int stage : stages) {
            userFailCnts[stage]++;
        }
        
        userTotalCnts[N] = userFailCnts[N] + userFailCnts[N+1];
        
        for (int i = N-1; i >= 1; i--) {
          userTotalCnts[i] = userFailCnts[i] + userTotalCnts[i+1];
        }
        
        for (int i = 1; i < userTotalCnts.length; i++) {
            if (userFailCnts[i] == 0 || userTotalCnts[i] == 0) {
                map.put(i, 0.0);    //  해당 스테이지를 도전하고 있는 인원이 없으므로 실패율 0
            } else {
                map.put(i, (double)userFailCnts[i] / userTotalCnts[i]);
            }
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1, o2) -> Double.compare(map.get(o2), map.get(o1)));   // 내림차순 정렬
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
