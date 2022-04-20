import java.util.*;

public class WordBreakII {
    private Trie trie;

    private void dfs(String data, String temp, List<String> res, int index) {
        if (index >= data.length()) {
            res.add(temp);
            return;
        }

        for (int i = index + 1; i <= data.length(); i++) {
            if (trie.search(data.substring(index, i))) {
                String val = temp + data.substring(index, i) + ((i == data.length()) ? "" : " ");
                dfs(data, val, res, i);
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        // Constructing Trie Data Structure To Hold All word Dictionary
        trie = new Trie();
        for (String word : wordDict) {
            trie.insert(word);
        }

        List<String> res = new LinkedList<>();
        dfs(s, "", res, 0);
        return res;
    }
}

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
}

// Solve Word Break II Through Trie DS
// Problem Link: https://leetcode.com/problems/word-break-ii/
// THE SOLUTION NOT PERFECT BUT I DID IT ON MY OWN ..
