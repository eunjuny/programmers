import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> usrId = new HashMap<>();    // id, 닉네임
        int count = 0;
        
        for(int i=0; i<record.length; i++){
            String[] usrInfo = record[i].split(" ");
            
            if(usrInfo[0].equals("Leave")){
                continue;
            } else if(usrInfo[0].equals("Enter")){      
                usrId.put(usrInfo[1], usrInfo[2]);
            } else {                                    // change
                usrId.put(usrInfo[1], usrInfo[2]);
                count++;
            }
        }
        
        String[] answer = new String[record.length - count];
        int idx = 0;
        
        for(int i=0; i < record.length; i++){
            String[] usrInfo = record[i].split(" ");
            String nickName = usrId.get(usrInfo[1]);
            
            if(usrInfo[0].equals("Enter")){
                answer[idx++] = nickName + "님이 들어왔습니다.";
            }else if(usrInfo[0].equals("Leave")){
                answer[idx++] = nickName + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}