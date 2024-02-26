import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        LocalDate parsedDate = toDate(today);
        HashMap<String, Integer> map = new HashMap<>();
        for (String t : terms) {
            map.put(t.split(" ")[0], Integer.parseInt(t.split(" ")[1]));
        }
        
        for (int i = 0; i < privacies.length; i++) {
            LocalDate priDate = toDate(privacies[i].split(" ")[0]);
            String priType = privacies[i].split(" ")[1];
            if (parsedDate.compareTo(priDate.plusMonths(map.get(priType))) >= 0) {
                answer.add(i+1);
            }
        }
        
        
        return answer;
    }
    
    private LocalDate toDate(String input) {
        LocalDate date = LocalDate.parse(input, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        return date;
    }
}