import java.util.*;

class Solution {
    Set<Set<String>> result = new HashSet<>();  // 최종 정답 목록
    List<List<String>> matches = new ArrayList<>(); // 각 banned_id 마다 ban이 가능한 id들 목록(중복 포함 상태)
    
    public int solution(String[] user_id, String[] banned_id) {
        
        // banned_id 각각에 매칭되는 user 리스트 수집
        for(String ban : banned_id) {
            List<String> list = new ArrayList<>();  // 특정 ban에 해당 되는 user 목록
            for(String user : user_id) {
                if(check(user, ban)) {
                    list.add(user);
                }
            }
            matches.add(list); // 특정 ban에 해당 되는 user 목록들을 모은 목록
        }
        
        dfs(0, new HashSet<>());
        
        return result.size();
    }
    
    private void dfs(int start, Set<String> used) {  // used는 이미 제재된 유저 (중복 방지)
        if(start == matches.size()) {
            result.add(new HashSet<>(used));    // 각 경우의 수에 대해 완성된 used 조합이 result에 추가
            return; 
            /*
                return은 **현재 함수 호출(현재 depth의 DFS 분기)**만 끝낼 뿐,
                전체 DFS는 위 부모 호출로 돌아가서 계속 다른 분기를 탐색함.
            */
        } 
        
        for(String user : matches.get(start)){  
            // 특정 ban에 해당되는 한 유저를 선택하고, 다음 ban에 해당되는 유저를 스캔(이전 유저는 제외)
            // 특정 단계의 특정 유저에 대해 dfs를 실시하고 완료된 후에는 해당 유저는 used 목록에서 제거하고 상위 단계로 올라감.
            if(!used.contains(user)) {
                used.add(user);
                dfs(start+1, used);
                used.remove(user);
            }
            /*
                재귀 단계마다 used 내용이 달라짐
                used = {A}
                used = {A, B}
                used = {A, B, C}   → 조합 완성
                used = {A, B}      → 백트래킹
                used = {A}
                used = {A, D}
                ...
            */
            
        }
    }
    
    private boolean check(String user, String ban) {
        if(user.length() != ban.length()) return false;
        for(int i = 0; i < user.length(); i++) {
            if ('*' != ban.charAt(i) && user.charAt(i) != ban.charAt(i)) {
                return false;
            } 
        }
        return true;
    }
}
