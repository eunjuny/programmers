// class Solution {
//     public String solution(String X, String Y) {
//         StringBuilder answer = new StringBuilder();
//         char[] sx = X.toCharArray();
//         char[] sy = Y.toCharArray();
            
//         for (int i = 0; i < sx.length; i++) {
//             for (int j = 0; j < sy.length; j++) {
//                 if (sx[i] == sy[j]) {
//                     answer.append(sx[i]);
//                     // 중복 매치를 피하기 위해 Y에서 일치한 문자를 제거합니다.
//                     sy[j] = 'a'; // 여러분이 사용하는 문자열에 없는 문자로 대체할 수 있습니다.
//                     break;
//                 }
//             }
//         }
//         return answer.toString();
//     }
// }
import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public static String solution(String X, String Y) {
        HashMap<Integer, Integer> xmap = new HashMap<>();
        HashMap<Integer, Integer> ymap = new HashMap<>();
        
        for(String data : X.split("")){
            int cur = Integer.parseInt(data);
            xmap.put(cur, xmap.getOrDefault(cur, 0) + 1);
        }

        for(String data : Y.split("")){
            int cur = Integer.parseInt(data);
            ymap.put(cur, ymap.getOrDefault(cur, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 9; i >= 0 ; i --){
            if(xmap.containsKey(i) && ymap.containsKey(i)){
                int cnt = Math.min(xmap.get(i), ymap.get(i));
                for (int j = 0; j < cnt; j++) {
                    sb.append(i);
                }
            }
        }

        if(sb.toString().startsWith("0")){
            return "0";
        }
        else if(sb.toString().equals("")){
            return "-1";
        }

        return sb.toString();
    }
}