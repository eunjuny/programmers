class Solution {
    public String solution(int[] food) {
        StringBuilder builder = new StringBuilder();
        for (int i=1; i<food.length; i++) {
            int result = food[i] / 2;
            builder.append(String.valueOf(i).repeat(result));
        }
        String answer = builder + "0";
        return answer + builder.reverse();
    }
}

/*
StringBuilder와 StringBuffer는 둘 다 문자열을 변경할 수 있는 가변(mutable)한 문자열을 생성하는 클래스입니다. 이 두 클래스의 주요 차이점은 동기화(synchronization) 여부에 있습니다.

StringBuilder:

StringBuilder는 스레드 안전(thread-safe)하지 않습니다. 즉, 멀티스레드 환경에서 여러 스레드가 동시에 접근하면 안전하지 않을 수 있습니다.
StringBuilder는 내부적으로 동기화를 처리하지 않기 때문에 단일 스레드 환경에서 더 빠르게 동작할 수 있습니다.
Java 5부터 도입되었습니다.
StringBuffer:

StringBuffer는 스레드 안전(thread-safe)합니다. 여러 스레드에서 동시에 접근해도 안전하게 작동합니다.
StringBuffer는 내부적으로 동기화를 처리하여 여러 스레드가 안전하게 접근할 수 있도록 합니다.
Java의 초기 버전부터 존재하며, Java 1.0에서부터 제공되었습니다.
일반적으로 단일 스레드 환경에서는 StringBuilder를 사용하는 것이 성능상 이점이 있습니다. 그러나 멀티스레드 환경이거나 스레드에 대한 안전성이 필요한 경우에는 StringBuffer를 사용하는 것이 적합합니다.
*/
