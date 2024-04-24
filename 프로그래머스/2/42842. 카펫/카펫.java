class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int size = brown + yellow;
        
        for (int y=3; y*y <= size; y++) {
            if (size % y == 0 && (size / y) >= y) {
                answer[0] = size/y;
                answer[1] = y;
                
                int yellowTiles = (answer[0] - 2) * (answer[1] - 2);
                if (yellowTiles == yellow) {
                    break;
                }
            } 
        }
        
        return answer;
    }
}