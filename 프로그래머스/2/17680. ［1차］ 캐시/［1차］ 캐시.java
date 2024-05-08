import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
//         Queue<String> que = new LinkedList<>();
        
//         int idx = 0;
//         for(int i = 0; que.size() <= cacheSize; i++) {
//             if(!que.contains(cities[i])) {
//                 que.offer(cities[i]);
//                 answer += 5;
//                 idx++;
//             } else {
//                 answer += 1;
//                 idx++;
//             }
//         }
        
//         for(idx; idx < cities.length; idx++) {
//             if(!que.contains(cities[idx])) {
//                 answer += 5;
//                 que.poll();
//                 que.offer(cities[idx]);
//             } else {
//                 answer += 1;
//                 // ...이런식으로 작업중에 있었으나... 좋지 않은 방법으로 생각되어 방법 변경.
//                 // que.contains()는 선형 검색을 수행하기 때문에 시간복잡도가 높으므로 비추 O(n)
//             }
//         }
        
        // 캐시 크기가 0 이하인 경우 모든 요청에 대해 cache miss로 처리
        if (cacheSize <= 0) {
            return cities.length * 5;
        }
        
        // LRU 캐시를 위한 자료구조 선언
        Queue<String> cache = new LinkedList<>();
        Map<String, Integer> cacheMap = new HashMap<>();
        
        for (String city : cities) {
            String cityName = city.toLowerCase();
            
            // 캐시에 해당 도시가 존재하는지 확인
            if (cacheMap.containsKey(cityName)) {
                // 캐시에 존재하면 해당 도시를 캐시의 맨 뒤로 이동
                cache.remove(cityName);
                cache.offer(cityName);
                answer += 1;
            } else {
                // 캐시에 존재하지 않으면 새로운 도시를 캐시에 추가
                if (cache.size() >= cacheSize) {
                    // 캐시가 가득 차 있으면 LRU 정책에 따라 가장 오래된 요소를 제거
                    String removedCity = cache.poll();
                    cacheMap.remove(removedCity);
                }
                cache.offer(cityName);
                cacheMap.put(cityName, 1);
                answer += 5;
            }
        }
        
        return answer;
    }
}