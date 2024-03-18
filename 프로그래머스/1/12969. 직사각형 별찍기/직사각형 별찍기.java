import java.util.Scanner;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        // char[][] stList = new char[a][b];
        // for (int i = 0; i < a; i++) {
        //     Arrays.fill(stList[i], '*');
        // }
        //          
        // System.out.println(stList); 
        // 이차원 배열은 System.out.println() 메서드로 직접 출력 불가능
        // 배열의 참조를 출력하기 때문에 이차원 배열의 내용을 출력하려면 반복문을 사용해야 한다.
        
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print('*');
            }
            System.out.println("");
        }
        
    }
}