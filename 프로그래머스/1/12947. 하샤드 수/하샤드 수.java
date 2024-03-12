class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        int sum = 0;
        for (int i = 0; i < sb.length(); i++) {
            sum += Character.getNumericValue(sb.charAt(i));
        }
        
        if (x % sum != 0) {
            answer = false;
        }
        return answer;
    }
}