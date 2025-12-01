import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] needTime = new int[progresses.length];
        int time = 0;
        
        for(int i = 0; i < progresses.length; i++) {
            needTime[i] = (int)Math.ceil((double)(100 - progresses[i]) / speeds[i]);
        }
        
        List<Integer> result = new ArrayList<>();
        time = needTime[0];
        int cnt = 1;
        
        for (int i = 1; i < progresses.length; i++) {    
            if (time >= needTime[i]) {
                cnt++;
            } else {
                result.add(cnt);
                time = needTime[i];
                cnt = 1;
            }
        }
        
        result.add(cnt);    //  마지막 묶음 추가
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}
