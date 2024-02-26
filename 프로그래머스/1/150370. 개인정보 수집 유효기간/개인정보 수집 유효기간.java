import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();    // new ArrayList<>()는 동적으로 크기가 조절됨.
        
        LocalDate parsedDate = toDate(today);
        HashMap<String, Integer> map = new HashMap<>();
        for (String t : terms) {
            map.put(t.split(" ")[0], Integer.parseInt(t.split(" ")[1]));
        }
        
        for (int i = 0; i < privacies.length; i++) {
            LocalDate priDate = toDate(privacies[i].split(" ")[0]);
            String priType = privacies[i].split(" ")[1];
            // a.compareTo(b)는 a가 더 크면 1, 같으면 0, 작은면 -1을 출력, 같은날이어도 파기해야 하므로 >=
            if (parsedDate.compareTo(priDate.plusMonths(map.get(priType))) >= 0) {    
                answer.add(i+1);
            }
        }
        
        
        return answer;
    }
    
    private LocalDate toDate(String input) {
        // String 문자열을 LocalDate타입으로
        LocalDate date = LocalDate.parse(input, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        return date;
    }
}
