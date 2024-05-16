import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        // 문자열을 소문자로 변환합니다.
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // 두 글자씩 끊어서 문자열을 저장할 맵을 만듭니다.
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        // str1에서 두 글자씩 끊어서 맵에 저장합니다.
        for (int i = 0; i < str1.length() - 1; i++) {
            String part = str1.substring(i, i + 2);
            if (part.chars().allMatch(Character::isLetter)) {
                map1.put(part, map1.getOrDefault(part, 0) + 1);
            }
        }

        // str2에서 두 글자씩 끊어서 맵에 저장합니다.
        for (int i = 0; i < str2.length() - 1; i++) {
            String part = str2.substring(i, i + 2);
            if (part.chars().allMatch(Character::isLetter)) {
                map2.put(part, map2.getOrDefault(part, 0) + 1);
            }
        }

        // 교집합 크기를 계산합니다.
        int intersection = 0;
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                intersection += Math.min(map1.get(key), map2.get(key));
            }
        }

        // 합집합 크기를 계산합니다.
        int union = 0;
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                union += Math.max(map1.get(key), map2.get(key));
            } else {
                union += map1.get(key);
            }
        }
        for (String key : map2.keySet()) {
            if (!map1.containsKey(key)) {
                union += map2.get(key);
            }
        }

        // 자카드 유사도를 계산합니다.
        double jaccard = union == 0 ? 1 : (double) intersection / union;

        // 결과를 65536으로 곱하고 정수로 변환하여 반환합니다.
        return (int) (jaccard * 65536);
    }
}
