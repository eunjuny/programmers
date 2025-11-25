import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
        int n = food_times.length;
        
        long sum = 0;
        for (int i : food_times) {
            sum+=i;
        }
        if(sum<=k) return -1;
        
        List<int[]> foodList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            foodList.add(new int[]{i+1, food_times[i]});
        }
        
        // 오름차순
        foodList.sort((a, b) -> a[1] - b[1]);
        
        long prev = 0;   // 이전 레이어(한바퀴 순환이 하나의 레이어) 
        int idx = 0;    // 현재 인덱스
        int length = n; // 남은 음식 수
        
        while(idx < n) {
            long curr = foodList.get(idx)[1];
            long diff = curr - prev;
            
            // 만약 food_times = [1,1,3,4,5]인 경우 처럼 같은 값을 가진 경우가 있으면 첫번째 때 if(diff != 0) 조건을 충족하고 두번째 부터는 curr = prev 이므로 if문을 무시함
            if(diff != 0) {
                long usedTime = diff * length;
                if(usedTime > k) {
                    break;
                }
                
                k -= usedTime;
                prev = curr;
            }
            idx++;
            length--;
        }
        
        List<int[]> remain = foodList.subList(idx, n);
        remain.sort((a,b) -> a[0] - b[0]);
        
        return remain.get((int) (k%length))[0];
    }
}