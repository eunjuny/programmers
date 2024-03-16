class Solution {
    boolean solution(String s) {

        int leng = s.length();
        s = s.toLowerCase();

        s = s.replaceAll("y", "");
        int yNum = leng - s.length();
        System.out.println(yNum);
        s = s.replaceAll("p", "");
        int pNum = leng - s.length() - yNum;
        System.out.println(pNum);
        
        return yNum == pNum;
    }
}