import java.util.*;

class Solution {
    // 메뉴 조합과 그 빈도를 저장할 Map
    Map<String, Integer> map;
    // 조합의 최댓값 빈도
    int max = 0;
    
    // dfs 탐색 메서드
    public void dfs(String order, String key, int index, int end, int depth) {
        // 코스의 길이와 동일할 때까지 탐색했을 경우
        if(depth == end) {
            // map에 key와 value를 넣어줌 (조합을 추가하거나 빈도를 증가시킴)
            map.put(key, map.getOrDefault(key, 0) + 1);
            // max값 갱신
            max = Math.max(max, map.get(key));
            return; // 반환하여 종료 조건 만족 시 더 이상 탐색하지 않도록 함
        }
        
        // dfs 메서드 재귀호출
        for(int i = index + 1; i < order.length(); i++) {
            dfs(order, key + order.charAt(i), i, end, depth + 1);
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        // 최종 답을 저장할 리스트
        ArrayList<String> ans = new ArrayList<>();
        
        // course 배열을 순회하면서 각 코스 길이에 대해 처리
        for(int c : course) {
            // HashMap과 max 값 초기화
            map = new HashMap<>();
            max = 0;
            
            // 각 주문을 순회
            for(String order : orders) {
                // 각 주문마다 알파벳 순서대로 정렬 (순서에 상관없이 조합을 찾기 위해)
                char[] strs = order.toCharArray();
                Arrays.sort(strs);
                order = new String(strs);
                // dfs 탐색 시작
                dfs(order, "", -1, c, 0);
            }
            
            // map에 저장된 key 개수만큼 반복
            for(String key : map.keySet()) {
                // key값으로 value를 불러옴 (조합의 빈도)
                int value = map.get(key);
                // value가 2 이상이면서 max와 동일하다면
                if(value > 1 && max == value) {
                    // 배열에 키값을 저장 (조건을 만족하는 조합을 답안 리스트에 추가)
                    ans.add(key);
                }
            }
        }
        
        // 정렬을 진행 (사전순으로 정렬)
        Collections.sort(ans);
        // String[] 배열로 변환하여 반환
        String[] answer = ans.toArray(new String[ans.size()]);
        
        return answer;
    }
}

/*
dfs 탐색 메서드 (dfs):

order: 현재 주문 문자열.
key: 현재까지의 조합 문자열.
index: 현재 탐색 중인 문자 인덱스.
end: 찾고자 하는 조합의 길이.
depth: 현재 조합의 깊이 (조합의 길이).
조합의 길이가 원하는 길이 (end)에 도달하면 map에 추가하고 max 값을 갱신.
재귀적으로 다음 문자를 추가하여 조합을 생성.
solution 메서드 (solution):

orders: 고객 주문 배열.
course: 찾고자 하는 코스의 길이 배열.
각 코스 길이에 대해 조합을 생성하고 빈도수를 map에 저장.
조합의 빈도가 2 이상이고, 최댓값과 같다면 답안 리스트에 추가.
최종적으로 답안 리스트를 정렬하고 배열로 변환하여 반환.

*/
