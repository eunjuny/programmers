class Solution {
    public int[] solution(int[] arr, int n) {
        int[] answer = arr;

        if(isEven(arr.length)){
            for(int i = 1; i < arr.length; i+=2){
                answer[i] = arr[i] + n;
            }
        } else { 
        for(int i = 0; i < arr.length; i+=2){
                answer[i] = arr[i] + n;
            }
        }
            
        return answer;
    }
    
    public boolean isEven(int num) {
       return num % 2 == 0; 
    }
}