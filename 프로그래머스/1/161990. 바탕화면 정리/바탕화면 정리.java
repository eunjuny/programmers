class Solution {
    public int[] solution(String[] wallpaper) {
        int lux = Integer.MAX_VALUE;
        int luy = Integer.MAX_VALUE;
        int rdx = 0;
        int rdy = 0;
        
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    lux = Math.min(j, lux);
                    luy = Math.min(i, luy);
                    rdx = Math.max(j+1, rdx);
                    rdy = Math.max(i+1, rdy);
                }
            }
        }
        
        int[] answer = {luy, lux, rdy, rdx};
        return answer;
    }
}

