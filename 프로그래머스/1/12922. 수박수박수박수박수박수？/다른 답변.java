public class WaterMelon {
    public String watermelon(int n){

        return new String(new char [n/2+1]).replace("\0", "수박").substring(0,n);  
        // n/2 +1 길이의 모든 빈 배열을 "수박"으로 변경한 후 substring
    }

    // 실행을 위한 테스트코드입니다.
    public static void  main(String[] args){
        WaterMelon wm = new WaterMelon();
        System.out.println("n이 3인 경우: " + wm.watermelon(3));
        System.out.println("n이 4인 경우: " + wm.watermelon(4));
    }
}
