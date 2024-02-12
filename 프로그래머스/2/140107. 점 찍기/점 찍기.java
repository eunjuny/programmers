import java.util.*;
import java.lang.*;

class Solution {
    public long solution(int k, int d) {
        
        long count = 0;
        for (int x = 0; x <= d; x+=k) {
        count += ((long)Math.sqrt((long)Math.pow(d,2) - (long)Math.pow(x,2))) / k + 1;
        }
    

        return count;
    }
}