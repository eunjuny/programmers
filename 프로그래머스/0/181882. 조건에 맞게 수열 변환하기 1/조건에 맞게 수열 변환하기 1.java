import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
       return Arrays.stream(arr).map(e -> {
            if(e % 2 == 0 && e >= 50){
               return e / 2;
            }else if(e % 2 != 0 && e < 50){
                return e * 2;
            }
           return e;
        }).toArray();
        
    }
}