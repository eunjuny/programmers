class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String cur : skill_trees) {	// skill_trees의 문자열 하나씩 보면서
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cur.length(); i++) {	
                if (skill.contains(cur.charAt(i) + ""))// 문자 순서대로 skill에 포함되는것만
                    sb.append(cur.charAt(i));	// 따로 빼둠.
            }
            answer += skill.indexOf(sb.toString())==0 ? 1 : 0;
        }
        return answer;
    }
}