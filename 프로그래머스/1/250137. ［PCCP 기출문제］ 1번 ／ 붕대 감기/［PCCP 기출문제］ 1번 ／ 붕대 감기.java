class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int hp = health; 
        int idx = 0;
        int bandIdx = 1;
        
        for (int i = 1; i <= attacks[attacks.length - 1][0]; i++) {
            
            if (idx < attacks.length && attacks[idx][0] == i) {
                hp -= attacks[idx][1];
                idx++;
                bandIdx = 1;
                
                if (hp <= 0) {
                    return -1;
                } 
                
            } else {
                hp = hp + bandage[1] >= health ? health : hp + bandage[1]; 

                if (bandage[0] == bandIdx) {
                    hp = hp + bandage[2] >= health ? health : hp + bandage[2];
                    bandIdx = 1;
                } else {
                    bandIdx++;
                }
            
            }
            
            answer = hp;
        }
        
        return answer;
    }
}