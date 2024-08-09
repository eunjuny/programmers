class Solution
{
    public static int[][] dp;
    public int solution(int [][]board)
    {
        this.dp = new int[board.length + 1][board[0].length  + 1];
        
        int maxWidth = 0;
        
        for(int row = 1;row<board.length + 1;row++){
            for(int col=1;col<board[0].length + 1; col++){
                
                int min = 1000;
                
                // 1이 아니면 continue;
                if (board[row - 1][col - 1] != 1)
                    continue;
                
                // 현재 row, col 에서 세가지중 작으면 대입
                //왼쪽
                min = dp[row][col-1] < min ? dp[row][col-1] : min;
                
                // 위쪽
                min = dp[row - 1][col] < min ? dp[row - 1][col] : min;
                
                // 왼쪽위
                min = dp[row - 1][col - 1] < min ? dp[row - 1][col - 1] : min;
                
                // 현재 dp[row][col]을 넣는다.
                dp[row][col] = min + 1;
                
                // min + 1가 maxWidth보다 크면 바꿔준다
                maxWidth = maxWidth < min + 1 ? min + 1 : maxWidth;
            }
        }
        return maxWidth * maxWidth;
    }
}