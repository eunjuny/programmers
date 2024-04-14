import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] strArr = s.split(" ");
        ArrayList<Integer> arr = new ArrayList<>();
        for (String num : strArr) {
            arr.add(Integer.parseInt(num));
        }
        
        Collections.sort(arr);
        
        answer = arr.get(0) + " " + arr.get(arr.size()-1);
        return answer;
    }
}