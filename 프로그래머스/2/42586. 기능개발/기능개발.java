import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> progQ = new LinkedList<>();
        Queue<Integer> speedQ = new LinkedList<>();
        
        for (int p : progresses) progQ.add(p);
        for (int s : speeds) speedQ.add(s);
        
        List<Integer> result = new ArrayList<>();

        while (!progQ.isEmpty()) {
            // 하루 진행
            int size = progQ.size();
            for (int i = 0; i < size; i++) {
                int p = progQ.poll();
                int s = speedQ.poll();
                progQ.add(p + s);
                speedQ.add(s);
             }


            // 배포 가능한 기능 count
            int cnt = 0;
            while (!progQ.isEmpty() && progQ.peek() >= 100) {
                progQ.poll();
                speedQ.poll();
                cnt++;
            }

            if (cnt > 0) {
                result.add(cnt);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
