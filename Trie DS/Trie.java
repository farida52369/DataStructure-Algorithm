import java.util.HashMap;
import java.util.Map;

public class Trie {

    static class TrieNode {
        public Map<Character, TrieNode> children;
        public boolean terminated;

        public TrieNode() {
            this.children = new HashMap<>();
            this.terminated = false;
        }
    }

    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        // To insert into Trie DS
        TrieNode cur = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            char ch = word.charAt(i);
            if (!cur.children.containsKey(ch))
                cur.children.put(ch, new TrieNode());
            cur = cur.children.get(ch);
        }
        cur.terminated = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            char ch = word.charAt(i);
            if (!cur.children.containsKey(ch))
                return false;
            cur = cur.children.get(ch);
        }
        return cur.terminated;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        int len = prefix.length();
        for (int i = 0; i < len; i++) {
            char ch = prefix.charAt(i);
            if (!cur.children.containsKey(ch))
                return false;
            cur = cur.children.get(ch);
        }
        return true;
    }
}

// Implementation of Trie DS
// Problem Link: https://leetcode.com/problems/implement-trie-prefix-tree/
