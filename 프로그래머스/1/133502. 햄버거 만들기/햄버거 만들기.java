import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        List<Integer> arr = new ArrayList<>();
        
        /*
        Java에서는 원시 타입(primitive type)과 객체 타입(object type) 간의 호환성 문제가 발생할 수 있습니다. Arrays.asList()는 객체 배열을 받아들이므로 int[] 대신 Integer[] 배열을 전달해야 합니다.
        */
        
        for (int i : ingredient) {
            arr.add(i);
        }
        
        for (int i = 0; i < arr.size()-3; i++) {
            if (arr.get(i) == 1) {
                if (arr.get(i+1) == 2 && arr.get(i+2) ==3 && arr.get(i+3) == 1) {
                    answer++;
                    arr.subList(i, i+4).clear();    // subList()로 i부터 i+4 이전 까지 배열 반환 -> 이 때 반환된 배열을 수정하면 원본 배열에도 반영이 된다.
                     i = Math.max(-1, i-4); // i를 재설정하여 중복 검사 방지 
                }
            }
        }
        return answer;
    }
}