import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String s) {
    
        ArrayList<Integer> answer = new ArrayList<>();
        String[] str = s.substring(0,s.length()-2).replace("{","").split("},");
      
        Arrays.sort(str, new Comparator<String>(){
            public int compare(String o1, String o2){
                return Integer.compare(o1.length(), o2.length());
            }
        });
        
        for (String st : str) {
            String[] temp = st.split(",");
            for (int i = 0; i < temp.length; i++) {
                int n = Integer.parseInt(temp[i]);
                if(!answer.contains(n))
                    answer.add(n);
            }
        }
        
        return answer; 
    }
}