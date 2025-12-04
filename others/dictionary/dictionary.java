import java.util.*;

/**
 * 개선된 Radix Tree (압축 트라이) 구현 
 *
 * 제공 기능:
 * - insert(String word)
 * - search(String word)
 * - searchWithPrefix(String prefix) : 접두사로 시작하는 단어들을 사전순으로 반환
 *
 * 주요 개선점:
 * 1) 노드 분할(split) 후, split 노드와 새로 추가할 문자열의 시작 문자가 같을 경우
 *    덮어쓰기 대신 split 내부로 재귀 삽입하여 충돌 처리함.
 * 2) 접두사가 노드.key 내부에서 끝나는 경우를 정확히 처리함.
 * 3) TreeMap 사용으로 prefix 검색 결과가 사전순(lexicographic)으로 나옴.
 */
public class RadixTree {

    // 노드 내부 클래스
    static class Node {
        String key;                  // 이 노드가 보유한 압축된 문자열 (여러 문자 가능)
        boolean isWord;              // 이 노드가 어떤 단어의 끝인지 표시
        Map<Character, Node> child;  // 자식 노드들: key의 첫 글자 -> Node

        Node(String key) {
            this.key = key;
            // TreeMap을 사용하면 검색 결과가 항상 사전순으로 정렬됨
            this.child = new TreeMap<>();
            this.isWord = false;
        }
    }

    /*
        예시로 보는 Node 상태 (직관)
        
        트리에서 다음 문자열들이 들어가 있다고 하자: ["app", "apple", "application"]
        
        가능한 노드 구성(압축된 형태):
    
        root ("")
        
        child 'a' → Node key "app", isWord = true
        
        child 'l' → Node key "le", isWord = true
        
        child 'i' → Node key "cation", isWord = true
        
        각 노드의 의미:
        
        Node("app")은 루트부터 "app"까지의 문자열을 의미(그리고 isWord=true 이므로 "app" 자체가 단어).
        
        Node("le")은 "app" + le" = "apple" 전체 단어를 의미.
    */
    
    
    // 루트 노드 (빈 문자열)
    private final Node root = new Node("");

    // ----------------------------------------------------------
    // 유틸리티: 두 문자열의 공통 접두사 길이 반환
    // ----------------------------------------------------------
    private int commonPrefixLength(String a, String b) {
        int min = Math.min(a.length(), b.length());
        int i = 0;
        // 두 문자열을 앞에서부터 비교해서 처음 다른 인덱스에서 멈춤
        while (i < min && a.charAt(i) == b.charAt(i)) i++;
        return i;
    }

    // ----------------------------------------------------------
    // 공개 API: insert
    // ----------------------------------------------------------
    public void insert(String word) {
        if (word == null || word.isEmpty()) return;
        insert(root, word);
    }

