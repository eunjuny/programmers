import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // 변환 불가능 할 경우 return 0
        boolean exists = false;
        for (String w : words) {
            if(w.equals(target)){
                exists = true;
                break;
            }
        }
        if (!exists) return 0;
        
        Queue<String> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        queue.add(begin);
        int depth = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            depth++;    // 글자 변경 횟수
            
            for(int s = 0; s < size; s++) {
                String now = queue.poll();
                for(int i = 0; i < words.length; i++){
                    if(!visited[i] && isOneDiff(now, words[i])) {
                        if(words[i].equals(target)) return depth;
                        
                        visited[i] = true;
                        queue.add(words[i]);
                    }
                }
            }
        }
        
        return 0;
    }
    
    private boolean isOneDiff(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) diff++;
            if(diff > 1) return false;
        }
        return diff == 1;
    }
}