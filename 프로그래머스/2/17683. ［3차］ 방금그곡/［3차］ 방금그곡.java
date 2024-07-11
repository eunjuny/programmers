class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxPlayTime = -1;

        // #이 붙은 음계를 소문자로 변경
        m = m.replace("C#", "c")
             .replace("D#", "d")
             .replace("F#", "f")
             .replace("G#", "g")
             .replace("B#", "b")
             .replace("A#", "a");

        for (String music : musicinfos) {
            String[] mArr = music.split(",");
            int playTime = getPlayTime(mArr[0], mArr[1]);
            mArr[3] = mArr[3].replace("C#", "c")
                            .replace("D#", "d")
                            .replace("F#", "f")
                            .replace("G#", "g")
                            .replace("B#", "b")
                            .replace("A#", "a");

            // 실제 재생된 음악 문자열 생성
            String playedMusic = repeatString(mArr[3], playTime);
            
            if (playedMusic.contains(m) && playTime > maxPlayTime) {
                answer = mArr[2];
                maxPlayTime = playTime;
            }
        }

        return answer;
    }

    private int getPlayTime(String startTime, String endTime) {
        int sTime = Integer.parseInt(startTime.split(":")[0]) * 60 + Integer.parseInt(startTime.split(":")[1]);
        int eTime = Integer.parseInt(endTime.split(":")[0]) * 60 + Integer.parseInt(endTime.split(":")[1]);

        return eTime - sTime;
    }

    private static String repeatString(String str, int len) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() < len) {
            sb.append(str);
        }
        return sb.substring(0, len);
    }
}
