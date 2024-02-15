import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        Map<String, Integer> yearMap = new HashMap<>();
        
        for(int i=0; i<name.length; i++){
            yearMap.put(name[i], yearning[i]);
        }
        
        for(int i=0; i<photo.length; i++){
			int sum = 0;
			for(int j=0; j<photo[i].length; j++){
                if(yearMap.containsKey(photo[i][j])){
                	sum += yearMap.get(photo[i][j]);
                }
            }
            answer[i] = sum;
        }
        return answer;
    }
}