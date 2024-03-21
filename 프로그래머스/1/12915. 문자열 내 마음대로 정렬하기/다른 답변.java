import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>(){  // strings 배열을 Comparator에서 정의된 규칙으로 정렬
            @Override
            public int compare(String s1, String s2) {  // Comparator의 규칙
                char char1 = s1.charAt(n);
                char char2 = s2.charAt(n);
                
                // n번째 문자가 다르면 해당 문자를 기준으로 정렬
                if (char1 != char2) {
                    return Character.compare(char1, char2);
                }
                // n번째 문자가 같으면 문자열 전체를 비교하여 정렬
                else {
                    return s1.compareTo(s2);
                }
            }
        });
        return strings;
    }
}


/*
compare() 메서드는 다음과 같은 형식으로 정의됩니다:

int compare(T o1, T o2);

여기서 T는 비교하려는 객체의 형식을 나타냅니다. compare() 메서드는 두 개의 객체 o1과 o2를 받아서 비교하고, 비교 결과에 따라 정수를 반환합니다. 반환 값은 다음과 같은 의미를 가집니다:

0보다 작은 값: o1이 o2보다 작음을 나타냄
0: o1과 o2가 같음을 나타냄
0보다 큰 값: o1이 o2보다 큼을 나타냄

*/
