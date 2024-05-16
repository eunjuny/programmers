// import java.util.Arrays;

// class Solution {
//     public boolean solution(String[] phone_book) {
//         boolean answer = true;
        
//         Arrays.sort(phone_book, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
//         int len = phone_book[phone_book.length - 1].length();
        
//         for (int j = 0; j < phone_book.length; j++) {
//             for (int i = j + 1; i < phone_book.length; i++) {
//                 if (phone_book[i].length() > phone_book[j].length() && phone_book[i].startsWith(phone_book[j])) {
//                     return false;
//                 } else if (phone_book[j].length() >= len) {
//                     return true;
//                 }
//             }
//         }
        
//         return answer;
//     }
// }

import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book); // 문자열을 사전순으로 정렬
        
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false; // 현재 문자열이 다음 문자열의 접두사인 경우
            }
        }
        
        return true; // 모든 문자열이 서로의 접두사가 아닌 경우
    }
}
