import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book); // 문자열을 사전순으로 정렬
        
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {  
                // 사전순 정렬이기 때문에 접두사가 되려면 바로 다음 순서로 나와야한다. 
                return false; // 현재 문자열이 다음 문자열의 접두사인 경우
            }
        }
        
        return true; // 모든 문자열이 서로의 접두사가 아닌 경우
    }
}
