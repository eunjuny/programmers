import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        String answer = "";
        
        for(int i=0; i<a.length(); i++){
            int askii = (int)a.charAt(i);
            if(65 <= askii && askii <= 90){
               answer += (char)(askii+32);
            } else if(97 <= askii && askii <= 122){
                answer += (char)(askii-32);
            }
        }
        System.out.print(answer);
    }
}