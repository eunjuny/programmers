class Solution {
    public String solution(int a, int b) {
        
        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] month = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int result = 0;
        int plusDay = 4;    // 1월 1일이 금요일
        
        for (int i = 0; i < a; i++) {
            plusDay += month[i]; 
        }
        
        plusDay += b;
        System.out.println(plusDay);
        
        return days[plusDay % 7];
//         String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
//         int[] months = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30};
//         int total = 0; // 총 일수
        
//         for(int i=0; i<a; i++) {
//             total += months[i];
//         }
//         total += b;

//         return days[(total + 4) % 7];
    }
}