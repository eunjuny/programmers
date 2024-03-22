class Solution {
  public String[] solution(int n, int[] arr1, int[] arr2) {
      String[] answer = new String[n];
      String temp;

      for(int i = 0 ; i < n ; i++){
          temp = String.format("%16s", Integer.toBinaryString(arr1[i] | arr2[i]));
          // 문제에서 n의 최대값이 16으로 주어졌기 때문에 애초에 16자리로 만들고 자르기 
          temp = temp.substring(temp.length() - n);
          // temp.length() - n 이후의 문자열만 남김
          temp = temp.replaceAll("1", "#");
          temp = temp.replaceAll("0", " ");
          answer[i] = temp;
      }

      return answer;
  }
}
