class Solution {
    private static String answer; 
    
    public String solution(String new_id) {
        
        filter1(new_id);
        return answer;
    }
    
    private void filter1(String input) {
        
        for (int i = 0; i < input.length(); i++) {
            int ascii = (int)input.charAt(i);
            if (ascii >= 65 && ascii <= 90) {
                input = input.replace((char)ascii, (char)(ascii + 32));
            }
        }
        String output = input;
        filter2(output);
    }
    
     private void filter2(String input) {
         
         String output = "";
         for (int i = 0; i < input.length(); i++) {
            int ascii = (int)input.charAt(i);
            if ((ascii >= 97 && ascii <= 122) || (ascii >= 48 && ascii <= 57) || (char)ascii == '-' || 
               (char)ascii == '_' || (char)ascii == '.') {
                output += Character.toString((char)ascii);
            }
        }
        filter3(output);
    }
    
     private void filter3(String input) {
        
        while(input.contains("..")) {
            input = input.replace("..", ".");
        }
        String output = input;
        filter4(output);
    }
    
     private void filter4(String input) {
        
        String output = input.charAt(0) == '.' ? input.substring(1, input.length()) : input;
        filter5(output);
    }
    
     private void filter5(String input) {
        
        String output = input.length() == 0 ? "a" : input;
        filter6(output);
    }
    
     private void filter6(String input) {
        
        String output = input.length() > 15 ? input.substring(0, 15) : input;
        output = output.charAt(output.length() -1) == '.' ? output.substring(0, output.length() - 1) : output;
        filter7(output);
    }
    
     private void filter7(String input) {
        
        while(input.length() <= 2) {
            input += input.charAt(input.length() - 1);
        }
        
        System.out.println(input);
        answer = input;
        
    }
}