    /**
     * 실제 삽입 로직 (재귀/반복)
     *
     * 동작 개요:
     * - 현재 노드의 key와 삽입할 word의 공통 접두사 길이를 계산한다.
     * - node.key가 word의 접두사이면(또는 빈 key이면) 나머지(rest)를 자식으로 내려가 삽입.
     * - node.key와 word가 중간까지 일치하면 현재 노드를 분할(split)하고 적절히 연결한다.
     * - 분할 후 새로 추가할 remainder의 첫 글자가 split.key의 첫 글자와 같으면
     *   split 내부로 재귀적으로 삽입하여 덮어쓰기 문제를 방지한다.
     */
    private void insert(Node node, String word) {
        for (;;) {
            int common = commonPrefixLength(node.key, word);

            // === Case A: node.key가 word의 접두사인 경우 ===
            if (common == node.key.length()) {
                String rest = word.substring(common); // node.key로 커버되지 않는 나머지

                // 나머지가 없다면 정확히 일치 -> 단어 종료 표시
                if (rest.isEmpty()) {
                    node.isWord = true;
                    return;
                }

                char nextChar = rest.charAt(0);

                // 해당 시작 문자로 내려갈 자식이 있으면 재귀적으로 내려감(continue)
                Node child = node.child.get(nextChar);
                if (child != null) {
                    node = child;
                    word = rest; // 이제 처리할 word는 남은 부분
                    continue;
                }

                // 자식이 없으면 rest 전체를 key로 가지는 새 노드를 만들어 끝 표시
                Node newNode = new Node(rest);
                newNode.isWord = true;
                node.child.put(nextChar, newNode);
                return;
            }

            // === Case B: node.key와 word가 일부만 일치(0 < common < node.key.length()) ===
            // 현재 노드를 분할(split)해야 함
            Node split = new Node(node.key.substring(common)); // 기존 node.key의 뒷부분을 split으로
            // 원래의 자식과 단어 끝 여부를 split으로 옮김
            split.child = node.child;
            split.isWord = node.isWord;

            // 현재 노드는 공통 접두사 부분만 갖도록 축소
            node.key = node.key.substring(0, common);
            node.child = new TreeMap<>(); // 새로 자식 맵 초기화
            node.isWord = false; // 기본값 (나중에 필요하면 true로 설정)

            // split을 현재 node의 자식으로 붙여줌
            node.child.put(split.key.charAt(0), split);

            // 만약 word가 정확히 공통 접두사에서 끝나면 현재 노드가 단어 종료
            if (common == word.length()) {
                node.isWord = true;
                return;
            }

            // 그렇지 않으면 word의 남은 부분을 추가해야 함
            String rest = word.substring(common);

            // 중요한 처리: rest의 시작 문자와 split의 시작 문자가 같다면
            // split을 덮어쓰는 대신 split 내부로 삽입해야 함.
            if (rest.charAt(0) == split.key.charAt(0)) {
                // split 노드 안으로 재귀적으로 삽입 (충돌 해결)
                insert(split, rest);
            } else {
                // 서로 다른 시작 문자라면 새로운 자식 노드로 추가
                Node newNode = new Node(rest);
                newNode.isWord = true;
                node.child.put(rest.charAt(0), newNode);
            }
            return;
        }
    }

    // ----------------------------------------------------------
    // 공개 API: search (정확 일치)
    // ----------------------------------------------------------
    public boolean search(String word) {
        if (word == null || word.isEmpty()) return false;
        return search(root, word);
    }

    /**
     * 검색 로직:
     * - node.key가 word의 현재 부분과 완전히 일치해야만 다음으로 진행.
     * - node.key 내부에서 불일치가 발생하면 false.
     * - 모든 글자를 소비했을 때 node.isWord가 true여야 true 반환.
     */
    private boolean search(Node node, String word) {
        while (true) {
            int common = commonPrefixLength(node.key, word);

            // node.key가 현재 word부분과 완전히 일치해야 함
            if (common == node.key.length()) {
                String rest = word.substring(common);
                // 더 이상 남은 문자가 없다면, node.isWord여부가 정답
                if (rest.isEmpty()) {
                    return node.isWord;
                }
                // 남아있다면 자식으로 내려가야 함
                Node child = node.child.get(rest.charAt(0));
                if (child == null) return false;
                node = child;
                word = rest;
            } else {
                // node.key 내부에서 불일치 -> 존재하지 않는 단어
                return false;
            }
        }
    }

