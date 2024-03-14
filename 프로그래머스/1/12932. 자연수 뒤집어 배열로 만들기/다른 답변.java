class Solution {
  public int[] solution(long n) {
      String a = "" + n;  // "" + 숫자를 할 경우 StringBuffer가 생성돼서 문자열로 인식된다. new StringBuffer 후 append()와 같은 느낌
        int[] answer = new int[a.length()];
        int cnt=0;

        while(n>0) {
            answer[cnt]=(int)(n%10);
            n/=10;
            System.out.println(n);
            cnt++;
        }
      return answer;
  }
}
