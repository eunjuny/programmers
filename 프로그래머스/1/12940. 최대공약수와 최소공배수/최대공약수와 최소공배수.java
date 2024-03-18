class Solution {
    public int[] solution(int n, int m) {
        int a = Math.max(n, m);
        int b = Math.min(n, m);
        // 유클리드 호제법을 사용
        // 큰 수를 작은 수로 나누고 나온 나머지로 작은 수를 나눈다.. 이걸 계속 반복해서 나머지가 0이 나올 때 나눈 값이 최대 공약수
        int r = a % b;
        int ys = r == 0 ? b : 0;    // 작은 수 = 최대 공약수일 경우 작은 수 리턴
        while(r > 0) {
            int c = b % r;
            ys = r;
            b = r;
            r = c;
        }
        int bs = n * m / ys;    // 최소 공배수는 두 수를 곱하고 최대 공약수로 나눈다.
        int[] answer = new int[]{ys, bs};
        return answer;
    }
}