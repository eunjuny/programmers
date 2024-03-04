import java.util.HashMap;

class Solution {
    public int solution(String[] friends, String[] gifts) {
  		
        HashMap<String, HashMap<String, Integer>> map = new HashMap<String, HashMap<String, Integer>>();
        for(String from:friends){
			HashMap<String, Integer> friend = new HashMap<String, Integer>();
        	for(String to:friends){
                friend.put(to, 0);
            }   
     		friend.put("tot", 0);
            map.put(from, friend);
        }
        
        for(String gift:gifts){
            String from = gift.split(" ")[0];
            String to = gift.split(" ")[1];
            
            map.get(from).put(to, map.get(from).get(to) + 1);
            map.get(from).put("tot", map.get(from).get("tot") + 1);
            
            map.get(to).put(from, map.get(to).get(from) -1);
            map.get(to).put("tot", map.get(to).get("tot") -1);
        }
        
        
        int answer = 0;
        String answerNm = "";
        for(String from:friends){
            int gift = 0;
            for(String to:friends){
                if(!from.equals(to)){
                    int send = map.get(from).get(to);
                    int recv = map.get(to).get(from);
                    
                    if(send > recv){
                        gift++;
                    }else if(send == recv && map.get(from).get("tot") > map.get(to).get("tot")){
                        gift++;
                    }else{
                        
                    }
                }
            }
            if(answer < gift){
                answer = gift;
                answerNm = from;
            }
        }
        return answer;
    }
}