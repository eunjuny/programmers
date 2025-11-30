import java.util.*;

class Solution {
    Set<Integer> answers = new HashSet<>();
    List<List<Integer>> matches = new ArrayList<>();
    String[] users;
    String[] banned;

    public int solution(String[] user_id, String[] banned_id) {
        this.users = user_id;
        this.banned = banned_id;

        // banned_id 각각에 대해 매칭 가능한 user 인덱스 수집
        for (String b : banned_id) {
            List<Integer> cand = new ArrayList<>();
            for (int i = 0; i < user_id.length; i++) {
                if (isMatch(user_id[i], b)) cand.add(i);
            }
            matches.add(cand);
        }

        dfs(0, 0);
        return answers.size();
    }

    // user_id 배열의 크기가 1이상 8이하 이기 때문에 mask 사용 용이
    private void dfs(int idx, int mask) {
        if (idx == matches.size()) {
            answers.add(mask);
            return;
        }

        for (int userIndex : matches.get(idx)) {
            // 이미 선택된 유저면 건너뜀, 1 << userIndex는 1을 2진수 비트에서 userIndex만큼 이동시킨다.
            /*
                mask = 10110
                (1 << 2) = 00100
                ----------------
                mask & 00100 = 00100 ≠ 0   → 이미 선택됨
            */
            if ((mask & (1 << userIndex)) != 0) continue;  
            /*
                |는 or 연산
                mask = 00101    (0번, 2번 user 선택됨)
                1 << 1 = 00010  (1번 user를 선택)
                ----------------
                mask | 00010 = 00111
                → 0,1,2번 user가 선택됨
            */
        
            dfs(idx + 1, mask | (1 << userIndex));
        }
    }

    private boolean isMatch(String user, String ban) {
        if (user.length() != ban.length()) return false;
        for (int i = 0; i < user.length(); i++) {
            char bc = ban.charAt(i);
            if (bc != '*' && user.charAt(i) != bc) return false;
        }
        return true;
    }
}