    // ----------------------------------------------------------
    // 공개 API: searchWithPrefix (접두사 검색)
    // ----------------------------------------------------------
    public List<String> searchWithPrefix(String prefix) {
        List<String> result = new ArrayList<>();
        if (prefix == null || prefix.isEmpty()) return result;

        Node node = root;
        String remain = prefix;
        StringBuilder pathSoFar = new StringBuilder(); // 루트부터 현재 노드 직전까지 누적 문자열

        while (true) {
            int common = commonPrefixLength(node.key, remain);

            // --- 경우 1: prefix가 node.key 내부에서 끝나는 경우 (혹은 정확히 끝나는 경우) ---
            // 예: pathSoFar="app", node.key="le", remain="l" -> common==1 == remain.length()
            if (common == remain.length()) {
                // node.key의 offset(common) 이후부터 시작하는 위치를 기준으로 수집 시작
                collectFrom(node, pathSoFar.toString(), common, result);
                return result;
            }

            // --- 경우 2: node.key가 prefix의 일부(또는 동일)로 완전히 일치하는 경우 ---
            if (common == node.key.length()) {
                // node.key 전체를 pathSoFar에 합쳐서 더 내려갈 준비
                pathSoFar.append(node.key);
                remain = remain.substring(common);

                if (remain.isEmpty()) {
                    // prefix가 노드 경계에서 끝남 -> 이 노드 이하의 모든 단어 수집
                    collect(node, pathSoFar.toString(), result);
                    return result;
                }

                Node child = node.child.get(remain.charAt(0));
                if (child == null) return result; // 해당 문자로 내려갈 자식 없으면 빈 결과
                node = child;
                continue;
            }

            // --- 경우 3: node.key와 prefix가 불일치하여 prefix가 존재하지 않는 경우 ---
            return result;
        }
    }

    /**
     * collectFrom:
     * - node: 현재 노드
     * - prefixSoFar: node 앞까지의 전체 문자열 (node.key는 아직 포함되지 않음)
     * - offsetInNodeKey: node.key에서 prefix가 이미 포함된 길이 (예: prefix가 node.key의 앞 offset만큼 차지한 경우)
     *
     * 목적:
     * - prefix가 node.key 내부에서 끝난 상황을 처리하여, 해당 prefix를 포함하는 모든 단어를 수집한다.
     *
     * 예시:
     *  pathSoFar = "app", node.key = "le", offset = 1 (prefix "appl")
     *  -> fullWord(이 노드가 단어인 경우) = "app" + "le" = "apple"
     *  -> 수집은 curr = "app" + "le".substring(1) = "apple" 로 부터 자식들을 탐색
     */
    private void collectFrom(Node node, String prefixSoFar, int offsetInNodeKey, List<String> list) {
        // prefixSoFar + node.key.substring(offset) 는 prefix에 맞춰진 시작 문자열
        String curr = prefixSoFar + node.key.substring(offsetInNodeKey);

        // 전체 단어(이 노드가 온전한 key를 가진 경우)를 얻기 위해 fullWord 계산
        String fullWord = prefixSoFar + node.key; // node.key 전체를 더한 전체 단어

        // 만약 현재 node가 단어의 끝이면 fullWord를 결과에 추가
        if (node.isWord) list.add(fullWord);

        // curr는 prefix로부터의 시작점이므로, 자식들을 curr를 prefix로 하여 수집
        for (Node child : node.child.values()) {
            collect(child, curr, list); // 자식은 node 경계에서 시작하므로 collect 사용
        }
    }

    /**
     * collect:
     * - node: 현재 노드
     * - prefixSoFar: node 앞까지의 전체 문자열
     *
     * 동작:
     * - curr = prefixSoFar + node.key
     * - node.isWord이면 curr 추가
     * - 모든 자식들에 대해 재귀로 collect
     */
    private void collect(Node node, String prefixSoFar, List<String> list) {
        String curr = prefixSoFar + node.key;
        if (node.isWord) list.add(curr);

        for (Node child : node.child.values()) {
            collect(child, curr, list);
        }
    }

    // ----------------------------------------------------------
    // 간단한 테스트 헬퍼 (main)
    // ----------------------------------------------------------
    public static void main(String[] args) {
        RadixTree t = new RadixTree();

        // 샘플 삽입
        t.insert("apple");
        t.insert("application");
        t.insert("banana");
        t.insert("band");
        t.insert("bandage");
        t.insert("applet");
        t.insert("apply");
        t.insert("app");    // 내부 노드가 단어인 경우

        // 정확한 검색 테스트
        System.out.println("search(\"apple\") -> " + t.search("apple"));   // true
        System.out.println("search(\"app\") -> " + t.search("app"));       // true
        System.out.println("search(\"appl\") -> " + t.search("appl"));     // false
        System.out.println("search(\"candy\") -> " + t.search("candy"));   // false

        // 접두사 검색 테스트 (사전순 반환)
        System.out.print

