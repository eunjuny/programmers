import java.util.*;

public class RadixTree {

    static class Node {
        String key;                  // 노드가 가진 문자열 (compressed)
        boolean isWord;              // 단어의 끝 여부
        Map<Character, Node> child;  // 다음 노드들

        Node(String key) {
            this.key = key;
            this.child = new HashMap<>();
            this.isWord = false;
        }
    }

    private Node root = new Node("");

    // Insert ---------------------------------------------------------------------------------------------------
    public void insert(String word) {
        insert(root, word);
    }

    private void insert(Node node, String word) {
        for (;;) {
            // 공통 prefix 길이 계산
            int common = commonPrefixLength(node.key, word);

            // 1) node.key 가 word 의 prefix라면 (word가 더 김)
            if (common == node.key.length()) {
                String rest = word.substring(common);

                if (rest.isEmpty()) {      // 정확히 일치
                    node.isWord = true;
                    return;
                }

                char nextChar = rest.charAt(0);

                // 자식이 있는 경우 내려가기
                if (node.child.containsKey(nextChar)) {
                    node = node.child.get(nextChar);
                    word = rest;
                    continue;
                }

                // 자식이 없으면 새 노드 생성
                Node newNode = new Node(rest);
                newNode.isWord = true;
                node.child.put(nextChar, newNode);
                return;
            }

            // 2) 공통 prefix가 없는 경우: 분기 필요
            Node split = new Node(node.key.substring(common));
            split.child = node.child;
            split.isWord = node.isWord;

            node.key = node.key.substring(0, common);
            node.child = new HashMap<>();
            node.child.put(split.key.charAt(0), split);
            node.isWord = (common == word.length());

            if (common < word.length()) {
                String rest = word.substring(common);
                Node newNode = new Node(rest);
                newNode.isWord = true;
                node.child.put(rest.charAt(0), newNode);
            }

            return;
        }
    }

    private int commonPrefixLength(String a, String b) {
        int min = Math.min(a.length(), b.length());
        int i = 0;
        while (i < min && a.charAt(i) == b.charAt(i)) i++;
        return i;
    }

    // Search ---------------------------------------------------------------------------------------------------
    public boolean search(String word) {
        return search(root, word);
    }

    private boolean search(Node node, String word) {
        while (true) {
            int common = commonPrefixLength(node.key, word);

            if (common == node.key.length()) {
                String rest = word.substring(common);
                if (rest.isEmpty()) {
                    return node.isWord;
                }

                char next = rest.charAt(0);
                Node child = node.child.get(next);
                if (child == null) return false;

                node = child;
                word = rest;
            } else {
                return false;
            }
        }
    }

    // Prefix Search -------------------------------------------------------------------------------------------
    public List<String> searchWithPrefix(String prefix) {
        List<String> result = new ArrayList<>();
        Node node = root;
        String remain = prefix;

        // prefix로 내려가기
        while (true) {
            int common = commonPrefixLength(node.key, remain);

            if (common == node.key.length()) {
                remain = remain.substring(common);
                if (remain.isEmpty()) {
                    collect(node, prefix.substring(0, prefix.length() - node.key.length()), result);
                    return result;
                }
                char next = remain.charAt(0);
                if (!node.child.containsKey(next)) return result;
                node = node.child.get(next);
            } else {
                return result;
            }
        }
    }

    private void collect(Node node, String prefix, List<String> list) {
        String curr = prefix + node.key;
        if (node.isWord) list.add(curr);

        for (Node child : node.child.values()) {
            collect(child, curr, list);
        }
    }

    // Test -----------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        RadixTree t = new RadixTree();

        t.insert("apple");
        t.insert("application");
        t.insert("banana");

        System.out.println(t.search("apple"));       // true
        System.out.println(t.search("candy"));       // false

        System.out.println(t.searchWithPrefix("appl"));  // [apple, application]
        System.out.println(t.searchWithPrefix("c"));     // []
    }
}
