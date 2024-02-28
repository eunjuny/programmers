class Solution {

    public int solution(int number, int limit, int power) {
        int[] count = new int[number + 1];    
        
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number / i; j++) {
                count[i * j]++;
            }
        }
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            if (count[i] > limit) {
                answer += power;
            } else {
                answer += count[i];
            }
        }
        return answer;
    }
}

/*
 
  for (int i = 1; i <= number; i++) {
      for (int j = 1; j <= number / i; j++) {
          count[i * j]++;
      }
  }

i = 1 일 때:
    j = 1: count[1 * 1]++;  // count[1] 증가
    j = 2: count[1 * 2]++;  // count[2] 증가
    j = 3: count[1 * 3]++;  // count[3] 증가
    j = 4: count[1 * 4]++;  // count[4] 증가
    j = 5: count[1 * 5]++;  // count[5] 증가
    j = 6: count[1 * 6]++;  // count[6] 증가
    j = 7: count[1 * 7]++;  // count[7] 증가
    j = 8: count[1 * 8]++;  // count[8] 증가
    j = 9: count[1 * 9]++;  // count[9] 증가
    j = 10: count[1 * 10]++;  // count[10] 증가

i = 2 일 때:
    j = 1: count[2 * 1]++;  // count[2] 증가
    j = 2: count[2 * 2]++;  // count[4] 증가
    j = 3: count[2 * 3]++;  // count[6] 증가
    j = 4: count[2 * 4]++;  // count[8] 증가
    j = 5: count[2 * 5]++;  // count[10] 증가

i = 3 일 때:
    j = 1: count[3 * 1]++;  // count[3] 증가
    j = 2: count[3 * 2]++;  // count[6] 증가
    j = 3: count[3 * 3]++;  // count[9] 증가

i = 4 일 때:
    j = 1: count[4 * 1]++;  // count[4] 증가
    j = 2: count[4 * 2]++;  // count[8] 증가

i = 5 일 때:
    j = 1: count[5 * 1]++;  // count[5] 증가
    j = 2: count[5 * 2]++;  // count[10] 증가

i = 6 일 때:
    j = 1: count[6 * 1]++;  // count[6] 증가

i = 7 일 때:
    j = 1: count[7 * 1]++;  // count[7] 증가

i = 8 일 때:
    j = 1: count[8 * 1]++;  // count[8] 증가

i = 9 일 때:
    j = 1: count[9 * 1]++;  // count[9] 증가

i = 10 일 때:
    j = 1: count[10 * 1]++;  // count[10] 증가

*/
