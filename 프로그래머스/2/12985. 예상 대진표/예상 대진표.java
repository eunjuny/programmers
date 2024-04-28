class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        while(a!=b) {
            a = nextStage(a);
            b = nextStage(b);
            answer++;
        }
        
        return answer;
    }
    
    private int nextStage(int num) {
        if (num % 2 == 0) {
                return (num/2);
            } else {
                return (num+1)/2;
            }
    }
}