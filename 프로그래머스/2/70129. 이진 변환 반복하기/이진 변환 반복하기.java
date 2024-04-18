public class Solution {
    public int[] solution(String string) {
        int[] answer = {};
        int countZero = 0;
        String binary = "";
        int count = 0;

        while (!string.equals("1")) {
            String text = string.replace("0", "");

            countZero += string.length() - text.length();

            int textLength = text.length();

            binary = Integer.toBinaryString(textLength);

            string = binary;

            count += 1;
        }
        answer = new int[]{count, countZero};

        return answer;
    }
}