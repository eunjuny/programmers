import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        Map<String, Integer> genreTotal = new HashMap<>();
        Map<String, List<int[]>> genreSong = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            genreTotal.put(genres[i], genreTotal.getOrDefault(genres[i], 0) + plays[i]);
            
            genreSong.putIfAbsent(genres[i], new ArrayList<>());
            genreSong.get(genres[i]).add(new int[]{i, plays[i]}); 
            // 리스트 객체의 참조(주소)를 반환하고 해당 객체에 데이터를 추가 하기 때문에 
            // Map에 다시 put하지 않아도 Map 내부의 리스트에 반영이 된다.
        }
        
        List<String> genreOrder = new ArrayList<>(genreTotal.keySet());
        genreOrder.sort((a, b) -> genreTotal.get(b) - genreTotal.get(a));   // 내림차순
        
        List<Integer> result = new ArrayList<>();
        
        for(String genre : genreOrder) {
            List<int[]> songs = genreSong.get(genre);
            songs.sort((a, b) -> {
                if(a[1] == b[1]) return a[0] - b[0];
                return b[1] - a[1];
            });
            
            result.add(songs.get(0)[0]);
            if(songs.size() > 1) {
                result.add(songs.get(1)[0]);
            }
            
        }
        
        // List<Integer> -> int[] 
        return result.stream().mapToInt(i -> i).toArray();
    }
}