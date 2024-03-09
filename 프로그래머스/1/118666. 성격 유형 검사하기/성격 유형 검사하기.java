import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "RCJA"; // 초기값을 사전순으로 지정
        HashMap<String, Integer> map = new HashMap<>();
        map.put("R", 0);
        map.put("T", 0);
        map.put("C", 0);
        map.put("F", 0);
        map.put("J", 0);
        map.put("M", 0);
        map.put("A", 0);
        map.put("N", 0);
            for (int i = 0; i < survey.length; i++) {
                if (choices[i] > 4) {
                    String b = survey[i].split("")[1];
                    int bScore = map.get(b) + (choices[i] - 4);
                    map.put(b, bScore);
                } else {
                    String f = survey[i].split("")[0];
                    int fScore = map.get(f) + (4 - choices[i]);
                    map.put(f, fScore);
                }
            }
        if (map.get("T") > map.get("R")) {
            answer = answer.replace("R","T");   // 수정 후 반환을 해줘야 함
        }
        if (map.get("F") > map.get("C")) {
            answer = answer.replace("C","F");
        }
        if (map.get("M") > map.get("J")) {
            answer = answer.replace("J","M");
        }
        if (map.get("N") > map.get("A")) {
            answer = answer.replace("A","N");
        }
        return answer;
    }
}