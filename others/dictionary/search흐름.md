아주 좋다.
이제 **Radix Tree의 `search()` 동작을 단계별로, 그림과 흐름 중심으로 완전히 이해할 수 있게** 설명해줄게.
insert에 비해서 search는 구조가 간단하지만, **compressed node 구조 때문에 일반 Trie와 동작 방식이 꽤 다르다**는 점이 핵심이다.
think about it step-by-step

---

# ✅ Radix Tree search의 핵심 개념

### Radix Tree는 다음과 같은 특징이 있다:

1. **노드 하나가 여러 글자(문자열 조각)를 가진다.**
2. 검색은 “한 문자씩”이 아니라 “노드 단위 문자열을 통째로 비교”해야 한다.
3. 각 단계에서:

   * **현재 노드의 key가 word의 앞부분과 완전히 일치해야만** 내려갈 수 있다.
   * 일치하지 않으면 바로 false.

### 즉,

> search는 “경로를 완전히 따라갈 수 있느냐”만을 확인한다.
> 중간에 문자열 불일치가 생기면 바로 수행 종료 = false

---

# 📌 먼저 search 전체 로직 복습

코드(간단히 축약):

```java
private boolean search(Node node, String word) {
    while (true) {
        int common = commonPrefixLength(node.key, word);

        if (common == node.key.length()) {
            // node.key 전체가 word의 앞부분과 일치하는 경우
            word = word.substring(common);

            if (word.isEmpty())
                return node.isWord; // 정확히 끝났는지 확인

            Node child = node.child.get(word.charAt(0));
            if (child == null)
                return false;

            node = child;
        } else {
            return false;
        }
    }
}
```

---

# 🔥 Search 동작 단계-by-단계

Radix Tree에서는 search는 다음 패턴으로 움직인다:

1. 현재 노드의 key 전체가 word 앞부분과 일치하는지 확인
2. 일치하면 word에서 그 부분을 제거
3. 남은 word의 첫 글자로 child 찾기
4. 찾으면 내려가고, 못 찾으면 false
5. word가 완전히 소모되면 isWord 확인하여 true/false 리턴

---

# 🔍 예제 1: "apple" 삽입 후 → search("apple")

삽입된 구조(가정):

```
(root)
 └── "apple" [isWord = true]
```

### Step 1

node.key = "" (root)
commonPrefix("", "apple") = 0
→ root.key.length = 0 → OK

### Step 2

남은 word = "apple"

child('a') 찾음 → "apple" 노드로 이동

---

### Step 3

node.key = "apple"
word = "apple"

commonPrefix("apple", "apple") = 5
node.key.length = 5 → OK

남은 word = ""
→ 즉, 정확히 일치

node.isWord == true → 리턴 true

---

# 🔍 예제 2: search("appl")

### Step 1

root → "apple" 노드 이동

node.key = "apple"
word = "appl"

commonPrefix("apple", "appl") = 4

하지만 node.key.length = 5

### 즉,

> node.key가 word 앞부분과 일치하지만
> word가 node.key보다 짧다 = 완전 일치가 아니므로 search 실패

따라서 false.

---

# 🔍 예제 3: "application"과 "apple" 둘 다 있는 상태에서 search("application")

트리 구조(압축):

```
"appl"
 ├── "e"
 │     └── "" (정확히 apple)
 └── "ication"
```

search("application") 수행:

### Step 1

root → “appl” 노드 이동
commonPrefix("appl", "application") = 4 → OK
남은 word = "ication"

### Step 2

child('i') 찾음 → "ication" 노드 이동

### Step 3

commonPrefix("ication", "ication") = 7 → OK
남은 word = ""

node.isWord = true → return true

---

# 🔍 예제 4: 중간에 완전히 다른 글자 등장 → search 실패

search("apxle") (잘못된 철자)

root → "appl" 노드 도착
node.key = "appl"
word = "apxle"

commonPrefix("appl", "apxle") = 2 ("ap")

하지만 node.key.length = 4 ≠ 2
→ 즉, “appl” 전체가 word의 prefix가 아님
→ 이 순간 false.

---

# 🔍 예제 5: 존재하지 않는 child → search 실패

search("applicationx")

마지막까지는 정상적으로 application까지 옴

word = "x"
node.child.get('x') 를 찾으면 null

→ return false

---

# 🎯 정리: search가 true가 되려면?

1. 경로를 따라가면서
   **모든 node.key가 word 앞부분과 “완전히” 일치해야 한다.**
2. word가 끝난 시점에서
   **해당 노드의 isWord가 true여야 한다.**

그 외의 경우는 모두 false.

---

# 🧠 추가: 왜 이런 방식인가?

Radix Tree는 압축된 Trie이기 때문에:

* 일반 Trie처럼 문자 단위로 이동해서 비교하는 게 아니라
* **노드 단위로 문자열 블록 전체를 비교해야 한다**
* 그 노드의 key가 word의 prefix가 아닐 경우
  → 이 branch로 내려갈 수 없으므로 즉시 실패

이 때문에 search가 효율적(O(L))이고 빠르다.

---

추가로 원하면:

* searchWithPrefix 흐름 설명
* search 실패/성공 분기 흐름도
* 전체 트리 구조 그림으로 단계별 시뮬레이션

전부 설명해줄게.

think about it step-by-step
