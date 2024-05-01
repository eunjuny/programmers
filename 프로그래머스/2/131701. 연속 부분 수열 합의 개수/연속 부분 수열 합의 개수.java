import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        int[] newElements = new int[elements.length * 2];
        
        for (int i = 0; i < newElements.length; i++) {
            if (i < elements.length) {
                newElements[i] = elements[i];
            } else {
                newElements[i] = elements[i - elements.length];
            }
        }
        
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                set.add(Arrays.stream(newElements, j, j+i).sum());
                
            }
        }
     
        return set.size();
    }
}