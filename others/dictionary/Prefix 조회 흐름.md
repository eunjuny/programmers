아주 간단한 **prefix 검색 흐름**을
**일반 Trie 예시 구조와 함께** 설명해줄게.
think about it step-by-step

---

# ✅ **예시 Trie 구조**

```
root ("")
└ 'a'
   └ 'p'
      └ 'p'
         └ 'l'
            ├ 'e'  → "apple"
            └ 'i'  → "application"
```

여기에는 다음 단어가 들어있다고 가정함:

* **apple**
* **application**

---

# ✅ prefix 검색 흐름 (예: prefix="app")

아주 쉽게 설명한 버전.

---

## **1) root부터 prefix를 따라 내려감**

### ➤ root → 'a' 자식 찾기

prefix 첫 글자 `'a'`가 있으므로 `a` 노드로 이동
prefix 남은 부분: `"pp"`

```
root
 └ a
```

---

### ➤ 'a' → 'p' 자식 찾기

prefix 두 번째 글자 `'p'`가 있으므로 이동
prefix 남은 부분: `"p"`

```
a
 └ p
```

---

### ➤ 'p' → 다음 'p' 찾기

또 이동
prefix 남은 부분: `""` (모두 소비됨)

```
p
 └ p
```

---

## **2) prefix가 끝나는 지점 도달 → collect 시작**

prefix="app"은 여기까지 정확히 도달함:

```
root → a → p → p
```

이 노드는 아직 단어 끝은 아니지만
**여기 아래 있는 모든 단어가 prefix="app"로 시작함**

---

## **3) 아래로 모든 단어 수집 (DFS)**

현재 위치:

```
p
 └ l
    ├ e → apple
    └ i → application
```

### DFS 수집 과정

* "app" + "l" + "e" = **apple**
* "app" + "l" + "i" → + 나머지 = **application**

---

## **4) 최종 반환**

```
["apple", "application"]
```

---

# 🟦 요약

### ✔ 1) prefix 글자를 따라 트리 내려가서

**prefix가 끝나는 지점**을 정확히 찾는다.

### ✔ 2) 이 지점 아래에 있는 모든 단어를

**DFS로 전부 모아 리스트로 반환한다.**

### ✔ 3) 그래서 prefix="app" →

**apple / application** 둘 다 반환됨.

---

원하면 Radix Tree(압축 Trie) 버전도
이 예시처럼 노드 구조 그려서 설명해줄게!

