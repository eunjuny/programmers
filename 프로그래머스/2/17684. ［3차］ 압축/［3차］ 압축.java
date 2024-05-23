import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String msg) {
       
        List<Integer> arr = new ArrayList<>();
       
        HashMap<String, Integer> dict = new HashMap<>();
       
        int dictSize = 26;
        
        for (int i = 0; i < dictSize; i++) {   // 초기 알파벳 정의
            dict.put(String.valueOf((char)('A'+i)), i+1);
        }
        
        String str = "";
        
        for (char c : msg.toCharArray()) {
            String str2 = str + c;
            
            if (dict.containsKey(str2)) {
                str = str2;
            } else {
                arr.add(dict.get(str));
                dict.put(str2, ++dictSize);
                str = String.valueOf(c);
            }
        }
        
        if (!str.isEmpty()) {
            arr.add(dict.get(str)); // 마지막 글자
        }
        
        return arr.stream().mapToInt(i -> i).toArray();
    }
}