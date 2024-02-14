class Solution {
    public int solution(String ineq, String eq, int n, int m) {
       
        boolean a = false;
        if("=".equals(eq)){
           a = ">".equals(ineq) ? n >= m : n <= m;  
        } else{
        	a = ">".equals(ineq) ? n > m : n < m;
    	}
          return a ? 1 : 0;
    }
}