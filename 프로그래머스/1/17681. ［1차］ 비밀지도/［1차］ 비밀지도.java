class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        char[][] arr1_2 = new char[n][n];
        char[][] arr2_2 = new char[n][n];
        for (int i = 0; i < n; i++) { 
            arr1_2[i] = String.format("%" + n + "s", Integer.toBinaryString(arr1[i])).replace(' ', '0').toCharArray();
            arr2_2[i] = String.format("%" + n + "s", Integer.toBinaryString(arr2[i])).replace(' ', '0').toCharArray();
            // Integer.toBinaryString()은 2진수로 변환해주는 함수
            // String.foramt("%" + n + "s", Integer.toBinaryString(arr1[i])).replace(' ', '0').toCharArray()  
            // 길이를 n으로 고정하고 모자른 길이는 0으로 채운다.
            System.out.println(arr1_2[i]);
            System.out.println(arr2_2[i]);
            System.out.println("------");
        }
        
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
             for (int j = 0; j < n; j++) {
                 if (arr1_2[i][j] == '1' || arr2_2[i][j] == '1') {
                     sb.append("#");
                 } else {
                     sb.append(" ");
                 }
             }
            answer[i] = sb.toString();
            System.out.println(sb.toString());
        }
        
        return answer;
    }
}