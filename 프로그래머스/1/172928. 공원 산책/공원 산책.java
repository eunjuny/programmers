class Solution {
    public int[] solution(String[] park, String[] routes) {
        
        char[][] arr = new char[park.length][park[0].length()];
       
        int sx = 0;
        int sy = 0;
        
        for(int i=0; i<park.length; i++){
           arr[i] = park[i].toCharArray();
            
            if(park[i].indexOf("S") != -1) {
                sx = park[i].indexOf("S");
                sy = i;
            }
        }

        for(String route : routes) {
            String direction = route.split(" ")[0];
            int distance = Integer.parseInt(route.split(" ")[1]);
            
            int nx = sx;
            int ny = sy;
            
            for(int i=0; i<distance; i++) {
                if("E".equals(direction)){
                    nx++;
                }
                if("W".equals(direction)){
                    nx--;
                }
                if("N".equals(direction)){
                    ny--;
                }
                if("S".equals(direction)){
                    ny++;
                }
            	
                if(nx >= 0 && ny >= 0 && nx < arr[0].length && ny < arr.length) {
                    if(arr[ny][nx] == 'X'){
                        break;
                    }else if(i == distance-1) {
                        sx = nx;
                        sy = ny;
                    }
                    
                }
            }
        }
        int[] answer = {sy, sx};
        return answer;
    }
}